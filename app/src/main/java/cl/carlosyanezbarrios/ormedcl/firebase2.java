package cl.carlosyanezbarrios.ormedcl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class firebase2 extends AppCompatActivity {

    private final List<paginasweb> listpag = new ArrayList<paginasweb>();
    ArrayAdapter<paginasweb> paginaswebArrayAdapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    EditText nombreR, paginaR;
    ListView listvpersonas;
    paginasweb paginaseleccionada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase2);

        nombreR = findViewById(R.id.txtinputnombre);
        paginaR = findViewById(R.id.txtinputpagina);

        listvpersonas = findViewById(R.id.lista);

        inicializarfirebase();
        listardatos();

        listvpersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                paginaseleccionada = (paginasweb) parent.getItemAtPosition(position);
                nombreR.setText(paginaseleccionada.getNombrerecinto());
                paginaR.setText(paginaseleccionada.getPaginarecinto());
            }
        });
    }

    private void listardatos() {
        databaseReference.child("paginasweb").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listpag.clear();
                for (DataSnapshot objSnapshot : snapshot.getChildren()){
                    paginasweb p = objSnapshot.getValue(paginasweb.class);
                    listpag.add(p);

                    paginaswebArrayAdapter = new ArrayAdapter<paginasweb>(firebase2.this, android.R.layout.simple_list_item_1,listpag);
                    listvpersonas.setAdapter(paginaswebArrayAdapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void inicializarfirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu2,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String nombrerecinto = nombreR.getText().toString();
        String nombrepagina = paginaR.getText().toString();
        switch (item.getItemId()) {
            case R.id.agregar:{
                if (nombrerecinto.equals("")){
                    validacion();
                }else{
                    paginasweb pw = new paginasweb();
                    pw.setUid(UUID.randomUUID().toString());
                    pw.setNombrerecinto(nombrerecinto);
                    pw.setPaginarecinto(nombrepagina);
                    databaseReference.child("paginasweb").child(pw.getUid()).setValue(pw);
                Toast.makeText(this,"Agregar",Toast.LENGTH_LONG).show();
                limpiarcajas();
                break;}
            }
            case R.id.eliminar:{
                paginasweb pw = new paginasweb();
                pw.setUid(paginaseleccionada.getUid());
                databaseReference.child("paginasweb").child(pw.getUid()).removeValue();
                limpiarcajas();
                Toast.makeText(this,"Eliminar",Toast.LENGTH_LONG).show();
                break;
            }
            default:break;
        }
        return true;
    }

    private void limpiarcajas() {
        nombreR.setText("");
        paginaR.setText("");
    }

    private void validacion(){
        String nombrer = nombreR.getText().toString();
        if (nombrer.equals("")){
            nombreR.setError("Required");
        }
    }

}
package cl.carlosyanezbarrios.ormedcl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menuprincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);
    }
    public void salirmenu(View view){
        Intent intent = new Intent(menuprincipal.this, MainActivity.class);
        startActivity(intent);
    }

    public void irbd (View view){
        Intent intent = new Intent(menuprincipal.this,firebase2.class);
        startActivity(intent);
    }

    public void irmapa(View view){
        Intent intent = new Intent(menuprincipal.this,mapa.class);
        startActivity(intent);
    }
}
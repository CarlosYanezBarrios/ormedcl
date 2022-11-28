package cl.carlosyanezbarrios.ormedcl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irmenu(View view){
        Intent intent = new Intent(MainActivity.this, menuprincipal.class);
        startActivity(intent);
    }

    public void salirapp(View view){
        finish();
    }

    public void ircreditos(View view){
        Intent intent = new Intent(MainActivity.this,creditos.class);
        startActivity(intent);
    }
    public void irpoliticas(View view){
        Intent intent = new Intent(MainActivity.this, politicas.class);
        startActivity(intent);
    }
}
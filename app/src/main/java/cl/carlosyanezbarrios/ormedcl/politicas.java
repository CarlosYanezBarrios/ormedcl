package cl.carlosyanezbarrios.ormedcl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class politicas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_politicas);
    }
    public void salirpoliticas(View view){
        Intent intent = new Intent(politicas.this, MainActivity.class);
        startActivity(intent);
    }
}
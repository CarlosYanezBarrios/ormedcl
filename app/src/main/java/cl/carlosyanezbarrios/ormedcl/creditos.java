package cl.carlosyanezbarrios.ormedcl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class creditos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);
    }
    public void salircreditos(View view){
        Intent intent = new Intent(creditos.this,MainActivity.class);
        startActivity(intent);
    }
}
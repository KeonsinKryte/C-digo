package com.keonsinkryte.ecosistemas.free;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Historia extends AppCompatActivity {
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseDatabase db = FirebaseDatabase.getInstance();

    ImageView buscarHistorial;
    TextView tituloHistorial;
    Button hamburHistorial1, hamburHistorial2, hamburHistorial3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);

        hamburHistorial1= (Button) findViewById(R.id.historial_Hamburguesa1);
        hamburHistorial2= (Button) findViewById(R.id.historial_Hamburguesa2);
        hamburHistorial3= (Button) findViewById(R.id.historial_hamburguesa3);

        buscarHistorial= (ImageView) findViewById(R.id.historial_buscar);
        tituloHistorial= (TextView) findViewById(R.id.historial_titulo);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Bold.ttf");
        tituloHistorial.setTypeface(font);


        botonesHamburguesa();

    }

    private void botonesHamburguesa() {
        hamburHistorial1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Historia.this,MenuHamburguesa.class);
                startActivity(i);
            }
        });
        hamburHistorial2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Historia.this,MenuHamburguesa.class);
                startActivity(i);
            }
        });
        hamburHistorial3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Historia.this,MenuHamburguesa.class);
                startActivity(i);
            }
        });
    }
}


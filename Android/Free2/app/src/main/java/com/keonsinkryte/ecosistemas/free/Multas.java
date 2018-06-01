package com.keonsinkryte.ecosistemas.free;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Multas extends AppCompatActivity {

    Button multasHambur1, multasHambur2, multasHambur3;
    TextView multas_titulo;
    ImageView multas_buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multas);

        multas_buscar= (ImageView) findViewById(R.id.multas_buscar);
        multas_titulo= (TextView) findViewById(R.id.multas_Titulo);


        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Bold.ttf");
        multas_titulo.setTypeface(font);


        multasHambur1= (Button) findViewById(R.id.multas_Hamburguesa1);
        multasHambur2= (Button) findViewById(R.id.multas_Hamburguesa2);
        multasHambur3= (Button) findViewById(R.id.multas_hamburguesa3);

        botonesHamburguesa();


    }

    private void botonesHamburguesa() {
        multasHambur1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Multas.this, MenuHamburguesa.class);
                startActivity(i);
            }
        });
        multasHambur2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Multas.this, MenuHamburguesa.class);
                startActivity(i);
            }
        });
        multasHambur3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Multas.this, MenuHamburguesa.class);
                startActivity(i);
            }
        });
    }
}

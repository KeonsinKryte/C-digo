package com.keonsinkryte.ecosistemas.free;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Soporte extends AppCompatActivity {

    ImageView soporte_buscaro;
    TextView soporte_titulo;
    Button soporteHamburguesa1,soporteHamburguesa2,soporteHamburguesa3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soporte);

        soporte_buscaro= (ImageView) findViewById(R.id.soporte_buscar);

        soporte_titulo= (TextView) findViewById(R.id.soporte_titulo);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Bold.ttf");
        soporte_titulo.setTypeface(font);


        soporteHamburguesa1= (Button) findViewById(R.id.soporte_Hamburguesa1);
        soporteHamburguesa2= (Button) findViewById(R.id.soporte_Hamburguesa2);
        soporteHamburguesa3= (Button) findViewById(R.id.soporte_hamburguesa3);


        soporteHamburguesa();


    }

    private void soporteHamburguesa() {
        soporteHamburguesa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Soporte.this,MenuHamburguesa.class);
                startActivity(i);
            }
        });
        soporteHamburguesa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Soporte.this,MenuHamburguesa.class);
                startActivity(i);
            }
        });
        soporteHamburguesa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Soporte.this,MenuHamburguesa.class);
                startActivity(i);
            }
        });
    }
}

package com.keonsinkryte.ecosistemas.free;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Companeros extends AppCompatActivity {

    Button menuHamburguesaCompa1, menuHamburguesaCompa2, menuHamburguesaCompa3;
    TextView titulo_compa;
    ImageView buscar_compa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companeros);

        menuHamburguesaCompa1= (Button) findViewById(R.id.Compa_Hamburguesa1);
        menuHamburguesaCompa2= (Button) findViewById(R.id.Compa_Hamburguesa2);
        menuHamburguesaCompa3= (Button) findViewById(R.id.Compa_hamburguesa3);

        botonesHamburguesa();

        buscar_compa= (ImageView) findViewById(R.id.buscar_compa);
        titulo_compa= (TextView) findViewById(R.id.titulo_compa);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Bold.ttf");
        titulo_compa.setTypeface(font);




    }

    private void botonesHamburguesa() {
        menuHamburguesaCompa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Companeros.this,MenuHamburguesa.class);
                startActivity(i);
            }
        });

        menuHamburguesaCompa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Companeros.this,MenuHamburguesa.class);
                startActivity(i);
            }
        });

        menuHamburguesaCompa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Companeros.this,MenuHamburguesa.class);
                startActivity(i);
            }
        });

    }
}

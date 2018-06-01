package com.keonsinkryte.ecosistemas.free;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Reserva extends AppCompatActivity {

    ImageView individual1,grupal,buscar;
    int silla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        Bundle bundle= getIntent().getExtras();

        if(bundle!= null){
            silla= bundle.getInt("Silla");
        }
        individual1= (ImageView) findViewById(R.id.botonIndividual);
        buscar= (ImageView) findViewById(R.id.reserva_buscar);
        grupal= (ImageView) findViewById(R.id.reservaGrupal);

        individual1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Reserva.this,FormularioReservaIndividual.class);
                i.putExtra("sillaReservar",silla);
                startActivity(i);
            }
        });

        grupal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Reserva.this,FormularioReservaIndividual.class);
                startActivity(i);
            }
        });
    }
}

package com.keonsinkryte.ecosistemas.free;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Reglamento extends AppCompatActivity {

    TextView reglamentoTItulo, reglamento;
    ImageView reglamento_Buscar;
    Button reglaHamburguesa1, reglaHamburguesa2, reglaHamburguesa3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reglamento);

        reglaHamburguesa1= (Button) findViewById(R.id.regla_Hamburguesa1);
        reglaHamburguesa2= (Button) findViewById(R.id.regla_Hamburguesa2);
        reglaHamburguesa3= (Button) findViewById(R.id.regla_hamburguesa3);

        reglamentoTItulo= (TextView) findViewById(R.id.reglamento_titulo);
        reglamento_Buscar= (ImageView) findViewById(R.id.reglamento_buscar);

        reglamento= (TextView) findViewById(R.id.reglas);

        Typeface font2 = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Regular.ttf");
        reglamento.setTypeface(font2);


        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Bold.ttf");
        reglamentoTItulo.setTypeface(font);


        reglamentoHamburguesa();


    }

    private void reglamentoHamburguesa() {
        reglaHamburguesa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Reglamento.this, MenuHamburguesa.class);
                startActivity(i);
            }
        });

        reglaHamburguesa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Reglamento.this, MenuHamburguesa.class);
                startActivity(i);
            }
        });

        reglaHamburguesa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Reglamento.this, MenuHamburguesa.class);
                startActivity(i);
            }
        });
    }
}

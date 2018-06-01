package com.keonsinkryte.ecosistemas.free;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MenuHamburguesa extends AppCompatActivity {

    Button inicio, historial, multas, companeros, reglamento, soporte, salir;
    TextView usuarioTItulo, puntajeUsuario;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_hamburguesa);
        mAuth= FirebaseAuth.getInstance();
        usuarioTItulo= (TextView) findViewById(R.id.Menu_usuario);
        puntajeUsuario=( TextView) findViewById(R.id.menu_puntuacion);


        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Bold.ttf");
        usuarioTItulo.setTypeface(font);
        puntajeUsuario.setTypeface(font);



        inicio= (Button) findViewById(R.id.menu_inicio);
        historial= (Button) findViewById(R.id.menu_historial);
        multas= (Button) findViewById(R.id.menu_multas);
        companeros= (Button) findViewById(R.id.menu_companeros);
        reglamento= (Button) findViewById(R.id.menu_reglamento);
        soporte= (Button) findViewById(R.id.menu_soporte);
        salir= (Button) findViewById(R.id.menu_salir);

        botonesMenu();

    }

    private void botonesMenu() {
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuHamburguesa.this,Sala.class);
                startActivity(i);
            }
        });

        historial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuHamburguesa.this,Historia.class);
                startActivity(i);
            }
        });

        companeros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuHamburguesa.this,Companeros.class);
                startActivity(i);
            }
        });

        reglamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuHamburguesa.this,Reglamento.class);
                startActivity(i);
            }
        });

        soporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuHamburguesa.this,Soporte.class);
                startActivity(i);
            }
        });


        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuHamburguesa.this,Login.class);
                mAuth.signOut();
                startActivity(i);
            }
        });

        multas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuHamburguesa.this,Multas.class);
                startActivity(i);
            }
        });
    }
}

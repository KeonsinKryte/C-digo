package com.keonsinkryte.ecosistemas.free;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormularioReservaIndividual extends AppCompatActivity {
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    TextView tituloFormulario, infoSalaFormulario, horallegada,horasalida,necesitas,software;
    EditText ed_horallegada,ed_horasalida,ed_software;
    CheckBox si,no;
    int silla;


    boolean necesitoPC;

    Button reservar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_reserva_individual);

        final DatabaseReference ref = db.getReference("RESERVA");


        ed_horallegada=( EditText) findViewById(R.id.ed_horallegada);
        ed_horasalida= (EditText) findViewById(R.id.ed_horasalida);
        ed_software=(EditText) findViewById(R.id.ed_software);

        Bundle bundle= getIntent().getExtras();

        if(bundle!=null){
        silla= bundle.getInt("sillaReservar");
        }

        tituloFormulario= (TextView) findViewById(R.id.titulo_formulario);
        infoSalaFormulario= (TextView) findViewById(R.id.formulario_infoSala);
        horallegada= (TextView) findViewById(R.id.horallegada);
        horasalida= (TextView) findViewById(R.id.horasalida);
        necesitas= (TextView) findViewById(R.id.necesitacomputador);
        software= (TextView) findViewById(R.id.software);

        si = (CheckBox) findViewById(R.id.check_si);
        no = (CheckBox) findViewById(R.id.check_no);

        if(si.isChecked() == true){
            necesitoPC = true;
        }
        if(no.isChecked() == true){
            necesitoPC = false;
        }
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Bold.ttf");
        tituloFormulario.setTypeface(font);


        Typeface font2 = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Regular.ttf");
        infoSalaFormulario.setTypeface(font2);
        horallegada.setTypeface(font2);
        horasalida.setTypeface(font2);
        necesitas.setTypeface(font2);
        software.setTypeface(font2);


        reservar= (Button) findViewById(R.id.botonReservar);

        reservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("SALAS").child("305C").child(String.valueOf(silla)).setValue(new Form(ed_horallegada.getText().toString(), ed_horasalida.getText().toString(),
                        necesitoPC, ed_software.getText().toString() , silla, false, String.valueOf(mAuth.getCurrentUser().getUid())));
                Intent i= new Intent(FormularioReservaIndividual.this,Sala.class);

                startActivity(i);

                Toast.makeText(getApplicationContext(),"Reserva realizada con Exito", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

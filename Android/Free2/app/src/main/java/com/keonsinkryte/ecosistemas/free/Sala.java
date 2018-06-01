package com.keonsinkryte.ecosistemas.free;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Sala extends AppCompatActivity {

    FirebaseDatabase db = FirebaseDatabase.getInstance();

    TextView sala, sala_info;

    Button silla1;
    boolean silla1b;

    TextView valTemp, valMic, valPers;

    Button menuHamburguesa1, menuHamburguesa2, menuHamburguesa3;
    Button silla2, silla3, silla4, silla5, silla6, silla7, silla8, silla9, silla10, silla11, silla12, silla13, silla14;
    boolean silla2b, silla3b, silla4b, silla5b, silla6b, silla7b, silla8b, silla9b, silla10b, silla11b, silla12b, silla13b, silla14b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala2);
        DatabaseReference refVal = db.getReference("SALAS").child("305C");
        DatabaseReference refReserva;
        DatabaseReference refReservad;

        silla1b = true;
        silla2b = true;
        silla3b = true;
        silla4b = true;
        silla5b = true;
        silla6b = true;
        silla7b = true;
        silla8b = true;
        silla9b = true;
        silla10b = true;
        silla11b = true;
        silla12b = true;
        silla13b = true;
        silla14b = true;

        for (int i = 1; i < 15; i++) {
            refReserva = db.getReference("RESERVA").child("SALAS").child("305C").child(String.valueOf(i));
            refReserva.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Form form = dataSnapshot.getValue(Form.class);
                    if (form != null) {
                        if (form.getNumSilla() == 1) {
                            silla1b = false;
                            silla1.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.nosotros));
                        }
                        if (form.getNumSilla() == 2) {
                            silla2b = false;
                            silla2.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.nosotros));
                        }
                        if (form.getNumSilla() == 3) {
                            silla1b = false;
                            silla3.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.nosotros));
                        }
                        if (form.getNumSilla() == 4) {
                            silla2b = false;
                            silla4.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.nosotros));
                        }
                        if (form.getNumSilla() == 5) {
                            silla1b = false;
                            silla5.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.nosotros));
                        }
                        if (form.getNumSilla() == 6) {
                            silla2b = false;
                            silla6.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.nosotros));
                        }
                        if (form.getNumSilla() == 7) {
                            silla1b = false;
                            silla7.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.nosotros));
                        }
                        if (form.getNumSilla() == 8) {
                            silla2b = false;
                            silla8.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.nosotros));
                        }
                        if (form.getNumSilla() == 9) {
                            silla1b = false;
                            silla9.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.nosotros));
                        }
                        if (form.getNumSilla() == 10) {
                            silla2b = false;
                            silla10.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.nosotros));
                        }
                        if (form.getNumSilla() == 11) {
                            silla1b = false;
                            silla11.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.nosotros));
                        }
                        if (form.getNumSilla() == 12) {
                            silla2b = false;
                            silla12.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.nosotros));
                        }
                        if (form.getNumSilla() == 13) {
                            silla1b = false;
                            silla13.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.nosotros));
                        }
                        if (form.getNumSilla() == 14) {
                            silla2b = false;
                            silla14.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.nosotros));
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

        sala = (TextView) findViewById(R.id.sala);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Bold.ttf");
        sala.setTypeface(font);

        silla1 = (Button) findViewById(R.id.silla1);
        silla2 = (Button) findViewById(R.id.silla2);
        silla3 = (Button) findViewById(R.id.silla3);
        silla4 = (Button) findViewById(R.id.silla4);
        silla5 = (Button) findViewById(R.id.silla5);
        silla6 = (Button) findViewById(R.id.silla6);
        silla7 = (Button) findViewById(R.id.silla7);
        silla8 = (Button) findViewById(R.id.silla8);
        silla9 = (Button) findViewById(R.id.silla9);
        silla10 = (Button) findViewById(R.id.silla10);
        silla11 = (Button) findViewById(R.id.silla11);
        silla12 = (Button) findViewById(R.id.silla12);
        silla13 = (Button) findViewById(R.id.silla13);
        silla14 = (Button) findViewById(R.id.silla14);

        botonesSilla();

        refVal.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Sal sal = dataSnapshot.getValue(Sal.class);
                valTemp.setText("Temperatura: " + sal.getValTemp().toString() + " °C");
                valMic.setText("Nivel de ruido: " + sal.getValMic().toString() + " db");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        refReservad = db.getReference("RESERVA").child("SALAS").child("305C");
        refReservad.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valPers.setText("Personas: "+String.valueOf(dataSnapshot.child("RESERVA").child("SALAS").child("305C").getChildrenCount()));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        valTemp = findViewById(R.id.valTemp);
        valMic = findViewById(R.id.valMic);
        sala_info = (TextView) findViewById(R.id.sala_informacion);
        valPers = findViewById(R.id.valPers);

        Typeface font2 = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Regular.ttf");
        valTemp.setTypeface(font2);
        sala_info.setTypeface(font2);
        valPers.setTypeface(font2);
        valMic.setTypeface(font2);
        valPers.setTypeface(font2);


        menuHamburguesa1 = (Button) findViewById(R.id.Menu_Hamburguesa1);
        menuHamburguesa2 = (Button) findViewById(R.id.Menu_Hamburguesa2);
        menuHamburguesa3 = (Button) findViewById(R.id.Menu_hamburguesa3);

        botonesHamburguesa();


    }

    public void ejecucion(int numSilla) {
        Intent i = new Intent(Sala.this, Reserva.class);
        i.putExtra("Silla", numSilla);
        startActivity(i);
    }

    private void botonesHamburguesa() {
        menuHamburguesa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Sala.this, MenuHamburguesa.class);
                startActivity(i);
            }
        });

        menuHamburguesa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Sala.this, MenuHamburguesa.class);
                startActivity(i);
            }
        });

        menuHamburguesa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Sala.this, MenuHamburguesa.class);
                startActivity(i);
            }
        });
    }

    private void botonesSilla() {



        silla1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (silla1b) {
                    ejecucion(1);
                } else {
                    Toast.makeText(getApplicationContext(), "Intenta con otro espacio", Toast.LENGTH_SHORT).show();
                }
            }
        });

        silla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (silla2b) {
                    ejecucion(2);
                } else {
                    Toast.makeText(getApplicationContext(), "Intenta con otro espacio", Toast.LENGTH_SHORT).show();
                }
            }

        });


        silla3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (silla3b) {
                    ejecucion(3);
                } else {
                    Toast.makeText(getApplicationContext(), "Intenta con otro espacio", Toast.LENGTH_SHORT).show();
                }
            }
        });


        silla4.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (silla4b) {
                    ejecucion(4);
                } else {
                    Toast.makeText(getApplicationContext(), "Intenta con otro espacio", Toast.LENGTH_SHORT).show();
                }
            }
        });


        silla5.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (silla5b) {
                    ejecucion(5);
                } else {
                    Toast.makeText(getApplicationContext(), "Intenta con otro espacio", Toast.LENGTH_SHORT).show();
                }
            }
        });


        silla6.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (silla6b) {
                    ejecucion(6);
                } else {
                    Toast.makeText(getApplicationContext(), "Intenta con otro espacio", Toast.LENGTH_SHORT).show();
                }
            }

        });


        silla7.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (silla7b) {
                    ejecucion(7);
                } else {
                    Toast.makeText(getApplicationContext(), "Intenta con otro espacio", Toast.LENGTH_SHORT).show();
                }
            }
        });


        silla8.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (silla8b) {
                    ejecucion(8);
                } else {
                    Toast.makeText(getApplicationContext(), "Intenta con otro espacio", Toast.LENGTH_SHORT).show();
                }

            }
        });


        silla9.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (silla9b) {
                    ejecucion(9);
                } else {
                    Toast.makeText(getApplicationContext(), "Intenta con otro espacio", Toast.LENGTH_SHORT).show();
                }
            }
        });


        silla10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (silla10b) {
                    ejecucion(10);
                } else {
                    Toast.makeText(getApplicationContext(), "Intenta con otro espacio", Toast.LENGTH_SHORT).show();
                }
            }
        });


        silla11.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (silla11b) {
                    ejecucion(11);
                } else {
                    Toast.makeText(getApplicationContext(), "Intenta con otro espacio", Toast.LENGTH_SHORT).show();
                }
            }
        });


        silla12.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (silla12b) {
                    ejecucion(12);
                } else {
                    Toast.makeText(getApplicationContext(), "Intenta con otro espacio", Toast.LENGTH_SHORT).show();
                }
            }
        });


        silla13.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (silla13b) {
                    ejecucion(13);
                } else {
                    Toast.makeText(getApplicationContext(), "Intenta con otro espacio", Toast.LENGTH_SHORT).show();
                }
            }
        });


        silla14.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (silla14b) {
                    ejecucion(14);
                } else {
                    Toast.makeText(getApplicationContext(), "Intenta con otro espacio", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

package com.keonsinkryte.ecosistemas.free;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    EditText usuario, contrasena;
    FirebaseDatabase db;
    FirebaseAuth mAuth;
    Button login_ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = (EditText) findViewById(R.id.Login_usuario);
        contrasena = (EditText) findViewById(R.id.Login_contrasena);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        if(mAuth.getCurrentUser()!=null){
            Intent i= new Intent(Login.this,Sala.class);
            startActivity(i);
        }

        login_ingresar = (Button) findViewById(R.id.botonIngresar);

        login_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarUsuario();
            }
        });
    }

    public void iniciarUsuario() {
        mAuth.signInWithEmailAndPassword(usuario.getText().toString(), contrasena.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Sesión iniciada", Toast.LENGTH_SHORT).show();
                    FirebaseUser u = mAuth.getCurrentUser();
                    updateUI(u);
                } else {
                    Toast.makeText(getApplicationContext(), "Intenta nuevamente", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void registrarUsuario() {
        mAuth.createUserWithEmailAndPassword(usuario.getText().toString(), contrasena.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Usuario Creado", Toast.LENGTH_SHORT).show();
                    String uid = mAuth.getCurrentUser().getUid();
                    User user = new User(usuario.getText().toString(), contrasena.getText().toString(), uid, uid, 5);
                    DatabaseReference ref = db.getReference("USUARIOS").child(uid);
                    FirebaseUser u = mAuth.getCurrentUser();
                    updateUI(u);
                    ref.setValue(user);

                } else {
                    Toast.makeText(Login.this, "" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void updateUI(FirebaseUser u) {
        if (u != null) {
            Intent i = new Intent(getApplicationContext(), Sala.class);
            startActivity(i);
        }
    }
}

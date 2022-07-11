package com.icet.restaurante;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private EditText edit_email;
    private EditText edit_senha;

    private CheckBox ckc_mostrar_senha;
    private Button btn_login;
   // private ProgressBar loginProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        edit_email = findViewById(R.id.edit_email);
        edit_senha = findViewById(R.id.edit_senha);
        btn_login = findViewById(R.id.btn_login);
        ckc_mostrar_senha = findViewById(R.id.ckb_mostrar_senha);
        //loginProgressBar = findViewById(R.id.progressBar);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginEmail = edit_email.getText().toString();
                String loginSenha = edit_senha.getText().toString();

                if (!TextUtils.isEmpty(loginEmail) || !TextUtils.isEmpty(loginSenha)) {
                    //loginProgressBar.setVisibility(View.INVISIBLE);
                    mAuth.signInWithEmailAndPassword(loginEmail, loginSenha)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                abrirTelaHome();
                            } else {
                                String error = task.getException().getMessage();
                                Toast.makeText(LoginActivity.this, "" +error , Toast.LENGTH_SHORT).show();
                                // loginProgressBar.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                }
            }
        });

        ckc_mostrar_senha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    edit_senha.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    edit_senha.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }

    private void abrirTelaHome() {
        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

}
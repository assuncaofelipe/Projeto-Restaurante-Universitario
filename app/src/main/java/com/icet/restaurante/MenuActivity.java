package com.icet.restaurante;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button btn_logout;
    private ImageView btn_fichas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mAuth = FirebaseAuth.getInstance();
        btn_logout = findViewById(R.id.btn_sair);
        btn_fichas = findViewById(R.id.btn_fichas);

        btn_fichas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirTelaFichas();
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }

    private void abrirTelaFichas() {
        Intent intent = new Intent(MenuActivity.this, FichasActivity.class);
        startActivity(intent);
    }

    private void logout() {
        mAuth.signOut();
        Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
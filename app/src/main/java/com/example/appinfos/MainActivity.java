package com.example.appinfos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnFinanceiro, btnEducacao, btnSaude, btnInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFinanceiro = findViewById(R.id.btnFinanceiro);
        btnEducacao = findViewById(R.id.btnEducacao);
        btnSaude = findViewById(R.id.btnSaude);
        btnInfos = findViewById(R.id.btnInfo);

        btnFinanceiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Financeiro.class);
                startActivity(intent);
            }
        });

        btnEducacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Educacao.class);
                startActivity(intent);
            }
        });

        btnSaude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Saude.class);
                startActivity(intent);
            }
        });

        btnInfos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Informacoes.class);
                startActivity(intent);
            }
        });

    }
}
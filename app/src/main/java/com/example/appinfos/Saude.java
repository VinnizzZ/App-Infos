package com.example.appinfos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Saude extends AppCompatActivity {

    Button calcSaude, voltar, limpar;
    EditText peso, altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saude);

        calcSaude = findViewById(R.id.btnCalcSaude);
        voltar = findViewById(R.id.btnVoltarSaude);
        limpar = findViewById(R.id.btnLimparSaude);
        peso = findViewById(R.id.textInputPeso);
        altura = findViewById(R.id.textInputAltura);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                peso.setText("");
                altura.setText("");
            }
        });

        calcSaude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Saude.this, SaudeResultado.class);
                intent.putExtra("peso", peso.getText().toString());
                intent.putExtra("altura", altura.getText().toString());
                startActivity(intent);
            }
        });

    }
}
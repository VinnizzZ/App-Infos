package com.example.appinfos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Educacao extends AppCompatActivity {

    Button calcEduc, voltar, limpar;
    EditText NI, PO, PI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educacao);


        calcEduc = findViewById(R.id.btnCalcEducacao);
        voltar = findViewById(R.id.btnVoltarEduc);
        limpar = findViewById(R.id.btnLimparEduc);
        NI = findViewById(R.id.textInputNI);
        PO = findViewById(R.id.textInputPO);
        PI = findViewById(R.id.textInputPI);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NI.setText("");
                PO.setText("");
                PI.setText("");
            }
        });

        calcEduc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Educacao.this, EducacaoResultado.class);
                intent.putExtra("NI", NI.getText().toString());
                intent.putExtra("PO", PO.getText().toString());
                intent.putExtra("PI", PI.getText().toString());
                startActivity(intent);
            }
        });

    }
}
package com.example.appinfos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Financeiro extends AppCompatActivity {

    EditText inputSalario;
    Button btnCalcSalario, voltar, limpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financeiro);

        inputSalario = findViewById(R.id.textInputSalario);
        btnCalcSalario = findViewById(R.id.btnCalcFinanceiro);
        voltar = findViewById(R.id.btnVoltarFinanc);
        limpar = findViewById(R.id.btnLimparFinanc);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSalario.setText("");
            }
        });

        btnCalcSalario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Financeiro.this, FinanceiroResultado.class);
                intent.putExtra("salario", inputSalario.getText().toString());
                startActivity(intent);
            }
        });

    }
}
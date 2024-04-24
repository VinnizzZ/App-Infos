package com.example.appinfos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SaudeResultado extends AppCompatActivity {

    TextView peso, altura, IMC, relatorio;
    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saude_resultado);

        peso = findViewById(R.id.textPesoRe);
        altura = findViewById(R.id.textAlturaRe);
        IMC = findViewById(R.id.textIMCRe);
        relatorio = findViewById(R.id.textRelatorioRe);
        voltar = findViewById(R.id.btnVoltarSaudeRe);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        String txtPeso = intent.getStringExtra("peso");
        String txtAltura = intent.getStringExtra("altura");

        double calcIMC = Float.parseFloat(txtPeso) / Math.pow(Float.parseFloat(txtAltura), 2);
        BigDecimal bd = new BigDecimal(calcIMC).setScale(1, RoundingMode.HALF_EVEN);

        String txtRelatorio = " ";

        if(calcIMC < 17){
            txtRelatorio = "Muito abaixo do peso";
        }else if(calcIMC >= 17 && calcIMC < 18.5){
            txtRelatorio = "Abaixo do peso";
        }else if(calcIMC >= 18.5 && calcIMC < 25){
            txtRelatorio = "Peso normal";
        }else if(calcIMC >= 25 && calcIMC < 30){
            txtRelatorio = "Acima do peso";
        }else if(calcIMC >= 30 && calcIMC < 35){
            txtRelatorio = "Obesidade grau I";
        }else if(calcIMC >= 35 && calcIMC <= 40){
            txtRelatorio = "Obesidade grau II";
        }else if(calcIMC > 40){
            txtRelatorio = "Obesidade grau III";
        }

        peso.setText(txtPeso);
        altura.setText(txtAltura);
        IMC.setText(bd.toString());
        relatorio.setText(txtRelatorio);

    }
}
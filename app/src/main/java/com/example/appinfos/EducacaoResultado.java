package com.example.appinfos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class EducacaoResultado extends AppCompatActivity {

    TextView txtNI, txtPO, txtPI, txtMedia, txtResultado;
    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educacao_resultado);

        txtNI = findViewById(R.id.textNIRe);
        txtPO = findViewById(R.id.textPORe);
        txtPI = findViewById(R.id.textPIRe);
        txtMedia = findViewById(R.id.textMediaRe);
        txtResultado = findViewById(R.id.textResultadoRe);
        voltar = findViewById(R.id.btnVoltarEducRE);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        String notaNI = intent.getStringExtra("NI");
        String notaPO = intent.getStringExtra("PO");
        String notaPI = intent.getStringExtra("PI");

        double media = (Float.parseFloat(notaNI) * 0.2) + (Float.parseFloat(notaPO) * 0.5) + (Float.parseFloat(notaPI) * 0.3);
        BigDecimal bd = new BigDecimal(media).setScale(1, RoundingMode.HALF_EVEN);
        String resultado = " ";

        if(media <= 5){
            resultado = "Reprovado";
        }else if(media > 5){
            resultado = "Aprovado";
        }

        txtNI.setText(notaNI);
        txtPO.setText(notaPO);
        txtPI.setText(notaPI);
        txtMedia.setText(bd.toString());
        txtResultado.setText(resultado);



    }
}
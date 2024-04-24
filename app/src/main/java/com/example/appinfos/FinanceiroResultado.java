package com.example.appinfos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinanceiroResultado extends AppCompatActivity {

    TextView salarioBruto, INSS, FGTS, salarioLiquido;
    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financeiro_resultado);

        salarioBruto = findViewById(R.id.textSalarioBrutoRe);
        INSS = findViewById(R.id.textDescontoINSSRe);
        FGTS = findViewById(R.id.textDescontoFGTSRe);
        salarioLiquido = findViewById(R.id.textSalarioLiquidoRe);
        voltar = findViewById(R.id.btnVoltarFinancRe);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        String txtSalario = intent.getStringExtra("salario");
        float Salario = Float.parseFloat(txtSalario);
        double descINSS = 0;
        double descFGTS = Salario * 0.08;

        if(Salario <= 1412.00){
            descINSS = Salario * 0.075;
        } else if(Salario <= 2666.68 && Salario > 1412.00){
            descINSS = Salario * 0.09;
        } else if(Salario <= 4000.03 && Salario > 2666.68){
            descINSS = Salario * 0.12;
        }else if(Salario > 4000.03){
            descINSS = Salario * 0.14;
        }
        double salarioLiq = Salario - (descINSS + descFGTS);

        salarioBruto.setText(txtSalario);
        INSS.setText(Double.toString(descINSS));
        FGTS.setText(Double.toString(descFGTS));
        salarioLiquido.setText(Double.toString(salarioLiq));

    }
}
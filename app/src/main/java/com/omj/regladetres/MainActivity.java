package com.omj.regladetres;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etA, etB, etC, etD, etCol1, etCol2;
    TextView tvResultado;
    Button btCalcular;

    Double a;
    Double b;
    Double c;
    Double d;
    Double res;
    Integer entero;
    String col;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etA = findViewById(R.id.et_a);
        etB = findViewById(R.id.et_b);
        etC = findViewById(R.id.et_c);
        etD = findViewById(R.id.et_d);
        etCol1 = findViewById(R.id.et_col1);
        etCol2 = findViewById(R.id.et_col2);
        tvResultado = findViewById(R.id.tv_resultado);
        btCalcular = findViewById(R.id.bt_calcular);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    a = Double.parseDouble(etA.getText().toString());
                }catch (Exception e){
                    a = 0.0;
                }

                try {
                    b = Double.parseDouble(etB.getText().toString());
                }catch (Exception e){
                    b = 0.0;
                }

                try {
                    c = Double.parseDouble(etC.getText().toString());
                }catch (Exception e){
                    c = 0.0;
                }

                try {
                    d = Double.parseDouble(etD.getText().toString());
                }catch (Exception e){
                    d = 0.0;
                }

                if(c==0.0){
                    res = (a*d)/b;
                    col = etCol1.getText().toString();
                }else if(d==0.0){
                    res =(b*c)/a;
                    col = etCol2.getText().toString();
                }else{
                    res = 0.0;
                    Toast.makeText(MainActivity.this,"Debe dejar una variable en blanco", Toast.LENGTH_LONG).show();
                }

                entero = (int) Math.floor(res);
                if((entero-res)==0){
                    tvResultado.setText(entero.toString() +" "+ col);
                }
                else{
                    Double red = Math.round(res*10.0)/10.0;//redondeo 1 decimal
                    tvResultado.setText(red.toString()+" "+ col);
                }
            }
        });
    }


}
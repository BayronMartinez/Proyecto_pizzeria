package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class boleta_act extends AppCompatActivity {

    private EditText nroBoleta, cliente, producto, costo, direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boleta_act);

        nroBoleta = (EditText)findViewById(R.id.ed_boleta);
        cliente = (EditText)findViewById(R.id.ed_cliente);
        producto = (EditText)findViewById(R.id.ed_producto);
        costo = (EditText)findViewById(R.id.ed_costo);
        direccion = (EditText)findViewById(R.id.ed_direccion);
    }


}
package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Clases.Presios;

public class pizzas extends AppCompatActivity {

    private Spinner pizzas;
    private EditText cobro;
    private TextView vuelto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzas);

        pizzas = (Spinner)findViewById(R.id.spn_pizzas);
        cobro = (EditText)findViewById(R.id.ed_cobro);
        vuelto = (TextView)findViewById(R.id.txt_vuelto);

        ArrayList<String> productos = (ArrayList<String>) getIntent().getSerializableExtra("productos");
        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productos);
        pizzas.setAdapter(adapt);
    }

    public void compra(View v)
    {
        Presios presio = new Presios();
        int pago = Integer.parseInt(cobro.getText().toString());
        String elegido = pizzas.getSelectedItem().toString();
        if(elegido.equals("Española"))
        {
            if (pago >= presio.getEspañola())
            {
                int resultado = pago - presio.getEspañola();
                vuelto.setText("Su vuelto es " + resultado);
                Toast.makeText(getApplicationContext(), "Compro una pizza " + elegido, Toast.LENGTH_SHORT).show();
            }
            else
            {
                int resultado = presio.getEspañola() - pago;
                vuelto.setText("Faltan " + resultado);
                Toast.makeText(getApplicationContext(), "No se a efectuado la compra", Toast.LENGTH_SHORT).show();
            }
        }
        else if(elegido.equals("Italiana"))
        {
            if (pago >= presio.getItaliana())
            {
                int resultado = pago - presio.getItaliana();
                vuelto.setText("Su vuelto es " + resultado);
                Toast.makeText(getApplicationContext(), "Compro una pizza " + elegido, Toast.LENGTH_SHORT).show();
            }
            else
            {
                int resultado = presio.getItaliana() - pago;
                vuelto.setText("Faltan " + resultado);
                Toast.makeText(getApplicationContext(), "No se a efectuado la compra", Toast.LENGTH_SHORT).show();
            }
        }
        else if(elegido.equals("Tejana"))
        {
            if (pago >= presio.getTejana())
            {
                int resultado = pago - presio.getTejana();
                vuelto.setText("Su vuelto es " + resultado);
                Toast.makeText(getApplicationContext(), "Compro una pizza " + elegido, Toast.LENGTH_SHORT).show();
            }
            else
            {
                int resultado = presio.getTejana() - pago;
                vuelto.setText("Faltan " + resultado);
                Toast.makeText(getApplicationContext(), "No se a efectuado la compra", Toast.LENGTH_SHORT).show();
            }
        }
        else if(elegido.equals("Peperoni"))
        {
            if (pago >= presio.getPeperoni())
            {
                int resultado = pago - presio.getPeperoni();
                vuelto.setText("Su vuelto es " + resultado);
                Toast.makeText(getApplicationContext(), "Compro una pizza " + elegido, Toast.LENGTH_SHORT).show();
            }
            else
            {
                int resultado = presio.getPeperoni() - pago;
                vuelto.setText("Faltan " + resultado);
                Toast.makeText(getApplicationContext(), "No se a efectuado la compra", Toast.LENGTH_SHORT).show();
            }
        }
        else if(elegido.equals("Doble queso"))
        {
            if (pago >= presio.getDoble_queso())
            {
                int resultado = pago - presio.getDoble_queso();
                vuelto.setText("Su vuelto es " + resultado);
                Toast.makeText(getApplicationContext(), "Compro una pizza " + elegido, Toast.LENGTH_SHORT).show();
            }
            else
            {
                int resultado = presio.getDoble_queso() - pago;
                vuelto.setText("Faltan " + resultado);
                Toast.makeText(getApplicationContext(), "No se a efectuado la compra", Toast.LENGTH_SHORT).show();
            }
        }
        else if(elegido.equals("Vegetariana"))
        {
            if (pago >= presio.getVegetariana())
            {
                int resultado = pago - presio.getVegetariana();
                vuelto.setText("Su vuelto es " + resultado);
                Toast.makeText(getApplicationContext(), "Compro una pizza " + elegido, Toast.LENGTH_SHORT).show();
            }
            else
            {
                int resultado = presio.getVegetariana() - pago;
                vuelto.setText("Faltan " + resultado);
                Toast.makeText(getApplicationContext(), "No se a efectuado la compra", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
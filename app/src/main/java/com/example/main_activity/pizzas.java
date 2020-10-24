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
        String elegido = pizzas.getSelectedItem().toString();
        if(elegido.equals("Española"))
        {
            //
            Toast.makeText(getApplicationContext(), "Compro una pizza " + elegido, Toast.LENGTH_SHORT).show();
        }
        else if(elegido.equals("Italiana"))
        {
            //
            Toast.makeText(getApplicationContext(), "Compro una pizza " + elegido, Toast.LENGTH_SHORT).show();
        }
        else if(elegido.equals("Tejana"))
        {
            //
            Toast.makeText(getApplicationContext(), "Compro una pizza " + elegido, Toast.LENGTH_SHORT).show();
        }
        else if(elegido.equals("Peperoni"))
        {
            //
            Toast.makeText(getApplicationContext(), "Compro una pizza " + elegido, Toast.LENGTH_SHORT).show();
        }
        else if(elegido.equals("Doble queso"))
        {
            //
            Toast.makeText(getApplicationContext(), "Compro una pizza " + elegido, Toast.LENGTH_SHORT).show();
        }
        else if(elegido.equals("Vegetariana"))
        {
            //
            Toast.makeText(getApplicationContext(), "Compro una pizza " + elegido, Toast.LENGTH_SHORT).show();
        }
    }
}
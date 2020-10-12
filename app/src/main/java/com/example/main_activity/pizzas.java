package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class pizzas extends AppCompatActivity {

    private Spinner pizzas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzas);

        String[] productos = {"Pizzas", "Española", "Italiana", "Tejana", "Peperoni", "Doble queso", "Vegetariana"};
        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productos);
        pizzas.setAdapter(adapt);
    }

    public void compra(View v)
    {
        String elegido = pizzas.getSelectedItem().toString();
        if(false == elegido.equals("Pizzas"))
        {
            Toast.makeText(getApplicationContext(), "Compro una pizza " + elegido, Toast.LENGTH_SHORT).show();
        }
    }
}
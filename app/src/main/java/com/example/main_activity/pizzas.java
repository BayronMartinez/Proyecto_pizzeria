package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class pizzas extends AppCompatActivity {

    private Spinner pizzas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzas);

        ArrayList<String> productos = (ArrayList<String>) getIntent().getSerializableExtra("productos");
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
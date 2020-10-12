package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Menu extends AppCompatActivity {

    private ViewFlipper vf;
    private int imagenes[] = {R.drawable.a , R.drawable.b , R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        vf = (ViewFlipper)findViewById(R.id.slider);

        for(int i = 0; i < imagenes.length; i++ )
        {
            cambiar_imagenes(imagenes[i]);
        }
    }

    public void cambiar_imagenes(int i)
    {
        ImageView vista = new ImageView(this);
        vista.setBackgroundResource(i);

        vf.addView(vista);
        vf.setAutoStart(true);
        vf.setFlipInterval(2800);

        vf.setInAnimation(this , android.R.anim.slide_in_left);
        vf.setOutAnimation(this , android.R.anim.slide_out_right);

    }

    public void perfil (View v)
    {
        Intent i = new Intent(this, perfil.class);
        startActivity(i);
    }
    public void Informacion (View v)
    {
        Intent i = new Intent(this, Informacion.class);
        startActivity(i);
    }
    public void Mapa (View v)
    {
        Intent i = new Intent(this, Mapa.class);
        startActivity(i);
    }
    public void Pizzas (View v)
    {
        Intent i = new Intent(this, pizzas.class);
        startActivity(i);
    }
}
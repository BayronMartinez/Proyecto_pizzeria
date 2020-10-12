package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar carga;
    private EditText user, contra;
    private Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carga = (ProgressBar)findViewById(R.id.ProgressBarCircular);
        user = (EditText)findViewById(R.id.ed_usuario);
        contra = (EditText)findViewById(R.id.edp_contraseña);
        entrar = (Button)findViewById(R.id.btn_entrar);

        carga.setVisibility(View.INVISIBLE);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Task().execute();
            }
        });
    }

    class Task extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute()
        {
            carga.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings)
        {
            for (int i = 1; i <= 5; i++)
            {
                try
                {
                    Thread.sleep(1000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            carga.setVisibility(View.INVISIBLE);

            if(user.getText().toString().trim().equals("Android"))
            {
                if(contra.getText().toString().trim().equals("123"))
                {
                    Intent i = new Intent(getBaseContext(), Menu.class);
                    startActivity(i);
                }
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_SHORT).show();
            }
            if(contra.getText().toString().trim().equals("123"))
            {
                if(user.getText().toString().trim().equals("Android"))
                {
                    Intent i = new Intent(getBaseContext(), Menu.class);
                    startActivity(i);
                }
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
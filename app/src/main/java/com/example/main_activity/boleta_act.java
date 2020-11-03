package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

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

    public void agregar(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Fichero", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();
        String numero = nroBoleta.getText().toString();
        String nombre = cliente.getText().toString();
        String pizza = producto.getText().toString();
        String compra = costo.getText().toString();
        String entrega = direccion.getText().toString();

        if(!numero.isEmpty() || !nombre.isEmpty() || !pizza.isEmpty() || !compra.isEmpty() || !entrega.isEmpty())
        {
            ContentValues registro = new ContentValues();

            registro.put("codigo", numero);
            registro.put("cliente", nombre);
            registro.put("producto", pizza);
            registro.put("costo", compra);
            registro.put("direccion", entrega);

            baseDeDatos.insert("boletas", null, registro);
            Toast.makeText(getApplicationContext(), "boleta guardada correctamente", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Todos los campos deben estar completos", Toast.LENGTH_SHORT).show();
        }
    }
    public void mostrar(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Fichero", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        String numero = nroBoleta.getText().toString();

        if (!numero.isEmpty())
        {
            Cursor fila = baseDeDatos.rawQuery("SELECT cliente, producto, costo, direccion FROM boletas WHERE codigo = " + numero, null);
            if(fila.moveToFirst())
            {
                cliente.setText(fila.getString(0));
                producto.setText(fila.getString(1));
                costo.setText(fila.getString(2));
                direccion.setText(fila.getString(3));
            }
            else
            {
                Toast.makeText(getApplicationContext(), "No se encontro ese codigo", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Para buscar ingrese el codigo de la boleta", Toast.LENGTH_SHORT).show();
        }
    }
    public void eliminar(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Fichero", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        String numero = nroBoleta.getText().toString();

        baseDeDatos.delete("boletas", "codigo = "+ numero, null);
        baseDeDatos.close();

        Toast.makeText(getApplicationContext(), "La boleta fue eliminada con exito", Toast.LENGTH_SHORT).show();
    }
    public void actualizar(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Fichero", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();
        String numero = nroBoleta.getText().toString();
        String nombre = cliente.getText().toString();
        String pizza = producto.getText().toString();
        String compra = costo.getText().toString();
        String entrega = direccion.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo", numero);
        cont.put("cliente", nombre);
        cont.put("producto", pizza);
        cont.put("costo", compra);
        cont.put("direccion", entrega);

        if (!numero.isEmpty())
        {
            baseDeDatos.update("boletas", cont, "codigo = "+numero, null);
            baseDeDatos.close();

            Toast.makeText(getApplicationContext(), "La boleta fue actualizada con exito", Toast.LENGTH_SHORT).show();
        }
    }
}
package com.example.freydell.mirestaurante;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CartaActivity extends AppCompatActivity {


    ListView ListaProductos;
    BDProductos products=new BDProductos(this, "BDProductos",null,1);
    List<String> item=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        ListaProductos=(ListView)findViewById(R.id.carta);





        SQLiteDatabase db= products.getWritableDatabase();

        if(db!=null){


            Producto productos[]=new Producto[8];

            productos[0]=new Producto("Entrada","Empanadas","Empanadas de carne",1000);
            productos[1]=new Producto("Entrada","Palitos","Palitos de queso",1000);
            productos[2]=new Producto("Entrada","Arepa","Arepa con mantequilla y quesito",2000);
            productos[3]=new Producto("Plato fuerte","Sancocho","Sancocho de pollo",6000);
            productos[4]=new Producto("Plato fuerte","Mondongo","Mondongo con ensalada",6000);
            productos[5]=new Producto("Plato fuerte","Solomito","Solomito de 300g",8000);
            productos[6]=new Producto("Bebidas","Jugos naturales","Jugos naturales",3000);
            productos[7]=new Producto("Bebidas","Gaseosa","Gaseosas postobon",2000);


            for(int i=0;i<productos.length;i++){
                db.execSQL("INSERT INTO Productos (tipo,nombre,descripcion,precio)"+
                        "VALUES('"+productos[i].getTipo()+"','"+productos[i].getNombre()+"','"+productos[i].getDescripcion()+"',"+productos[i].getPrecio()+")");

            }
            db.close();


            showProductos();




        }






        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



    public void showProductos(){
        Cursor c=products.getAllProducts();
        item=new ArrayList<String>();
        String tipo="",nombre="",descripcion="",precio="";
        if(c.moveToFirst()){
            do{
                tipo=c.getString(1);
                nombre=c.getString(2);
                descripcion=c.getString(3);
                precio=c.getString(4);
                item.add(tipo+" "+nombre+" "+descripcion+" "+precio);
            }while (c.moveToNext());
        }

        ArrayAdapter<String> adaptador= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,item);
        ListaProductos.setAdapter(adaptador);

    }







}

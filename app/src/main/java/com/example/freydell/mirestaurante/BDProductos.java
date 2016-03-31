package com.example.freydell.mirestaurante;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by gabrielnorena on 21/03/16.
 */
public class BDProductos extends SQLiteOpenHelper {

    String sqlCreate="CREATE TABLE Productos (id INTEGER PRIMARY KEY AUTOINCREMENT, tipo TEXT, nombre TEXT, descripcion TEXT, precio INTEGER)";


    public BDProductos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE Productos");
        onCreate(db);

    }



    public Cursor getAllProducts(){
        String columnas[]={"id","tipo","nombre","descripcion","precio"};
        Cursor c=this.getReadableDatabase().query("Productos",columnas,null,null,null,null,null);
        return c;

    }


}

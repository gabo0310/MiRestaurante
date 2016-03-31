package com.example.freydell.mirestaurante;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gabrielnorena on 22/03/16.
 */
public class BDPersonas extends SQLiteOpenHelper{

    String sqlCreate="CREATE TABLE Personas (cedula INTEGER PRIMARY KEY, nombre TEXT, email TEXT, telefono INTEGER)";

    public BDPersonas(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE Personas");
        onCreate(db);

    }



    public Boolean getPerson(int Cedula){
        String columnas[]={"cedula","nombre","email","telefono"};
        Cursor c=this.getReadableDatabase().query("Personas",columnas,null,null,null,null,null);

        if(c.getCount()==0){
            c.close();

            return false;
        }

        while (c.moveToNext()){
            if(c.getInt(0)==Cedula){
                c.close();
                return true;
            }
        }
        c.close();
        return false;

    }



}

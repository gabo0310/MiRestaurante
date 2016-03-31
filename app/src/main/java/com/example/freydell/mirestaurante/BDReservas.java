package com.example.freydell.mirestaurante;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gabrielnorena on 22/03/16.
 */
public class BDReservas extends SQLiteOpenHelper {

    String sqlCreate="CREATE TABLE Reserva (id INTEGER PRIMARY KEY AUTOINCREMENT, cedula INTEGER, fecha TEXT, hora TEXT, numpersonas TEXT)";



    public BDReservas(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE Reserva");
        onCreate(db);

    }
}

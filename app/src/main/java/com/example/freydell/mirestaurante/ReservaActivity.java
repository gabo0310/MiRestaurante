package com.example.freydell.mirestaurante;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReservaActivity extends AppCompatActivity implements View.OnClickListener {

    Bundle b;
    int cedula;
    EditText eFecha, eHora, eNumero;
    Button bReservar;
    String fecha,hora,numero;
    BDReservas reservations=new BDReservas(this, "BDReservas",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        b=getIntent().getExtras();
        cedula=b.getInt("cedula");



        eFecha=(EditText)findViewById(R.id.editFecha);
        eHora=(EditText)findViewById(R.id.editHora);
        eNumero=(EditText)findViewById(R.id.editNumero);
        bReservar=(Button)findViewById(R.id.btnReservar);

        bReservar.setOnClickListener(this);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){

            case R.id.btnReservar:

                SQLiteDatabase db= reservations.getWritableDatabase();

                fecha=eFecha.getText().toString();
                hora=eHora.getText().toString();
                numero=eNumero.getText().toString();


                Reserva reservation=new Reserva(cedula,fecha,hora,numero);



                db.execSQL("INSERT INTO Reserva (cedula,fecha,hora,numpersonas)" +
                        "VALUES(" + reservation.getCedula() + ",'" + reservation.getFecha() + "','" + reservation.getHora() + "','" + reservation.getNumPersonas() + "')");

                db.close();
                reservations.close();


                Toast toast=Toast.makeText(getApplicationContext(),"Se ha hecho la reserva con exito",Toast.LENGTH_SHORT);
                toast.show();


                Intent intent1=new Intent(this, MenuActivity.class);
                startActivity(intent1);

                break;



        }






    }
}

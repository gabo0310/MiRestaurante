package com.example.freydell.mirestaurante;

import android.content.DialogInterface;
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
import android.widget.TextView;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {


    EditText  eNombre, eEmail, eTelefono;
    TextView eCedula;
    String Nombre, Email;
    int Cedula, Telefono;
    Button bRegistrarse;
    BDPersonas persons=new BDPersonas(this, "BDPersonas",null,1);
    Bundle b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        eCedula=(TextView)findViewById(R.id.editCedula);
        eNombre=(EditText)findViewById(R.id.editNombre);
        eEmail=(EditText)findViewById(R.id.editEmail);
        eTelefono=(EditText)findViewById(R.id.editTelefono);
        bRegistrarse=(Button)findViewById(R.id.btnRegistrarse);

        b=getIntent().getExtras();
        Cedula=b.getInt("cedula");


        eCedula.setText(""+Cedula);

        bRegistrarse.setOnClickListener(this);



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

            case R.id.btnRegistrarse:

                SQLiteDatabase db= persons.getWritableDatabase();

                Cedula=Integer.parseInt(eCedula.getText().toString());
                Nombre=eNombre.getText().toString();
                Email=eEmail.getText().toString();
                Telefono=Integer.parseInt(eTelefono.getText().toString());

                Persona person=new Persona(Cedula,Nombre,Email,Telefono);

                db.execSQL("INSERT INTO Personas (cedula,nombre,email,telefono)" +
                        "VALUES(" + person.getCedula() + ",'" + person.getNombre() + "','" + person.getEmail() + "'," + person.getTelefono() + ")");

                db.close();
                persons.close();


                Toast toast=Toast.makeText(getApplicationContext(),"Se ha registrado con exito",Toast.LENGTH_SHORT);
                toast.show();


                Intent intent1=new Intent(this, ReservaActivity.class);
                intent1.putExtra("cedula",Cedula);
                startActivity(intent1);


                break;



        }

    }
}

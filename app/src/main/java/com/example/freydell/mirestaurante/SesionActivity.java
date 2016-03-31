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

public class SesionActivity extends AppCompatActivity implements View.OnClickListener {

    EditText eConsulta;
    Button bValidar;
    int cedula;
    BDPersonas persons=new BDPersonas(this, "BDPersonas",null,1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        eConsulta=(EditText)findViewById(R.id.editConsulta);
        bValidar=(Button)findViewById(R.id.btnValidar);



        bValidar.setOnClickListener(this);






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

            case R.id.btnValidar:




               cedula=Integer.parseInt(eConsulta.getText().toString());
                if(persons.getPerson(cedula)){
                    Intent inten1=new Intent(this,ReservaActivity.class);

                    inten1.putExtra("cedula",cedula);


                    startActivity(inten1);
                }
                else {
                    Intent intent2=new Intent(this, RegistroActivity.class);
                    intent2.putExtra("cedula",cedula);
                    startActivity(intent2);

                }


                persons.close();


                break;



        }

    }
}

package com.carlosintranets.alarmalert;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView Localidades = (ListView) findViewById(R.id.localidades);
        ListView mainList = (ListView) findViewById(R.id.mainList);


        ArrayList<RegistroEvento> objects = new ArrayList<RegistroEvento>();
        ArrayList<Estatus> estatus = new ArrayList<Estatus>();

        // Agregando eventos de prueba
        RegistroEvento reg1 = new RegistroEvento(1, "Las Mercedes",
                new Date(),"Apertura","Pedro");

        RegistroEvento reg2 = new RegistroEvento(1, "Santa Monica",
                new Date(),"Apertura","Maria");

        objects.add(reg1);
        objects.add(reg2);

        // Agregando estados de pruebas
        Estatus Tienda1 = new Estatus(Estatus.ESTADO_ABIERTO,"Las Mercedes",
                new Date(),"Alarma desarmada");
        Estatus Tienda2 = new Estatus(Estatus.ESTADO_CERRADO,"Valle Arriba",
                new Date(),"Alarma armada");
        Estatus Tienda3 = new Estatus(Estatus.ESTADO_ALARMA,"Alto Prado",
                new Date(),"Intrusion");
        estatus.add(Tienda1);
        estatus.add(Tienda2);
        estatus.add(Tienda3);

        CustomAdapter customAdapter = new CustomAdapter(this, objects);
        mainList.setAdapter( customAdapter );

        EstatusAdapter estadap = new EstatusAdapter(this,estatus);
        Localidades.setAdapter(estadap);


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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

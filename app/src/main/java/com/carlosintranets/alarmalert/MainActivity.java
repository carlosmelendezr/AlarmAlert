package com.carlosintranets.alarmalert;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView Localidades ;
    ListView mainList;
    Context contexto = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Localidades = (ListView) findViewById(R.id.localidades);
        mainList = (ListView) findViewById(R.id.mainList);

        //ArrayList<RegistroEvento> objects = new ArrayList<RegistroEvento>();
        ArrayList<Estatus> estatus = new ArrayList<Estatus>();

        // Agregando eventos de prueba
        /*RegistroEvento reg1 = new RegistroEvento(1, "Las Mercedes",
                new Date(),"Apertura","Pedro");

        RegistroEvento reg2 = new RegistroEvento(1, "Santa Monica",
                new Date(),"Apertura","Maria");

        objects.add(reg1);
        objects.add(reg2);*/

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



        EstatusAdapter estadap = new EstatusAdapter(this,estatus);
        Localidades.setAdapter(estadap);

        getEventos();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void getEventos() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiEvento.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiEvento api = retrofit.create(ApiEvento.class);

        Call<EventoGrupo> call = api.getEventos();

        call.enqueue(new Callback<EventoGrupo>() {
            @Override
            public void onResponse(Call<EventoGrupo> call, Response<EventoGrupo> response) {
                Log.i("AlarmAlert","Obteniendo el listado");
                List<Evento> eventos = response.body().getEventos();

                EventoAdapter eventoAdapter = new EventoAdapter(contexto, eventos);
                mainList.setAdapter(eventoAdapter);
            }

            @Override
            public void onFailure(Call<EventoGrupo> call, Throwable t) {
                Log.e("AlarmAlert",t.getMessage());
                //Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
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

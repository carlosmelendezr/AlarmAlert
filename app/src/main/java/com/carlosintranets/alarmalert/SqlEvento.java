package com.carlosintranets.alarmalert;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SqlEvento extends SQLiteOpenHelper {
    private static final int DB_VERSION = 2;
    private static final String DATABASE_NAME="alarmalert.db";
    private static final String TABLE_NAME="eventos";
    private static final String CREATE_DB = "CREATE TABLE "
            +TABLE_NAME+" "
            +"(id INTEGER PRIMARY KEY," +
            "numero TEXT," +
            "fecha TEXT, " +
            "cuenta TEXT, " +
            "codigocid TEXT, " +
            "particion TEXT, " +
            "zona TEXT," +
            "usuario TEXT," +
            "recibidode TEXT)";
    private static final String LISTA_EVENTOS = "SELECT * FROM eventos";


    public SqlEvento(Context context, String name, SQLiteDatabase.CursorFactory factory,
                     int version) {
        super(context, DATABASE_NAME, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL(CREATE_DB);
    }

    public void crearEvento(Evento ev) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",ev.id);
        values.put("numero",ev.numero);
        values.put("fecha",ev.fecha);
        values.put("cuenta",ev.cuenta);
        values.put("codigocid",ev.codigocid);
        values.put("particion",ev.particion);
        values.put("zona",ev.zona);
        values.put("usuario",ev.usuario);
        values.put("recibidode",ev.recibidode);
        db.insert(TABLE_NAME,null,values);
        Log.i("AlarmAlert","Registro creado en DB correcto.");

    }
    public List<Evento> listaAventos() {
        List<Evento> lista = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(LISTA_EVENTOS, null);

        if (cursor.moveToFirst()) {
            do {
                Evento ev = new Evento();
                ev.setId(cursor.getString(0));
                ev.setNumero(cursor.getString(1));
                ev.setFecha(cursor.getString(2));
                ev.setCuenta(cursor.getString(3));
                ev.setCodigocid(cursor.getString(4));
                ev.setParticion(cursor.getString(5));
                ev.setZona(cursor.getString(6));
                ev.setUsuario(cursor.getString(7));
                ev.setRecibidode(cursor.getString(8));
                lista.add(ev);
            } while (cursor.moveToNext());
        }
        return lista;
    }
}

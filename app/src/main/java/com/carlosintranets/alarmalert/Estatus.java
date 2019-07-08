package com.carlosintranets.alarmalert;

import java.util.Date;

public class Estatus {
    public static int ESTADO_CERRADO = 0;
    public static int ESTADO_ABIERTO  = 1;
    public static int ESTADO_ALARMA  = 2;

    private int estado;
    private String localidad;
    private Date fecha;
    private String evento;


    public Estatus(int estado, String localidad, Date fecha, String evento) {
        this.estado = estado;
        this.localidad = localidad;
        this.fecha = fecha;
        this.evento = evento;

    }

    public int getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.estado = estado;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }


}

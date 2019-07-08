package com.carlosintranets.alarmalert;

import java.util.Date;

public class RegistroEvento {
    private int id;
    private String localidad;
    private Date fecha;
    private String evento;
    private String persona;

    public RegistroEvento(int id, String localidad, Date fecha, String evento, String persona) {
        this.id = id;
        this.localidad = localidad;
        this.fecha = fecha;
        this.evento = evento;
        this.persona = persona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }
}

package com.carlosintranets.alarmalert;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EventoGrupo {

    @SerializedName("records")
    @Expose
    private List<Evento> eventos = null;

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}



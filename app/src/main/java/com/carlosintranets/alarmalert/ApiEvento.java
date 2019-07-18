package com.carlosintranets.alarmalert;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEvento {
   String BASE_URL="http://veramed.com.ve/api/eventos/";

    @GET("reporte.php")
    Call<EventoGrupo> getEventos();
}

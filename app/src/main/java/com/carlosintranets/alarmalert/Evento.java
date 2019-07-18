package com.carlosintranets.alarmalert;


public class Evento {

    String id;
    String numero;
    String fecha;
    String cuenta;
    String codigocid;
    String particion;
    String zona;
    String usuario;
    String recibidode;

    public Evento(String id, String numero, String fecha, String cuenta, String codigocid,
                  String particion, String zona, String usuario, String recibidode) {
        this.id = id;
        this.numero = numero;
        this.fecha = fecha;
        this.cuenta = cuenta;
        this.codigocid = codigocid;
        this.particion = particion;
        this.zona = zona;
        this.usuario = usuario;
        this.recibidode = recibidode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getCodigocid() {
        return codigocid;
    }

    public void setCodigocid(String codigocid) {
        this.codigocid = codigocid;
    }

    public String getParticion() {
        return particion;
    }

    public void setParticion(String particion) {
        this.particion = particion;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usurio) {
        this.usuario = usurio;
    }

    public String getRecibidode() {
        return recibidode;
    }

    public void setRecibidode(String recibidode) {
        this.recibidode = recibidode;
    }
}

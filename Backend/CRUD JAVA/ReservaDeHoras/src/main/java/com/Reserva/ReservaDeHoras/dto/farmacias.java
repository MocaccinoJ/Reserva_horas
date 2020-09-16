package com.Reserva.ReservaDeHoras.dto;

public class farmacias {
    private String franquicia;
    private String ubicacion;
    private String comuna;

    public farmacias(String franquicia, String ubicacion, String comuna) {
        this.franquicia = franquicia;
        this.ubicacion = ubicacion;
        this.comuna = comuna;
    }

    public String getFranquicia() {
        return franquicia;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getComuna() {
        return comuna;
    }
}

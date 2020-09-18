package com.Reserva.ReservaDeHoras.dto;

import java.sql.Date;

public class reserva {

    private int id;
    private Date fecha;
    private String hora;
    private String correo_u;
    private String servicio;
    private String ubicacion_f;
    private String estado;
    private String correo_a;

    public reserva(int id, Date fecha, String hora, String correo_u, String servicio,
                   String ubicacion_f, String estado, String correo_a) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.correo_u = correo_u;
        this.servicio = servicio;
        this.ubicacion_f = ubicacion_f;
        this.estado = estado;
        this.correo_a = correo_a;
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getCorreo_u() {
        return correo_u;
    }

    public String getServicio() {
        return servicio;
    }

    public String getUbicacion_f() {
        return ubicacion_f;
    }

    public String getEstado() {
        return estado;
    }

    public String getCorreo_a() {
        return correo_a;
    }
}
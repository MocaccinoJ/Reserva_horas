package com.Reserva.ReservaDeHoras.dto;

import java.sql.Date;

public class reserva {

    private int ID;
    private Date fecha;
    private String hora;
    private String correo_u;
    private byte servicio;
    private String ubicacion_f;
    private String estado;
    private String correo_a;

    public reserva(int ID, Date fecha, String hora, String correo_u, byte servicio,
                   String ubicacion_f, String estado, String correo_a) {
        this.ID = ID;
        this.fecha = fecha;
        this.hora = hora;
        this.correo_u = correo_u;
        this.servicio = servicio;
        this.ubicacion_f = ubicacion_f;
        this.estado = estado;
        this.correo_a = correo_a;
    }

    public int getID() {
        return ID;
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

    public byte getServicio() {
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
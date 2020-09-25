package com.Reserva.ReservaDeHoras.dto;

import java.sql.Date;
import java.sql.Time;

public class reserva {

    private int id;
    private Date fecha;
    private String hora;
    private int  id_u;
    private String servicio;
    private String ubicacion_f;
    private String estado;
    private int id_a;

    public reserva(int id, Date fecha, String hora, int id_u, String servicio, String ubicacion_f, String estado, int id_a) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.id_u = id_u;
        this.servicio = servicio;
        this.ubicacion_f = ubicacion_f;
        this.estado = estado;
        this.id_a = id_a;
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

    public int getId_u() {
        return id_u;
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

    public int getId_a() {
        return id_a;
    }
}
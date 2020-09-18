package com.Reserva.ReservaDeHoras.dto;

public class usuarios {

    private int id;
    private String nombre;
    private String correo;
    private String contrasenha;

    public usuarios(int id, String nombre, String correo, String contrasenha) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenha = contrasenha;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasenha() {
        return contrasenha;
    }
}

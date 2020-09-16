package com.Reserva.ReservaDeHoras.dto;

public class administradores {

    private String nombre;
    private String correo;
    private String contrasenha;

    public administradores(String nombre, String correo, String contrasenha) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenha = contrasenha;
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

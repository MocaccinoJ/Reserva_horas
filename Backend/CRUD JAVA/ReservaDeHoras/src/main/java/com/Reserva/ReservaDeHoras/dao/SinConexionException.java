package com.Reserva.ReservaDeHoras.dao;

import java.sql.SQLException;

public class SinConexionException extends Exception {
    public SinConexionException(SQLException e) {
        super (e);
    }
}

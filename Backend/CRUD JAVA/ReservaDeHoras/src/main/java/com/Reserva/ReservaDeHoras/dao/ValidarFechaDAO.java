package com.Reserva.ReservaDeHoras.dao;

import com.Reserva.ReservaDeHoras.ConnectionManager;
import com.Reserva.ReservaDeHoras.dto.reserva;
import com.Reserva.ReservaDeHoras.dto.usuarios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ValidarFechaDAO {

    private static Connection connection;
    public ValidarFechaDAO() throws SQLException {
        this.connection = ConnectionManager.obtenerConexion();
    }

    public boolean validarReservas(Date fecha,String hora) throws SQLException {
        String sql = "SELECT * FROM reserva WHERE fecha = ? AND hora= ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setDate(1,fecha);
        ps.setString(2,hora);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return false;
                       //SI ENTRA ES PORQUE LA HORA ESTÁ TOMADA
        } return true;//QUIERE DECIR QUE LA HORA NO ESTÁ TOMADA;
    }

}

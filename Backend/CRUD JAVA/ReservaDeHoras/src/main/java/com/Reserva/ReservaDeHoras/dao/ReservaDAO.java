package com.Reserva.ReservaDeHoras.dao;

import com.Reserva.ReservaDeHoras.ConnectionManager;
import com.Reserva.ReservaDeHoras.dto.reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReservaDAO {

    //OBTENER LA CONEXION
    private static Connection connection;
    public ReservaDAO() throws SQLException {
        this.connection = ConnectionManager.obtenerConexion();
    }
    //OBTENER LOS RESULTADOS
    public List<reserva> obtenerResultados (String sql, int parametro) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,parametro);
        ResultSet rs = ps.executeQuery();
        List<reserva> res = new LinkedList<>();
        while(rs.next()){
            reserva r = new reserva(
                    rs.getInt("id"),
                    rs.getDate("fecha"),
                    rs.getString("hora"),
                    rs.getString("correo_u"),
                    rs.getString("servicio"),
                    rs.getString("ubicacion"),
                    rs.getString("estado"),
                    rs.getString("correo_a")
            );
            res.add(r);
        }
        return res;
    }

    //OBTENER RESERVA POR CORREO

    public List<reserva> obtenerReservaPorCorreo(int id) throws SQLException {
    String sql = "SELECT id, fecha, hora, correo_u, servicio, ubicacion_f, estado FROM reserva " +
            "WHERE correo_u = ?";
    return obtenerResultados(sql, id);
    }

    //METODO PARA AÑADIR UNA NUEVA RESERVA

    public void anadirReserva(reserva r) throws SQLException{
        String sql = "INSERT INTO reserva (fecha, hora, correo_u, servicio, ubicacion_f, estado)"
                + " VALUES (?, ?, ?, ?, ?, 'sin confirmar')";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setDate(1, r.getFecha());
        ps.setString(2,r.getHora());
        ps.setString(3,r.getCorreo_u());
        ps.setString(4,r.getServicio());
        ps.setString(5, r.getUbicacion_f());
        ps.setString(6,r.getEstado());

        ps.executeUpdate();
    }

    //METODO PARA EDITAR UNA RESERVA

    public void actualizarReserva(reserva r, int a) throws SQLException{
        String sql = "UPDATE reserva SET fecha = ?, hora = ?, correo_u = ?," +
                " servicio = ?, ubicacion_f = ?, estado = ? WHERE ID = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,r.getId());
        ps.setDate(2, r.getFecha());
        ps.setString(3, r.getHora());
        ps.setString(4, r.getCorreo_u());
        ps.setString(5,r.getServicio());
        ps.setString(6,r.getUbicacion_f());
        ps.setString(7,r.getEstado());
        ps.executeUpdate();
    }

    // <------------------------OJO CON ESTA CONSULTA------------------------>!!!
    //METODO PARA ELIMINAR UNA RESERVA
    // <------------------------OJO CON ESTA CONSULTA------------------------>!!!
    public void borrarReserva(int id) throws SQLException{
        String sql = "DELETE FROM reserva WHERE correo_u = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        ps.executeUpdate();
    }
//METODO PARA OBTENER LAS RESERVAS COMPLETAS
    public List<reserva> obtenerReservas() throws SQLException{
        String sql = "SELECT ID, fecha, hora, correo_u, servicio, ubicacion_f, estado FROM reserva";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<reserva> reservas = new ArrayList<>();
        while(rs.next()){
            reserva r = new reserva(
                    rs.getInt("id"),
                    rs.getDate("fecha"),
                    rs.getString("hora"),
                    rs.getString("correo_u"),
                    rs.getString("servicio"),
                    rs.getString("ubicacion_f"),
                    rs.getString("estado"),
                    rs.getString("correo_u")

            );
            reservas.add(r);
        }
        return reservas;
    }
    //METODO PARA CAMBIAR EL ESTADO DE UNA RESERVA
    public void confirmarReserva(int id, reserva r) throws SQLException {
        String sql = "UPDATE reserva SET correo_a = ?, estado = 'Confirmado' WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,r.getCorreo_a());
        ps.setInt(2,id);

        ps.executeUpdate();
    }

    //METODO PARA CAMBIAR EL SERVICIO DE UNA RESERVA???
}

package com.Reserva.ReservaDeHoras.dao;

import com.Reserva.ReservaDeHoras.ConnectionManager;
import com.Reserva.ReservaDeHoras.dto.administradores;
import com.Reserva.ReservaDeHoras.dto.usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdministradoresDAO {
    //OBTENER CONEXION

    private static Connection connection;
    public AdministradoresDAO() throws SQLException {
        this.connection = ConnectionManager.obtenerConexion();
    }
    public List<administradores> obtenerTodosResultados() throws  SQLException{
        String sql = "SELECT * FROM administradores";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<administradores> resultados = new ArrayList<>();
        while (rs.next()){
            administradores a = new administradores(
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("contrasenha")

            );
            resultados.add(a);
        }
        return resultados;
    }
    // OBTENER RESULTADOS

    private  List<administradores> obtenerResultados(String sql, String parametro) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, parametro);
        ResultSet rs = ps.executeQuery();
        List<administradores> administrador = new LinkedList<>();
        while (rs.next()){
            administradores a  = new administradores(
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("contrasenha")
            );
            administrador.add(a);
        }
        return administrador;
    }
    //METODO PARA OBTENER ADMINISTRADORES POR NOMBRE

    public List<administradores> obtenerAdministradoresPorNombre(String nombre) throws SQLException{
        String sql = "SELECT nombre, correo, contrasenha FROM administradores WHERE nombre like ?";
        return obtenerResultados(sql, nombre);
    }
    //METODO PARA AÑADIR UN ADMINISTRADOR NUEVO

    public void anadirAdministrador(administradores a) throws SQLException {
    String sql = "INSERT INTO administradores (nombre, correo, contrasenha) VALUES (?, ?, ?)";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setString(1, a.getNombre());
    ps.setString(2,a.getCorreo());
    ps.setString(3,a.getContrasenha());
    ps.executeUpdate();
    }
    //METODO PARA EDITAR UN ADMINISTRADOR

    public void  actualizarAdministrador(administradores a, String i) throws SQLException {
        String sql = "UPDATE administradores  SET nombre = ?, contrasenha = ? WHERE correo = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, a.getNombre());
        ps.setString(3, i);
        ps.setString(2, a.getContrasenha());
        ps.executeUpdate();

    }
    //METODO PARA BORRAR UN ADMINISTRADOR

    public void borrarAdministrador(String correo) throws SQLException{
    String sql = "DELETE FROM administradores WHERE correo = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setString(1,correo);
    ps.executeUpdate();
    }
}

package com.Reserva.ReservaDeHoras.dao;

import com.Reserva.ReservaDeHoras.ConnectionManager;
import com.Reserva.ReservaDeHoras.dto.administradores;
import com.Reserva.ReservaDeHoras.dto.usuarios;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UsuariosDAO {
    @Autowired
    private EmailDAO sendEmailService;
    //METODO PARA OBTENER LA CONEXION
    private static Connection connection;
    public UsuariosDAO() throws SQLException {
        this.connection = ConnectionManager.obtenerConexion();
    }
    //METODO PARA OBTENER LOS RESULTADOS

    private List <usuarios> obtenerResultados(String sql, String parametro) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,parametro);
        ResultSet rs = ps.executeQuery();
        List<usuarios> usuario = new LinkedList<>();
        while (rs.next()){
            usuarios u = new usuarios(
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("contrasenha")
            );
            usuario.add(u);
        }
        return usuario;
    }
    //METODO PARA OBTENER USUARIO POR NOMBRE
    public List<usuarios> obtenerUsuarioPorNombre(String nombre) throws SQLException{
    String sql = "SELECT nombre, correo, contrasenha FROM usuarios WHERE nombre like ?";
    return obtenerResultados(sql, nombre);
    }
    //METODO PARA AÑADIR UN USUARIO NUEVO
    public void añadirUsuario(usuarios u) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, correo, contrasenha) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,u.getNombre());
        ps.setString(2,u.getCorreo());
        ps.setString(3,u.getContrasenha());
        ps.executeUpdate();
        new EmailDAO().enviarConGMail(u.getCorreo(), "Bienvenido","¡Felicidades!"  +
                " Te has registrado con éxito, te damos la bienvenida a KeepHealt ");
    }

    //METODO PARA ACTUALIZAR/EDITAR UN UDUARIO

    public void actualizarUsuario(usuarios a, String i) throws SQLException{
        String sql = "UPDATE usuarios  SET nombre = ?, contrasenha = ? WHERE correo = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, a.getNombre());
        ps.setString(3, i);
        ps.setString(2, a.getContrasenha());
        ps.executeUpdate();
    }

    //METODO PARA BORRAR UN USUARIO

    public void eliminarUsuario(String correo) throws SQLException{
        String sql = "DELETE FROM usuarios WHERE correo = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,correo);
        ps.executeUpdate();
    }
    //METODO PARA OBTENER TODOS LOS USUARIOS

    public List<usuarios> obtenerTodosResultados() throws  SQLException{
        String sql = "SELECT * FROM usuarios";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<usuarios> resultados = new ArrayList<>();
        while (rs.next()){
            usuarios u = new usuarios(
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("contrasenha")

            );
            resultados.add(u);
        }
        return resultados;
    }
}
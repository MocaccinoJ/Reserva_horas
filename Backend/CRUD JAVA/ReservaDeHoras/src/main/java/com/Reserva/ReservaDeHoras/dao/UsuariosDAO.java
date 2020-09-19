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
                    rs.getInt("id"),
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
    String sql = "SELECT id, nombre, correo, contrasenha FROM usuarios WHERE nombre like ?";
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

    public void actualizarUsuario(usuarios a, int id) throws SQLException{
        String sql = "UPDATE usuarios  SET nombre = ?, contrasenha = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, a.getNombre());
        ps.setInt(3, id);
        ps.setString(2, a.getContrasenha());
        ps.executeUpdate();
    }

    //METODO PARA BORRAR UN USUARIO

    public void eliminarUsuario(int id) throws SQLException{
        String sql = "DELETE FROM usuarios WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
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
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("contrasenha")

            );
            resultados.add(u);
        }
        return resultados;
    }

    //METODO PARA LOGGIN DE USUARIO
    //OJO CON LOS METODOS DE LOGGEO
    static public usuarios loginUsuario(usuarios user) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM usuarios WHERE correo = '" + user.getCorreo() + "' AND contrasenha = '"
                            + user.getContrasenha() + "'");
            ResultSet rs = ps.executeQuery();
            rs.next();
            int numId = rs.getInt(1);
            String nom = rs.getString(2);
            String cor = rs.getString(3);
            String contra = rs.getString(4);

            return new usuarios(numId, nom, cor, contra);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
package com.Reserva.ReservaDeHoras.dao;

import com.Reserva.ReservaDeHoras.ConnectionManager;
import com.Reserva.ReservaDeHoras.dto.farmacias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FarmaciasDAO {
    //OBTENER LA CONEXCION
    private static Connection connection;
    public FarmaciasDAO() throws SQLException {
        this.connection = ConnectionManager.obtenerConexion();
    }

    public List<farmacias> obtenerFarmacias() throws SQLException {
        String sql = "SELECT franquicia, ubicacion, comuna FROM farmacias";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<farmacias> farmacia = new ArrayList<>();
        while(rs.next()){
            farmacias f = new farmacias(
                    rs.getString("franquicia"),
                    rs.getString("ubicacion"),
                    rs.getString("comuna")
            );
            farmacia.add(f);
        }
        return farmacia;
    }
    //OBTENER RESULTADOS (METODO FACILITADOR)
    private List <farmacias> obtenerResultados(String sql, String parametro) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, parametro);
        ResultSet rs = ps.executeQuery();
        List <farmacias> farmacia = new LinkedList<>();
        while (rs.next()){
            farmacias f = new farmacias(
                    rs.getString("franquicia"),
                    rs.getString("ubicacion"),
                    rs.getString("comuna")
            );
            farmacia.add(f);
        }
        return farmacia;
    }

    //METODO PARA OBTENER UNA RESERVA POR UBICACION
    public List<farmacias> obtenerFarmaciaPorUbicacion(String ubicacion) throws SQLException {
        String sql = "SELECT franquicia, ubicacion, comuna FROM farmacias WHERE ubicacion = ?";
        return obtenerResultados(sql, ubicacion);
    }
    //METODO PARA AGREGAR UNA FARMACIA
    public void anadirfarmacia(farmacias f) throws SQLException{
        String sql = "INSERT INTO farmacias (franquicia, ubicacion, comuna) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, f.getFranquicia());
        ps.setString(2,f.getUbicacion());
        ps.setString(3,f.getComuna());
        ps.executeUpdate();
    }
    //METODO PARA EDITAR UNA FARMACIA
    public void actualizarFarmacia(farmacias a, String i) throws SQLException {
        String sql = "UPDATE farmacias  SET franquicia = ?, comuna = ? WHERE ubicacion = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, a.getFranquicia());
        ps.setString(3, i);
        ps.setString(2, a.getComuna());
        ps.executeUpdate();
    }
    //METODO PARA ELMINAR UNA FARMACIA
    public void borrarFarmacia(String ubicacion) throws SQLException {
        String sql = "DELETE FROM farmacias WHERE ubicacion = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, ubicacion);
        ps.executeUpdate();
    }
}
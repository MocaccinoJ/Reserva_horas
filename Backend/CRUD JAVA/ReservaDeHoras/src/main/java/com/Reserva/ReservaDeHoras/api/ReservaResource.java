package com.Reserva.ReservaDeHoras.api;

import com.Reserva.ReservaDeHoras.dao.ReservaDAO;
import com.Reserva.ReservaDeHoras.dto.reserva;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ReservaResource {

    //METODO PARA OBTENER LAS RESERVAS
    @RequestMapping(method = RequestMethod.GET, value = "/reserva/{ID}")
    public List<reserva> getReserva (@PathVariable("ID") int id)
        throws SQLException {
        List<reserva> res = new ReservaDAO().obtenerReservaPorCorreo(id);
        return res;
    }
    //METODO PARA AGREGAR UNA NUEVA RESERVA
    // <------------------------OJO CON ESTA CONSULTA------------------------>!!!
    @RequestMapping(method = RequestMethod.POST, value = "/reserva/agregar/")
    public void addNewReserva(@RequestBody reserva r) throws SQLException {
        new ReservaDAO().anadirReserva(r);
    }
    //METODO PARA EDITAR UNA RESERVA EXISTENTE
    // <------------------------OJO CON ESTA CONSULTA------------------------>!!!
    @RequestMapping(method = RequestMethod.PUT, value = "/reserva/editar/{id}")
    public void updateReserva (@PathVariable("id") int a,
                               @RequestBody reserva r) throws SQLException {
        new ReservaDAO().actualizarReserva(r,a);
    }
    //METODO PARA ELIMINAR UNA RESERVA
    // <------------------------OJO CON ESTA CONSULTA------------------------>!!!
    @RequestMapping(method = RequestMethod.DELETE, value = "/reserva/eliminar/{ID}")
    public void borrarReserva (@PathVariable int id) throws SQLException {
        new ReservaDAO().borrarReserva(id);
    }
    //METODO PARA OBTENER TODAS LAS RESERVAS
   @RequestMapping(method = RequestMethod.GET, value = "/reserva/todos/")
    public List <reserva> getReservas() throws SQLException {
        List <reserva> reservas = new ReservaDAO().obtenerReservas();
        return reservas;
   }
    //METODO PARA CAMBIAR EL ESTADO DE UNA RESERVA
    @RequestMapping(method = RequestMethod.PUT, value = "/reserva/confirmar/{ID}")
    public void confirmarReserva (@PathVariable("ID") int id,
                                  @RequestBody reserva r) throws SQLException{
        new ReservaDAO().confirmarReserva(id, r);
    }
    //¿Se tiene que hacer un método para insertar el servicio de una reserva?
    //¿Se tiene que hacer un método para editar el servicio de una reserva?
}
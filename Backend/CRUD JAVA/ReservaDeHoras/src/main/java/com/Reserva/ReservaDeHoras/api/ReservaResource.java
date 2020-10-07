package com.Reserva.ReservaDeHoras.api;

import com.Reserva.ReservaDeHoras.dao.ReservaDAO;
import com.Reserva.ReservaDeHoras.dao.UsuariosDAO;
import com.Reserva.ReservaDeHoras.dao.ValidarFechaDAO;
import com.Reserva.ReservaDeHoras.dto.reserva;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




import java.sql.SQLException;

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
    @RequestMapping(method = RequestMethod.POST, value = "/reserva/agregar/")
    public void addNewReserva(@RequestBody reserva r) throws SQLException {
        if (new ValidarFechaDAO().validarReservas(r.getFecha(),r.getHora())){
            new ReservaDAO().anadirReserva(r);
        }else {
            System.out.println("HORA TOMADA");

        }
    }
    //METODO PARA EDITAR UNA RESERVA EXISTENTE
    @RequestMapping(method = RequestMethod.PUT, value = "/reserva/editar/{id}")
    public void updateReserva (@PathVariable("id") int a,
                               @RequestBody reserva r) throws SQLException {
        new ReservaDAO().actualizarReserva(r,a);
    }
    //METODO PARA ELIMINAR UNA RESERVA
    // <------------------------OJO CON ESTA CONSULTA------------------------>!!!
    @RequestMapping(method = RequestMethod.DELETE, value = "/reserva/eliminar/{id}")
    public void borrarReserva (@PathVariable ("id") int id) throws SQLException {
        new ReservaDAO().borrarReserva(id);
    }
    //METODO PARA OBTENER TODAS LAS RESERVAS
   @RequestMapping(method = RequestMethod.GET, value = "/reserva/todos/")
    public List <reserva> getReservas() throws SQLException {
        List <reserva> reservas = new ReservaDAO().obtenerReservas();
        return reservas;
   }
    //METODO PARA CAMBIAR EL ESTADO DE UNA RESERVA
    @RequestMapping(method = RequestMethod.PUT, value = "/reserva/confirmar/{i}")
    public void confirmarReserva (@PathVariable ("i") int i,
                                  @RequestBody reserva r) throws SQLException {
        new ReservaDAO().confirmarReserva(i, r);
    }
    //METODO PARA OBTENER LAS RESERVAS POR ID DE USUARIO
    @RequestMapping(method = RequestMethod.GET, value = "/reserva/idUsuario/{id_u}")
    public List<reserva> getReservaUsuario (@PathVariable("id_u") int id_u)
            throws SQLException {
        List<reserva> res = new ReservaDAO().obtenerReservaPorIdUsuario(id_u);
        return res;
    }
}
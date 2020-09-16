package com.Reserva.ReservaDeHoras.api;

import com.Reserva.ReservaDeHoras.dao.AdministradoresDAO;
import com.Reserva.ReservaDeHoras.dao.FarmaciasDAO;
import com.Reserva.ReservaDeHoras.dto.administradores;
import com.Reserva.ReservaDeHoras.dto.farmacias;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FarmaciasResource {
    //METODO PARA OBTENER TODAS LAS FARMACIAS
    @RequestMapping(method = RequestMethod.GET, value = "/farmacias/todos")
        public List<farmacias> getFarmacias() throws SQLException {
        List <farmacias> farma = new FarmaciasDAO().obtenerFarmacias();
        return farma;
    }
    //METODO PARA OBTENER LAS FARMACIAS POR UBICACION
    @RequestMapping(method = RequestMethod.GET,value = "/farmacias/ubicacion/{ubicacion}")
    public List<farmacias> getFarmaciasByUbicacionLike (@PathVariable("ubicacion") String ubicacion)
        throws SQLException {
        List<farmacias> far = new FarmaciasDAO().obtenerFarmaciaPorUbicacion(ubicacion);
        return far;
    }
    //METODO PARA AGREGAR UNA FARMACIA

    @RequestMapping(method = RequestMethod.POST, value = "/farmacias/agregar/")
    public void addNewAdministrador(@RequestBody farmacias f) throws SQLException {
        new FarmaciasDAO().anadirfarmacia(f);
    }
    //METODO PARA EDITAR UNA FARMACIA

    @RequestMapping(method = RequestMethod.PUT, value = "/farmacias/editar/{id}")
    public void updateFarmacia (@PathVariable("id") String i,
                                     @RequestBody farmacias a) throws SQLException {
        new FarmaciasDAO().actualizarFarmacia(a,i);
    }
    //METODO PARA ELIMINAR UNA FARMACIA
    @RequestMapping(method = RequestMethod.DELETE, value = "/farmacias/eliminar/{ubicacion}")
    public void borrarFarmacia (@PathVariable String ubicacion) throws SQLException {
        new FarmaciasDAO().borrarFarmacia(ubicacion);
    }
}
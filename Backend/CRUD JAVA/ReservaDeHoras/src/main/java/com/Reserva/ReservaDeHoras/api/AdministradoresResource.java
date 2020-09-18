package com.Reserva.ReservaDeHoras.api;


import com.Reserva.ReservaDeHoras.dao.AdministradoresDAO;
import com.Reserva.ReservaDeHoras.dao.UsuariosDAO;
import com.Reserva.ReservaDeHoras.dto.administradores;
import com.Reserva.ReservaDeHoras.dto.usuarios;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AdministradoresResource {

    //METODO PARA OBTENER A LOS ADMINISTRADORES DESDE LA BASE DE DATOS

    @RequestMapping(method = RequestMethod.GET, value = "/administradores/{nombre}")
    public List<administradores> getAdministradoresByNombreLike (@PathVariable("nombre") String nombre)
        throws SQLException {
        List<administradores> administrador = new AdministradoresDAO().
                obtenerAdministradoresPorNombre("%"+nombre+"%");
        return administrador;
    }
    //METODO PARA AGREGAR UN ADMINISTRADOR

    @RequestMapping(method = RequestMethod.POST, value = "/administradores/agregar/")
    public void addNewAdministrador(@RequestBody administradores a) throws SQLException {
        new AdministradoresDAO().anadirAdministrador(a);
    }
    //METODO PARA EDITAR UN ADMINISTRADOR

    @RequestMapping(method = RequestMethod.PUT, value = "/administradores/editar/{id}")
    public void updateAdministrador (@PathVariable("id") int id,
                                                 @RequestBody administradores a) throws SQLException {
        new AdministradoresDAO().actualizarAdministrador(a,id);
    }
    //METODO PARA ELIMINAR UN ADMIND

    @RequestMapping(method = RequestMethod.DELETE, value = "/administradores/eliminar/{id}")
    public void borrarAdministradorbyId (@PathVariable int id) throws SQLException {
        new AdministradoresDAO().borrarAdministrador(id);
    }
    //METODO PARA OBTENER A TODOS LOS USUARIOS
    @RequestMapping(method = RequestMethod.GET, value = "/administradores/todos/")
    public List <administradores> getAdministradores() throws SQLException {
        List<administradores> resultados = new AdministradoresDAO().obtenerTodosResultados();
        return resultados;
    }
}

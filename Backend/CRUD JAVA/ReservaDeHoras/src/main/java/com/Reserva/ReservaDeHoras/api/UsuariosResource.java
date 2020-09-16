package com.Reserva.ReservaDeHoras.api;

import com.Reserva.ReservaDeHoras.dao.UsuariosDAO;
import com.Reserva.ReservaDeHoras.dto.usuarios;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UsuariosResource {
//METODO PARA OBTENER A LOS USUARIOS DESDE LA DATABASE

    @RequestMapping(method = RequestMethod.GET, value = "/usuarios/{nombre}")
    public List<usuarios> getUsuariosByNombreLike (@PathVariable("nombre") String nombre)
    throws SQLException{
        List<usuarios> usuario = new UsuariosDAO().obtenerUsuarioPorNombre("%"+nombre+"%");
        return usuario;
    }
    //METODO PARA AGREGAR UN USUARIO
    @RequestMapping(method = RequestMethod.POST, value = "/usuarios/agregar/")
    public void addNewUsuario (@RequestBody usuarios u) throws SQLException {
        new UsuariosDAO().añadirUsuario(u);
    }
    //METODO PARA EDITAR UN USUARIO
    @RequestMapping(method = RequestMethod.PUT, value = "/usuarios/editar/{id}")
    public void updateUsuario (@PathVariable("id") String i,
                               @RequestBody usuarios a) throws SQLException {
        new UsuariosDAO().actualizarUsuario(a,i);
    }
    //METODO PARA ELIMINAR UN USUARIO
    @RequestMapping(method = RequestMethod.DELETE, value = "/usuarios/eliminar/{correo}")
    public void borrarUsuario (@PathVariable("correo") String correo) throws SQLException{
        new UsuariosDAO().eliminarUsuario(correo);
    }
    //METODO PARA OBTENER A TODOS LOS USUARIOS
    @RequestMapping(method = RequestMethod.GET, value = "/usuarios/todos/")
    public List <usuarios> getUsuarios() throws SQLException {
        List<usuarios> resultados = new UsuariosDAO().obtenerTodosResultados();
        return resultados;
    }
    @RequestMapping(method = RequestMethod.POST, value = "/usuarios/login/")
    public usuarios loginUsuario(@RequestBody usuarios user) throws Exception {
        return UsuariosDAO.loginUsuario(user);
    }
}
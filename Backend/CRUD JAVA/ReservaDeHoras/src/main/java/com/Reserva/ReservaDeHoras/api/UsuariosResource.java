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

    @RequestMapping(method = RequestMethod.GET, value = "/usuarios/nombre/{nombre}")
    public List<usuarios> getUsuariosByNombreLike (@PathVariable("nombre") String nombre)
    throws SQLException{
        List<usuarios> usuario = new UsuariosDAO().obtenerUsuarioPorNombre("%"+nombre+"%");
        return usuario;
    }
    //OBTENER USUARIO POR ID
    @RequestMapping(method = RequestMethod.GET, value = "/usuarios/id/{id}")
    public List<usuarios> getUsuariosByNombreLike (@PathVariable("id") int id)
            throws SQLException{
        List<usuarios> usuario = new UsuariosDAO().obtenerUsuarioPorId(id);
        return usuario;
    }

    //METODO PARA AGREGAR UN USUARIO
    @RequestMapping(method = RequestMethod.POST, value = "/usuarios/agregar/")
    public void addNewUsuario (@RequestBody usuarios u) throws SQLException {
        new UsuariosDAO().añadirUsuario(u);
    }
    //METODO PARA EDITAR UN USUARIO
    @RequestMapping(method = RequestMethod.PUT, value = "/usuarios/editar/{id}")
    public void updateUsuario (@PathVariable("id") int id,
                               @RequestBody usuarios a) throws SQLException {
        new UsuariosDAO().actualizarUsuario(a,id);
    }
    //METODO PARA ELIMINAR UN USUARIO
    @RequestMapping(method = RequestMethod.DELETE, value = "/usuarios/eliminar/{id}")
    public void borrarUsuario (@PathVariable("id") int id) throws SQLException{
        new UsuariosDAO().eliminarUsuario(id);
    }
    //METODO PARA OBTENER A TODOS LOS USUARIOS
    @RequestMapping(method = RequestMethod.GET, value = "/usuarios/todos/")
    public List <usuarios> getUsuarios() throws SQLException {
        List<usuarios> resultados = new UsuariosDAO().obtenerTodosResultados();
        return resultados;
    }
    //METODO DE LOGGEO PARA UN USUARIO
    @RequestMapping(method = RequestMethod.POST, value = "/usuarios/login/")
    public usuarios loginUsuario(@RequestBody usuarios user) throws Exception {
        return UsuariosDAO.loginUsuario(user);
    }
    //METODO PARA RECUPERAR LA CONTRASEÑA
    @RequestMapping(method = RequestMethod.GET, value = "/usuarios/contraseña/{correo}")
    public List <usuarios> getUsuariosPorCorreoLike (@PathVariable ("correo") String correo)
        throws SQLException {
    List<usuarios> usuario = new UsuariosDAO().recuperarContra(correo);
    return usuario;
    }
    //METODO PARA ELIMINAR UN USUARIO A TRAVÉS DE UN CORREO
    @RequestMapping(method = RequestMethod.DELETE, value = "/usuarios/eliminarPorCorreo/{correo}")
    public void borrarUsuarioCorreo (@PathVariable("correo") String correo) throws SQLException{
        new UsuariosDAO().eliminarUsuarioC(correo);
    }

    /*
        @RequestMapping(method = RequestMethod.DELETE, value = "/farmacias/eliminar/{ubicacion}")
    public void borrarFarmacia (@PathVariable String ubicacion) throws SQLException {
        new FarmaciasDAO().borrarFarmacia(ubicacion);
    }
    */
}
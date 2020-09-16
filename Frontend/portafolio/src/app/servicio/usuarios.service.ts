import { Injectable } from '@angular/core';
import { Usuario } from 'src/app/interfaces/usuario';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  constructor(private http: HttpClient) { }
//MODIFICAR LAS RUTAS DE LOS METODS
  private usuarioURL = 'localhost:8080/api'; // URL de la API

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  //OBTENER TODOS LOS USUARIOS DESDE LA BASE DE DATOS(METODO PARA ADMIN)
  obtenerUsuarios(): Observable<Usuario[]>{
    const url= '/usuarios/todos/'
    return this.http.get<Usuario[]>(this.usuarioURL+url)
  }
  
  //AGREGAR A UN USUARIO EN LA BASE DE DATOS DESDE EL FRONT(METODO PARA REGISTRARSE)
  agregarUsuario(usuario: Usuario): Observable<Usuario>{
    return this.http.post<Usuario>(this.usuarioURL+"/usuarios/agregar/", usuario, this.httpOptions)
  }

  //ELIMINAR UN USUARIO EN LA BASE DE DATOS DESDE EL FRONT (METODO PARA ADMIN)
  borrarUsuario(correo: String) {
    return this.http.delete(`${this.usuarioURL}/usuarios/eliminar/${correo}`);
  }

  //EDITAR UN USUARIO
}

/*
  constructor(private http: HttpClient) { }
  private usuarioURL = 'localhost:8080/api'; // URL de la API

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };
  obtenerUsuarios(): Observable<Usuario[]>{
    const url= '/usuarios1/'
    return this.http.get<Usuario[]>(this.usuarioURL+url)
  }

  agregarUsuario(usuario: Usuario): Observable<Usuario>{
    return this.http.post<Usuario>(this.usuarioURL+"add/", usuario, this.httpOptions)
  }

  borrarUsuario(correo: String) {
    return this.http.delete(`${this.usuarioURL}usuarios/eliminar/${correo}`);
  }
}

*/
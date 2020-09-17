import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from 'src/app/interfaces/usuario';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

 


  private api = 'http://localhost:8080/api/usuarios/'

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  loginUsuario(usuario: Usuario): Observable<Usuario> {
    const url = 'login/';
    return this.http.post<Usuario>(this.api + url, usuario);
  }

 
  
  public   isAuthenticated(): boolean{    
    const token = localStorage.getItem('usuario');
    console.log(token);
    if (token != null){
      return true;
    }
    return false;
  }
  
}
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from 'src/app/interfaces/usuario';
import { Observable } from 'rxjs';
import { Admin } from 'src/app/interfaces/admin';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

 

  private apia= 'http://localhost:8080/api/administradores/'
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

   loginAdmin(admin: Admin): Observable<Admin> {
     const url = 'login/'
     return this.http.post<Admin>(this.apia + url, admin);
   }
   public isAuthenticated1(): boolean{
     const token = localStorage.getItem('admin');
     console.log(token);
     if (token != null){
       return true
    }
     return false;
   }
  
}
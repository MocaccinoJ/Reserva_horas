import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reserva } from 'src/app/interfaces/reserva';

@Injectable({
  providedIn: 'root'
})

export class ReservaService {

  constructor(private http: HttpClient) { }
  private reservaURL = 'http://localhost:8080/api/reserva/'; //URL DE LA API

  //METODO PARA OBTENER TABLA DE RESERVAS
  obtenerReservas():Observable<Reserva[]>{
    const url = 'todos/' 
    return this.http.get<Reserva[]>(this.reservaURL+url)
  }
  httpOptions={
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  }

  //METODO PARA AGREGAR UNA RESERVA(PENDIENTE)
  agregarReserva(reserva: Reserva): Observable<Reserva>{
    return this.http.post<Reserva>(this.reservaURL+"agregar/", reserva, this.httpOptions)
  }

  //METODO PARA ELIMINAR RESERVA(PENDIENTE)
  eliminarReserva(id: number): Observable<{}>{
    return this.http.delete(`${this.reservaURL}eliminar/${id}`, this.httpOptions);
  }

  //METODO PARA EDITAR RESERVA (PENDIENTE)
  editarReserva(reserva: Reserva, id: number): Observable<Reserva>{
    return this.http.put<Reserva>(`${this.reservaURL}editar/${id}`, reserva, this.httpOptions);
  }
  //METODO PARA CONFIRMAR UNA RESERVA
  confirmarReserva( id_a: number): Observable<{}>{
    return this.http.put(`${this.reservaURL}confirmar/${id_a}`, this.httpOptions);
  }

  // confirmarReserva( correo_a: String): Observable<{}>{
  //   return this.http.put(`${this.reservaURL}confirmar/${correo_a}`, this.httpOptions);
  // }
}
/*
  borrarUsuario(correo: String): Observable<{}>{
    return this.http.delete(`${this.usuarioURL}eliminar/${correo}`, this.httpOptions);
  }
  */ 
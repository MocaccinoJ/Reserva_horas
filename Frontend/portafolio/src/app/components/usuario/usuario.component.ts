import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/servicio/auth.service';
import { MatCalendarCellClassFunction } from '@angular/material/datepicker';
import { ReservaService } from 'src/app/servicio/reserva.service';
import { Reserva } from 'src/app/interfaces/reserva';
import { Observable } from 'rxjs';
import { Usuario } from 'src/app/interfaces/usuario';
import {UsuarioService} from 'src/app/servicio/usuario.service';



@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css'],
  encapsulation: ViewEncapsulation.None,
})
export class UsuarioComponent implements OnInit {
  constructor( 
    private router: Router,
    private AuthService: AuthService,
    private servicio_r: ReservaService,
    private servicio_u: UsuarioService) { }

    reserva: Reserva [];


    usuario: Usuario = {
      id: null,
      nombre: '',
      contrasenha: '',
      correo: '',
    }

    ngOnInit(): void {this.obtenerDatosUsuario()
    }
   
  // filtro = (d: Date | null): boolean => {
  //   const day = (d || new Date()).getDay();
    
  //   return day !== 0 && day !== 6;
  // }

  //METODO DE LOGOUT
  logout(){
    localStorage.removeItem("usuario");
    this.router.navigate(['/'])
  }


  //PRIMER INTENTO DE CONEXION CON METODO DE CREAR UNA RESERVA

  //PRIMERO PASO: TRAER EL ID DEL USUARIO DEL LOCAL STORAGE

  // validarDatos(): void {
  //    if (!this.usuario.nombre){
  //      alert("Ingrese un nombre")
  //     return;
  //   }

  //   if (!this.usuario.correo){
  //     alert("Ingrese un correo")
  //     return;
  //    }

  //   if (!this.usuario.contrasenha){
  //            alert("Ingrese una contraseña")
  //      return;
  //    }

  crearReserva1(servicio, ubicacion_f, fecha, hora, id_u){
    
    const id = JSON.parse(localStorage.getItem('usuario')).id

     this.servicio_r.agregarReserva({servicio, ubicacion_f, fecha, hora, id_u} as Reserva).subscribe();{
     this.router.navigate(['/usuario'])
     }
    console.log(id)
  }
obtenerDatosUsuario(){
  const id = JSON.parse(localStorage.getItem('usuario')).id
  console.log(id,'ESTE ES EL ID')
  this.servicio_u.obtenerUsuariosPorId(id).subscribe(usuario => this.usuario = usuario[0])

}
  // confirmar(reserva){
  //   const id = JSON.parse(localStorage.getItem('admin')).id
  //   this.servicio_r.confirmarReserva(reserva, id).subscribe(_=>this.obtenerReservas());
   
  //   console.log(id);
  // }


  
  //  METODO PARA AGREGAR UNA RESERVA(PENDIENTE)
  // agregarReserva(reserva: Reserva): Observable<Reserva>{
  //   return this.http.post<Reserva>(this.reservaURL+"agregar/", reserva, this.httpOptions)
  // }



          //Obtener Dato con desde el LocalStorage
        // confirmar(reserva){
        //   const id = JSON.parse(localStorage.getItem('admin')).id
        //   this.servicio_r.confirmarReserva(reserva, id).subscribe(_=>this.obtenerReservas());
         
        //   console.log(id);
      
        // }
}
/*

    if(this.service.agregarUsuario(this.usuario).subscribe()){
        alert("Registro exitoso"); 
        this.router.navigate(['']);
        */



        //Obtener Dato con desde el LocalStorage
        // confirmar(reserva){
        //   const id = JSON.parse(localStorage.getItem('admin')).id
        //   this.servicio_r.confirmarReserva(reserva, id).subscribe(_=>this.obtenerReservas());
         
        //   console.log(id);
      
        // }


  //  METODO PARA AGREGAR UNA RESERVA(PENDIENTE)
  // agregarReserva(reserva: Reserva): Observable<Reserva>{
  //   return this.http.post<Reserva>(this.reservaURL+"agregar/", reserva, this.httpOptions)
  // }


  // METODO PARA CONFIRMAR UNA RESERVA
  // confirmarReserva( reserva: Reserva, i ){
  //   const url = 'confirmar/'
  //   return this.http.put(`${this.reservaURL}confirmar/${i}`  ,reserva, this.httpOptions);
  // }
import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/servicio/usuario.service';
import { Usuario } from 'src/app/interfaces/usuario';
import { Router } from '@angular/router'
@Component({
  selector: 'app-vistausuarios',
  templateUrl: './vistausuarios.component.html',
  styleUrls: ['./vistausuarios.component.css']
})
export class VistausuariosComponent implements OnInit {

  constructor(private services: UsuarioService) { }


  //HACIENDO LA TABLA DE USUARIOS

  usuario: Usuario[] = [];

  ngOnInit(): void {
    this.services.obtenerUsuarios().subscribe( usuario => this.usuario = usuario)
  }

//OBTENER LOS USUARIOS
obtenerUsuarios() {
  this.services.obtenerUsuarios()
    .subscribe(usuarios => this.usuario = usuarios);
}
  //TABLA DE USUARIO PARA MOSTRAR EN EL FRONT
  columnas = ['id','nombre','correo','boton']
  
  eliminar(i){
    const email=this.usuario[i].correo
    this.services.borrarUsuario(email).subscribe(_=>this.obtenerUsuarios());
    this.services.borrarUsuario(email).subscribe();
    console.log(this.usuario);
    console.log(email);
  }
}
/*
import { Component, OnInit } from '@angular/core';
import { ReservaService } from 'src/app/servicio/reserva.service';
import { Reserva } from 'src/app/interfaces/reserva';

@Component({
  selector: 'app-vistareservas',
  templateUrl: './vistareservas.component.html',
  styleUrls: ['./vistareservas.component.css']
})
export class VistareservasComponent implements OnInit {

  constructor(private servicio_r: ReservaService) { }

  //HACIENDO LA LISTA DE RESERVAS
  reserva: Reserva[] = [];

  ngOnInit(): void {
    this.servicio_r.obtenerReservas().subscribe(reserva => this.reserva = reserva)
  }

  //TABLA DE RESERVAS CON BOTON PARA CONFIRMAR
  columnas = ['id','fecha','hora','id_u','servicio','ubicacion_f','estado','id_a','confirmar']


  //METODO DE CONFIRMAR UNA RESERVA A TRAVES DE UN CORREO DE UN ADMINISTRADOR
  confirmar(reserva){
    const id = JSON.parse(localStorage.getItem('admin')).id
    this.servicio_r.confirmarReserva(reserva, id).subscribe(_=>this.obtenerReservas());
   
    console.log(id);

  }
    //METODO PARA OBTENER LAS RESERVAS EN UNA TABLA
  obtenerReservas() {
    this.servicio_r.obtenerReservas().subscribe(reserva => this.reserva =reserva);
    }
}














   obtenerUsuarios() {
     this.usuarioService.obtenerUsuarios()
       .subscribe(usuarios => this.usuario = usuarios);
   }

  usuario: Usuario[]=[];

  ngOnInit(): void {
    this.usuarioService.obtenerUsuarios().subscribe(usuario => this.usuario = usuario)
  }

  
  columnas = ['nombre', 'correo', 'contrasenha', 'binder', 'boton']
   eliminar(i){
     const email = this.usuario[i].correo
     this.usuarioService.borrarUsuario(email).subscribe(_=>this.obtenerUsuarios());
     this.usuarioService.borrarUsuario(email).subscribe();
     console.log(this.usuario);
     console.log(email);
   }
 
  
   obtenerUsuarios() {
     this.usuarioService.obtenerUsuarios()
      .subscribe(usuarios => this.usuario = usuarios);
   }

   update(){
     this.usuarioService.actualizarUsuario(this.usuarioUnico, this.usuarioUnico.correo).subscribe(_=>this.obtenerUsuarios());
     this.usuarioService.actualizarUsuario(this.usuarioUnico, this.usuarioUnico.correo).subscribe();
   }
 } */
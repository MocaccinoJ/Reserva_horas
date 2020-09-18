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
  columnas = ['id','fecha','hora','correo_u','servicio','ubicacion_f','estado','correo_a','confirmar']


  //METODO DE CONFIRMAR UNA RESERVA A TRAVES DE UN CORREO DE UN ADMINISTRADOR
  confirmar(i){
    const email = this.reserva[i].correo_a
    this.servicio_r.confirmarReserva(email).subscribe(_=>this.obtenerReservas());
    this.servicio_r.confirmarReserva(email).subscribe();
    console.log(this.reserva);
    console.log(email);

  }
    //METODO PARA OBTENER LAS RESERVAS EN UNA TABLA
    obtenerReservas() {
      this.servicio_r.obtenerReservas().subscribe(reserva => this.reserva =reserva);
    }

}
/*
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
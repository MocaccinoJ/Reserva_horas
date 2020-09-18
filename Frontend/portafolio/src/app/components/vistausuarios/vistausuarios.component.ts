import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/servicio/usuario.service';
import { Usuario } from 'src/app/interfaces/usuario';


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


  //TABLA DE USUARIO PARA MOSTRAR EN EL FRONT
  columnas = [''] 
}
/*
 nombre: string;
    correo: string;
    contrasenha: string;

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

}*/
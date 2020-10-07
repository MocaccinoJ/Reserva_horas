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

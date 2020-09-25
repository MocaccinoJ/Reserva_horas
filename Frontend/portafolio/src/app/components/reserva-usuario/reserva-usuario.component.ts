import { Component, OnInit } from '@angular/core';
import { MatTable, MatTableDataSource } from '@angular/material/table';
import { Reserva } from 'src/app/interfaces/reserva';
import { ReservaService } from 'src/app/servicio/reserva.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reserva-usuario',
  templateUrl: './reserva-usuario.component.html',
  styleUrls: ['./reserva-usuario.component.css']
})
export class ReservaUsuarioComponent implements OnInit {

  constructor(private servicio_r: ReservaService,
              private router: Router) { }

  ngOnInit(): void {
    this.ObtenerReservaPorId()
  }
  reserva:Reserva[]=[];

  columnas= ['id','fecha','hora','servicio','ubicacion_f','estado']

  dataSource = new MatTableDataSource(this.reserva)

  columnasMostrar=[{name:'id',title:'ID RESERVA'}, {name:'fecha',title:'Fecha'},{name:'hora',title:'Hora'},
{name:'servicio',title:'Servicio'},{name:'ubicacion_f',title:'Ubicacion'},{name:'estado',title:'Estado'}]

ObtenerReservaPorId(){
  const id = JSON.parse(localStorage.getItem('usuario')).id
  this.servicio_r.obtenerReservaPorIdU(id).subscribe(reserva=> {this.reserva =reserva; 
    this.dataSource=new MatTableDataSource(this.reserva)})
}
logout(){
  localStorage.removeItem("usuario");
  this.router.navigate(['/'])
}
}


import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/interfaces/usuario';
import { UsuarioService } from 'src/app/servicio/usuario.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-rcontrasenha',
  templateUrl: './rcontrasenha.component.html',
  styleUrls: ['./rcontrasenha.component.css']
})
export class RcontrasenhaComponent implements OnInit {

  constructor(private service: UsuarioService) { }

usuario:Usuario[]=[];

  ngOnInit(): void {
  }
recuperarContrasenha(correo){
this.service.recuperarContrasenha(correo).subscribe(usuario=> this.usuario)
}

}
/*


obtenerUsuarios() {
  this.services.obtenerUsuarios()
    .subscribe(usuarios => this.usuario = usuarios);
}


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
*/
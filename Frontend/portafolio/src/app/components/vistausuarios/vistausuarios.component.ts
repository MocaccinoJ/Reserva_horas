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
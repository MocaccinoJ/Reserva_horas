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
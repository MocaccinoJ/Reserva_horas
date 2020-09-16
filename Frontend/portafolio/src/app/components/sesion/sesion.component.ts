import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/interfaces/usuario';
import { UsuarioService } from 'src/app/servicio/usuario.service';


@Component({
  selector: 'app-sesion',
  templateUrl: './sesion.component.html',
  styleUrls: ['./sesion.component.css']
})
export class SesionComponent implements OnInit {

  constructor(private service: UsuarioService, private router: Router) { }

  ngOnInit(): void {
  }

  loginUsuario(correo: string, contrasenha: string){
    this.service.loginUsuario({correo, contrasenha} as Usuario).subscribe(_=> this.router.navigate(['/usuario']))
  }
}

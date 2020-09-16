import { Component, OnInit } from '@angular/core';
import { UsuariosService } from 'src/app/servicio/usuarios.service';
import { Usuario } from 'src/app/interfaces/usuario';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {
 

  constructor(private service: UsuariosService) { }

   usuario: Usuario = {
   nombre:'',
   correo:'',
   contrasenha:''
  }
  ngOnInit(): void {
  }


  validarDatos(): void {
   if (!this.usuario.correo){
     alert("Ingrese un correo")
     }
 }

   agregarUsuario(): void{
   this.service.agregarUsuario(this.usuario).subscribe(_ => {alert("Registro exitoso");},
   error => {alert("Este correo ya se encuentra en uso")}
   );
 }

}


/*  

  validarDatos(): void {
    if (!this.usuario.correo){
      alert("Ingrese un correo")
    }
  }


  agregarUsuario(): void{
    this.usuarioService.agregarUsuario(this.usuario).subscribe(_ => {alert("Registro exitoso");},
    error => {alert("Este correo ya se encuentra en uso")}
    );
    
  }

}
 */
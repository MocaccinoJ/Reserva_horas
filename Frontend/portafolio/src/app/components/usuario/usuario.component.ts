import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/servicio/auth.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css'],
})
export class UsuarioComponent implements OnInit {
  constructor( private router: Router,
    private AuthService: AuthService) { }

  ngOnInit(): void {
  }
  
  filtro = (d: Date | null): boolean => {
    const day = (d || new Date()).getDay();
    
    return day !== 0 && day !== 6;
  }

  horaRes = [];
  horaInicio = '';
  horaFin = '';
  
  //METODO DE LOGOUT
  logout(){
    localStorage.removeItem("usuario");
    this.router.navigate(['/'])
  }
}

/*
  logout(){
    localStorage.removeItem("usuario");
    this.router.navigate(['/'])
  }
}*/

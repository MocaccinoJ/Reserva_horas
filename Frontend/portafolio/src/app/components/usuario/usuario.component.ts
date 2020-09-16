import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css'],
})
export class UsuarioComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}
  
  filtro = (d: Date | null): boolean => {
    const day = (d || new Date()).getDay();
    
    return day !== 0 && day !== 6;
  }

  horaRes = [];
  horaInicio = '';
  horaFin = '';
}



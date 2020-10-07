import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/servicio/auth.service';
import { Admin } from 'src/app/interfaces/admin';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private router: Router,
    private authService: AuthService) { }

  ngOnInit(): void {
    const  nombre = JSON.parse(localStorage.getItem('admin')).nombre
    console.log(nombre, 'ESTE ES EL NOMBRE')
  }

  logout(){
    localStorage.removeItem("admin");
    this.router.navigate(['/'])
  }
}
/*
  obtenerDatosUsuario(){
  const id = JSON.parse(localStorage.getItem('usuario')).id
  const nombre = JSON.parse(localStorage.getItem('usuario')).nombre
  console.log(nombre, 'ESTE ES EL NOMBRE')*/
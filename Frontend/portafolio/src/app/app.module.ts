import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsuarioComponent } from './components/usuario/usuario.component';
import { RegistroComponent } from './components/registro/registro.component';
import { HomeComponent } from './components/home/home.component';
import { SesionComponent } from './components/sesion/sesion.component';
import { AdminComponent } from './components/admin/admin.component';
import { AppMaterialModule } from "./app-material/app-material.module";
import { VistareservasComponent } from './components/vistareservas/vistareservas.component';
import { VistausuariosComponent } from './components/vistausuarios/vistausuarios.component';
import { HttpClientModule} from "@angular/common/http";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { LoginAdminComponent } from './components/login-admin/login-admin.component';
import { MatButtonModule} from '@angular/material/button';
import { MatDatepickerModule} from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ReservaUsuarioComponent } from './components/reserva-usuario/reserva-usuario.component';
import { RcontrasenhaComponent } from './components/rcontrasenha/rcontrasenha.component';


@NgModule({
  declarations: [
    AppComponent,
    UsuarioComponent,
    RegistroComponent,
    HomeComponent,
    SesionComponent,
    AdminComponent,
    VistareservasComponent,
    VistausuariosComponent,
    LoginAdminComponent,
    ReservaUsuarioComponent,
    RcontrasenhaComponent,

  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    AppMaterialModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatCardModule,
    MatButtonModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatInputModule,
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

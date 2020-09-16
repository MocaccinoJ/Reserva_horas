import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsuarioComponent} from '../app/components/usuario/usuario.component';
import { RegistroComponent} from '../app/components/registro/registro.component';
import { HomeComponent} from '../app/components/home/home.component';
import { SesionComponent} from '../app/components/sesion/sesion.component';
import { AdminComponent} from '../app/components/admin/admin.component';
const routes: Routes = [
  
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'registro', component: RegistroComponent},
  {path: 'sesion', component: SesionComponent},
  {path: 'usuario', component: UsuarioComponent},
  {path: 'admin', component: AdminComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

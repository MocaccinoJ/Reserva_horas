import { Component, Input, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/servicio/auth.service';
import { Usuario } from 'src/app/interfaces/usuario';

@Component({
  selector: 'app-sesion',
  templateUrl: './sesion.component.html',
  styleUrls: ['./sesion.component.css']
})
export class SesionComponent implements OnInit {
@Input() usuario: Usuario

  
    constructor(
      private fb: FormBuilder,
      private route: ActivatedRoute,
      private router: Router,
      private authService: AuthService
    ) {
    }
  
    ngOnInit(): void {

      this.form = this.fb.group({
        username: ['', Validators.email],
        password: ['', Validators.required]
      });
  
    }
  
    form: FormGroup;
    public loginInvalid: boolean;
    private formSubmitAttempt: boolean;
    private returnUrl: string;
  
    onSubmit() {
      this.loginInvalid = false;
      this.formSubmitAttempt = false;
      if (this.form.valid) {
        try {
          const username = this.form.get('username').value;
          const password = this.form.get('password').value;
  
          let usuario: Usuario = { correo: username, contrasenha: password } as Usuario;
          this.authService.loginUsuario(usuario).subscribe(userResponse => {
            localStorage.setItem("usuario", JSON.stringify(userResponse));
            this.router.navigate(['/usuario'])
          });
  
        } catch (err) {
          console.log(err);
          this.loginInvalid = true;
        }
      } else {
        this.formSubmitAttempt = true;
      }
    }
 }

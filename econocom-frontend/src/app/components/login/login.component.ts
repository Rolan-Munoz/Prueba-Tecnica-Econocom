// Componente login 
// En este componente nos encontramos con la funcionalidad de inicio de sesion a traves de la creacion de un formulario con formBuilder
// Se han aplicado validaciones al formulario y avisos de errores a traves de mensajes en el template html asociado a este componente
// Se ha implementando el metodo de login a traves del servicio LoginServiceService, que se encarga de realizar la peticion al backend a traves 
// del metodo OnSubmit que se ejecuta al enviar el formulario, siempre y cuando este sea valido. Igualmente se han aplicado mensajes de exito y error al iniciar sesion
// en el template html, a traves de los metodos showSuccess y showError que utilizan MatSnackBar para mostrar mensajes temporales al usuario.
// En el template tambien se ha implementado la funcionalidad para cambiar la vista cuando se ha logueado con exito el usuario. en dicha vista se
// recoge el email del usuario y se muestra un mensaje de bienvenida, asi como la posibilidad de cerrar sesion borrando el token de acceso y volviendo al formulario de inicio de sesion.
// a la vista previa. Para ello hemos implementando un metodo de logout.
// En el archivo de estilos scss se han aplicado algunas clases y funcionalidades de Angular Material para mejorar la experiencia del usuario asi como la
// libreria facilitada en la carpeta de assets.
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginServiceService } from 'src/app/services/login-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

    loginForm: FormGroup;
    hidePassword = true;
    selectedLanguage = 'ES';
    isLoading = false;
    isLoggedIn = false; 
    userEmail = ''; 
  
    constructor(private fb: FormBuilder, private auth: LoginServiceService, private snackBar: MatSnackBar) {
      this.loginForm = this.fb.group({
        email: ['', [Validators.required, Validators.email]],
        password: ['', Validators.required]
      });
    }
  
    onSubmit() {
      if (this.loginForm.valid) {
        this.isLoading = true;
        const credentials = {
          email: this.loginForm.value.email,
          password: this.loginForm.value.password
        }

        this.auth.login(credentials).subscribe({
          next: (response) => {
            this.isLoggedIn = true;
            this.userEmail = this.loginForm.value.email;
            this.showSuccess('Bienvenido');
          },
          error: (error) => {
            this.isLoading = false;
            this.showError(error.message || 'Error en el inicio de sesión');
          },
          complete: () => {
            this.isLoading = false;
          }
        });
      }
    }


    private showSuccess(message: string): void {
      this.snackBar.open(message, 'Cerrar', {
        duration: 3000,
        panelClass: ['success-snackbar']
      });
    }
  
    private showError(message: string): void {
      this.snackBar.open(message, 'Cerrar', {
        duration: 5000,
        panelClass: ['error-snackbar']
      });
    }

    logout() {
      this.auth.clearToken();
      this.isLoggedIn = false;
      this.loginForm.reset();
    }
}

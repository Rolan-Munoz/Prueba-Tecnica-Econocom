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

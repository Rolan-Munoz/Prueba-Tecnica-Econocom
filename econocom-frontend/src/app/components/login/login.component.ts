import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

    loginForm: FormGroup;
    hidePassword = true;
    selectedLanguage = 'ES';
  
    constructor(private fb: FormBuilder) {
      this.loginForm = this.fb.group({
        email: ['', [Validators.required, Validators.email]],
        password: ['', Validators.required]
      });
    }
  
    onSubmit() {
      if (this.loginForm.valid) {
        console.log('Formulario enviado', this.loginForm.value);
        // Aquí iría la lógica de autenticación
      }
    }

}

// Servicio de login
// En este servicio manejamos el login, logout y validación de token a traves del modulo HttpClient de Angular.
// A traves de este servicio llamamos a los diferentes endpoints del backend para autenticar al usuario y manejar el token de autenticación.
// Tambien se ha visto conveniente crear algunos metodos para manejar el token en el localStorage del navegador, aunque esta no es una buena practica
// en entornos de produccion.
// Por ultimo se ha creado el manejador de errores a traves del metodo handleLoginError, el cual maneja los errores que puedan ocurrir al hacer la peticion al backend
// o si  las credenciales son incorrectas.
// Este servicio es inyectable y se puede usar en cualquier componente de la aplicacion.
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map, Observable, throwError } from 'rxjs';

interface AuthRequestDTO{
  email: string;
  password: string;
}

interface AuthResponseDTO{
  token: string;
  email: string;
}

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  private baseUrl: string = 'http://localhost:8080/api/auth';

  constructor(private http: HttpClient) { }

  login(authRequest: AuthRequestDTO): Observable<string> {
    return this.http.post<AuthResponseDTO>(this.baseUrl + '/login', authRequest)
      .pipe(
        map(response => {
          this.storeToken(response.token);
          return response.token;
        }),
        catchError(this.handleLoginError)
      );
  }

  validateToken(): Observable<boolean> {
    const token = this.getToken();
    
    if (!token) {
      return new Observable(subscriber => {
        subscriber.next(false);
        subscriber.complete();
      });
    }

    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.get<boolean>(
      `${this.baseUrl}/validate`,
      { headers }
    ).pipe(
      catchError(() => {
        this.clearToken();
        return [false];
      })
    );
  }

  storeToken(token: string): void {
    localStorage.setItem('auth_token', token);
  }

  getToken(): string | null {
    return localStorage.getItem('auth_token');
  }

  clearToken(): void {
    localStorage.removeItem('auth_token');
  }

  private handleLoginError(error: HttpErrorResponse): Observable<never> {
    let errorMessage = 'Error desconocido';
    
    if (error.status === 401) {
      errorMessage = 'Credenciales inválidas';
    } else if (error.error instanceof ErrorEvent) {
      errorMessage = `Error: ${error.error.message}`;
    } else {
      errorMessage = `Error ${error.status}: ${error.message}`;
    }
    
    return throwError(() => new Error(errorMessage));
  }
}

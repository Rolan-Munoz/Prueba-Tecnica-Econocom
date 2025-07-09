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

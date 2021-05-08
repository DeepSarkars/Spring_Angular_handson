import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user';
import { Observable, throwError } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { HandleError, HttpErrorHandler } from './http-error-handler.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private handleError: HandleError;
  constructor(private httpClient: HttpClient,
    httpErrorHandler: HttpErrorHandler) {
    this.handleError = httpErrorHandler.createHandleError('UserService');
  }


  getUsers(): Observable<User[]> {
    return this.httpClient.get(`https://reqres.in/api/users`).
      pipe(
        map((data: User[]) => {
          return data;
        }), catchError(error => {
          return throwError('Something went wrong!');
        })
      )
  }

  addUser(post: User): Observable<User> {
    return this.httpClient.post<User>('https://reqres.in/api/users', post)
      .pipe(
        catchError(this.handleError('addUser', post))
      );
  }

  updateUser(post: User): Observable<User> {
    return this.httpClient.put<User>('https://reqres.in/api/users?page=2', post)
    .pipe(catchError(this.handleError('UpdateUser', post))
    );
  }

  deleteUser(id) {
    this.httpClient.delete(`https://reqres.in/api/users/2/${id}/`).pipe(
      catchError(this.handleError('deletUser'))
    );
  }

}

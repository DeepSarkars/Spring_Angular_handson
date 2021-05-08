import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user';
import { Observable, throwError } from 'rxjs';
import { map, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  getUsers() :Observable<User[]>{
    return this.httpClient.get(`https://reqres.in/api/users`).
      pipe(
        map((data: User[]) => {
          return data;
        }), catchError(error => {
          return throwError('Something went wrong!');
        })
      )
  }

  // postUser(){
  //   this.httpClient.post('https://reqres.in/api/users')
  // }
}

import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  loggedIn: boolean;
  constructor() { }

  login(){
    this.loggedIn = true;
  }

  logout(){
    this.loggedIn = false;
  }
  isLoggedIn():boolean{
    return this.loggedIn;
  }
}
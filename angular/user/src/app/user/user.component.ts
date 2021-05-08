import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';



@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users: User[];
  post : User ={
    id: 1,
    first_name: "Deep",
    last_name: "Sarkar",
    email: "abc@abc.co"
  }
  constructor(public http: HttpClient, private userService: UserService){}

  ngOnInit(){
    this.getUserList();
  }

  getUserList() {
    this.userService
    .getUsers()
    .subscribe((data:any) => {
      console.log(data);
      this.users = data.data;
    });
  }
  title = 'user';

  postUser(){
    this.userService.addUser(this.post)
    .subscribe(user => console.log('User added: ', user));
  }

  updateUser(): void {
    this.userService.updateUser(this.post).
    subscribe(user => console.log('User Updated : ', user));
  }

  deleteUser():void{
    this.userService.deleteUser(1);
    console.log('User id 1 deleted ');
  

  }
}

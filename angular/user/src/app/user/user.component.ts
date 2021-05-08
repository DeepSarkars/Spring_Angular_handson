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
}

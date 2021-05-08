import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import {NgForm} from '@angular/forms';
import { Department } from '../department';

@Component({
  selector: 'app-add-emp',
  templateUrl: './add-emp.component.html',
  styleUrls: ['./add-emp.component.css']
})
export class AddEmpComponent implements OnInit {

  constructor() { }
  
  departments: Department[]=[
    {id:1,name:"IT"},
    {id:2,name:"Marketing"},
    {id:3,name:"Sales"}
  ]

  employeeModel =new Employee(2,"Deepsubhra",1000,true,{id:1,name:"IT"},"31/08/1999");

  ngOnInit(): void {
  }

  onSubmit(){
    console.log(this.employeeModel);
  }
}

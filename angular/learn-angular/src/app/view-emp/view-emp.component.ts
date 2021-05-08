import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';

@Component({
  selector: 'app-view-emp',
  templateUrl: './view-emp.component.html',
  styleUrls: ['./view-emp.component.css']
})
export class ViewEmpComponent implements OnInit {

  constructor() { }
  employee: Employee = {
    id: 1,
    name: "Deep",
    salary: 10000,
    permanent: true,
    department: {id:1, name:"IT"},
    dob: Date()
  }
  ngOnInit(): void {
  }

}

import { Component, OnInit } from '@angular/core';
import { Employee } from './employee';

@Component({
  selector: 'app-view-emp',
  templateUrl: './view-emp.component.html',
  styleUrls: ['./view-emp.component.css']
})
export class ViewEmpComponent implements OnInit {

  constructor() { }

  employee: Employee = {
    id: 1,
    name: "Mr. A",
    salary: 10000,
    skills: [{ id: 1, name: "Java" }, { id: 2, name: "Python" }, { id: 3, name: "JS" }]
  }
  ngOnInit(): void {
  }

}

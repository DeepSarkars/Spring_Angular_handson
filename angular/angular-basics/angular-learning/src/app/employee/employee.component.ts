import { Component, OnInit } from '@angular/core';
import { Employee } from './employee';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  message = "Employees list on"+Date.now();
  employee: Employee[] = [{
    id: "1",
    name: "mr a"
  },
  {
    id: "2",
    name: "mr b"
  }
  ]
  constructor() { }
  
  ngOnInit(): void {
  }

}

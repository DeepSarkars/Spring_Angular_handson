import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from './employee';
import { EMPLOYEES } from './mock-employees';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor(private employeeService: EmployeeService) { }
  employees = EMPLOYEES;


  ngOnInit(): void {
    this.filteredEmployees = [];
    this.getEmployees();
  }

  filteredEmployees: Employee[];
  searchKey: String;

  getEmployees(): void {
    if (this.filteredEmployees.length === 0) {
      this.employeeService.getEmployees()
        .subscribe(employees => this.employees = employees);
    }
    else {
      this.employees = this.filteredEmployees;
    }
  }

  search(): void {
    this.filteredEmployees = this.employees
      .filter(employee => employee.name.toLowerCase().startsWith(this.searchKey.toLowerCase())
        && this.searchKey != '');
    console.log(this.filteredEmployees);
    this.getEmployees();
  }

}

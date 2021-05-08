import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Employee } from './employee/employee';
import { EMPLOYEES } from './employee/mock-employees';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor() { }

  getEmployees(): Observable<Employee[]>{
    return of(EMPLOYEES);
  }

  getEmployee(id: Number): Observable<Employee>{
    const employee=EMPLOYEES.find(h => h.id===id) as Employee;
    return of(employee);
  }
}

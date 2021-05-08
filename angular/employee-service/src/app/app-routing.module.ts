import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeDetailComponent } from './employee-detail/employee-detail.component';
import { EmployeeComponent } from './employee/employee.component';

const routes: Routes = [
  {path: '', redirectTo:'/list', pathMatch:'full'},
  {path: 'detail/:id', component: EmployeeDetailComponent},
  {path: 'list', component:EmployeeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeDetailComponent } from './employee-detail/employee-detail.component';
import { EmployeeComponent } from './employee/employee.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from '../app/auth/auth.guard';

const routes: Routes = [
  {path: '', redirectTo:'/list', pathMatch:'full'},
  {path: 'detail/:id', component: EmployeeDetailComponent,canActivate:[AuthGuard]},
  {path: 'list', component:EmployeeComponent},
  {path: 'login', component: LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEmpComponent } from './add-emp/add-emp.component';
import { ViewEmpComponent } from './view-emp/view-emp.component';

const routes: Routes = [{
  path: 'view', component: ViewEmpComponent
}, {
  path: 'add', component: AddEmpComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

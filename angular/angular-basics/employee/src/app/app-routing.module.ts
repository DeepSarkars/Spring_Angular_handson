import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ViewEmpComponent } from './view-emp/view-emp.component';

const routes: Routes = [
  {path:'',component: HomeComponent},
  {path:'view',component: ViewEmpComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

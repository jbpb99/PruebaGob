import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateCustomersComponent } from './components/create-customers/create-customers.component';
import { CreateEmpleadosComponent } from './components/create-empleados/create-empleados.component';
import { InicioComponent } from './components/inicio/inicio.component';
import { ListCustomersComponent } from './components/list-customers/list-customers.component';
import { ListEmpleadosComponent } from './components/list-empleados/list-empleados.component';

const routes: Routes = [
  //Redirect if there's nothing there
  { path: '', redirectTo: 'inicio', pathMatch: 'full'},
  { path: 'inicio', component: InicioComponent},
  { path: 'list-employees', component: ListEmpleadosComponent },
  { path: 'createEmployee', component: CreateEmpleadosComponent},
  { path: 'list-customers', component: ListCustomersComponent},
  { path: 'createCustomer', component: CreateCustomersComponent},
  //Redirect if the URL is not valid
  { path: '**', redirectTo: 'inicio', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

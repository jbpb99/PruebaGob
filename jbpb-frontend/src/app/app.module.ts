import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';

import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { ListEmpleadosComponent } from './components/list-empleados/list-empleados.component';
import { CreateEmpleadosComponent } from './components/create-empleados/create-empleados.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ListCustomersComponent } from './components/list-customers/list-customers.component';
import { CreateCustomersComponent } from './components/create-customers/create-customers.component';
import { InicioComponent } from './components/inicio/inicio.component';
import { EmpleadoService } from './services/empleado.service';

@NgModule({
  declarations: [
    AppComponent,
    ListEmpleadosComponent,
    CreateEmpleadosComponent,
    NavbarComponent,
    ListCustomersComponent,
    CreateCustomersComponent,
    InicioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [EmpleadoService],
  bootstrap: [AppComponent]
})
export class AppModule { }

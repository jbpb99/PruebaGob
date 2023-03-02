import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employees } from 'src/app/classes/employees/employees';
import { EmpleadoService } from 'src/app/services/empleado.service';

@Component({
  selector: 'app-create-empleados',
  templateUrl: './create-empleados.component.html',
  styleUrls: ['./create-empleados.component.css']
})
export class CreateEmpleadosComponent implements OnInit {
  empleado = new Employees();


  constructor(private router: Router, private employeeService: EmpleadoService) { }

  ngOnInit() {
    
  }

  save(empleado:Employees) {
    this.employeeService.save(empleado)
    .subscribe(data => {
      alert("Se agregó al empleado con éxito.");
      this.router.navigate(["list-employees"]);
    })
  }
  

}

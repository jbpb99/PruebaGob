import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employees } from 'src/app/classes/employees/employees';
import { EmpleadoService } from 'src/app/services/empleado.service';

@Component({
  selector: 'app-edit-empleados',
  templateUrl: './edit-empleados.component.html',
  styleUrls: ['./edit-empleados.component.css']
})
export class EditEmpleadosComponent implements OnInit {
  empleado: Employees = new Employees();

  constructor(private router: Router, private employeeService: EmpleadoService) { }

  ngOnInit() {
    this.editar();
  }

  editar() {
    //Obtener la información por id
    let id = JSON.parse(localStorage.getItem("id")!);
    this.employeeService.findById(id)
    .subscribe(data=> {
      this.empleado=data;
    })
  }

  update(empleado: Employees) {
    this.employeeService.updateEmpleado(empleado)
    .subscribe(data=> {
      alert("Empleado actualizado");
      this.empleado = data;
      this.router.navigate(["list-employees"]);
    })
  }

}

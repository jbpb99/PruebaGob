import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employees } from 'src/app/classes/employees/employees';
import { EmpleadoService } from 'src/app/services/empleado.service';

@Component({
  selector: 'app-list-empleados',
  templateUrl: './list-empleados.component.html',
  styleUrls: ['./list-empleados.component.css']
})
export class ListEmpleadosComponent implements OnInit {

  employees: Employees[] = [];

  constructor(private employeeService: EmpleadoService, private router: Router) { }

  ngOnInit() {
    this.employeeService.findAll().subscribe(
      data => {
      this.employees = data;
      }
    );
  }

  editar(empleado: Employees) {
    localStorage.setItem("id", empleado.employee_id.toString());
    this.router.navigate(["edit-employee"]);
  }

  deleteEmpleado(empleado: Employees) {
    if(confirm("¿Deseas eliminar al empleado: "+empleado.employee_id+"- "+empleado.firstName+" "+empleado.lastName+"?")) {
      this.employeeService.deleteEmpleado(empleado)
      .subscribe(data=> {
        this.employees = this.employees.filter(e=>e!==empleado);
        alert("Usuario "+empleado.employee_id+" eliminado");
      })
    }
    
  }

}

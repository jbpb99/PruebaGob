import { Component, OnInit } from '@angular/core';
import { Employees } from 'src/app/classes/employees/employees';
import { EmpleadoService } from 'src/app/services/empleado.service';

@Component({
  selector: 'app-list-empleados',
  templateUrl: './list-empleados.component.html',
  styleUrls: ['./list-empleados.component.css']
})
export class ListEmpleadosComponent implements OnInit {

  employees: Employees[] = [];

  constructor(private employeeService: EmpleadoService) { }

  ngOnInit() {
    this.employeeService.findAll().subscribe(
      data => {
      this.employees = data;
      }
    );
  }

}

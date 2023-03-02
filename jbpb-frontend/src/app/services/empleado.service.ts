import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employees } from '../classes/employees/employees';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {
  private employeeUrl: string;

  constructor(private http: HttpClient) { 
    this.employeeUrl = 'http://localhost:8080/api/v1/employees/';
  }

  findAll(): Observable<Employees[]> {
    return this.http.get<Employees[]>(this.employeeUrl+'get');
  }

  save(employee: Employees) {
    return this.http.post<Employees>(this.employeeUrl+'post', employee);
  }

  findById(id: number) {
    return this.http.get<Employees>(this.employeeUrl+'get/'+id);
  }

  updateEmpleado(empleado: Employees) {
    return this.http.put<Employees>(this.employeeUrl+"update/"+empleado.employee_id, empleado);
  }

  deleteEmpleado(empleado: Employees) {
    return this.http.delete<Employees>(this.employeeUrl+"delete/"+empleado.employee_id);
  }
}

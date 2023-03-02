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

  public findAll(): Observable<Employees[]> {
    return this.http.get<Employees[]>(this.employeeUrl+'get');
  }

  public save(employee: Employees) {
    return this.http.post<Employees>(this.employeeUrl, employee)
  }
}

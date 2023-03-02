import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Customers } from '../classes/customers/customers';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private customerUrl: string;

  constructor(private http: HttpClient) { 
    this.customerUrl = "http://localhost:8080/api/v1/customers/"
  }

  public findAll(): Observable<Customers[]> {
    return this.http.get<Customers[]>(this.customerUrl+'get');
  }
}

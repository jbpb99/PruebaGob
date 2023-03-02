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

  save(customer: Customers) {
    return this.http.post<Customers>(this.customerUrl+'post', customer)
  }

  findById(id: String) {
    return this.http.get<Customers>(this.customerUrl+'get/'+id);
  }

  updateCustomer(customer: Customers) {
    return this.http.put<Customers>(this.customerUrl+"update/"+customer.customer_id, customer);
  }

  deleteCliente(customer: Customers) {
    return this.http.delete<Customers>(this.customerUrl+"delete/"+customer.customer_id);
  }
}

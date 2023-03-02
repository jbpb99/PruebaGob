import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customers } from 'src/app/classes/customers/customers';
import { CustomerService } from 'src/app/services/customer.service';


@Component({
  selector: 'app-list-customers',
  templateUrl: './list-customers.component.html',
  styleUrls: ['./list-customers.component.css']
})
export class ListCustomersComponent implements OnInit {
  customers: Customers[] = [];

  constructor(private customerService: CustomerService, private router: Router) { }

  ngOnInit()  {
    this.customerService.findAll().subscribe(
      data => {
      this.customers = data;
      }
    );
  }

  editar(customer: Customers) {
    localStorage.setItem("id", customer.customer_id.toString());
    this.router.navigate(["edit-customer"]);
  }

  deleteCliente(customer: Customers) {
    if(confirm("¿Deseas eliminar al empleado: "+customer.customer_id+"- "+customer.contactName+"?")) {
      this.customerService.deleteCliente(customer)
      .subscribe(data=> {
        this.customers = this.customers.filter(e=>e!==customer);
        alert("Usuario "+customer.customer_id+" eliminado");
      })
    }
    
  }

}

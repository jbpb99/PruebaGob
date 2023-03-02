import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customers } from 'src/app/classes/customers/customers';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-edit-customers',
  templateUrl: './edit-customers.component.html',
  styleUrls: ['./edit-customers.component.css']
})
export class EditCustomersComponent implements OnInit {
  cliente: Customers= new Customers();

  constructor(private customerService: CustomerService, private router: Router) { }

  ngOnInit() {
    console.log(localStorage.getItem("id"));
    this.editar();
  }

  editar() {
    //Obtener la información por id
    let id = JSON.stringify(localStorage.getItem("id"));
    this.customerService.findById(id)
    .subscribe(data=> {
      this.cliente=data;
    })
  }

  update(customer: Customers) {
    this.customerService.updateCustomer(customer)
    .subscribe(data=> {
      alert("Cliente actualizado");
      this.cliente = data;
      this.router.navigate(["list-customer"]);
    })
  }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customers } from 'src/app/classes/customers/customers';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-create-customers',
  templateUrl: './create-customers.component.html',
  styleUrls: ['./create-customers.component.css']
})
export class CreateCustomersComponent implements OnInit {
  cliente = new Customers();

  constructor(private router: Router, private customerService: CustomerService) { }

  ngOnInit() {
    
  }

  save(customer:Customers) {
    this.customerService.save(customer)
    .subscribe(data => {
      alert("Se agregó al cliente con éxito.");
      this.router.navigate(["list-customers"]);
    })
  }

}

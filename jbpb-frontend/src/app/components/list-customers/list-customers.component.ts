import { Component, OnInit } from '@angular/core';
import { Customers } from 'src/app/classes/customers/customers';
import { CustomerService } from 'src/app/services/customer.service';


@Component({
  selector: 'app-list-customers',
  templateUrl: './list-customers.component.html',
  styleUrls: ['./list-customers.component.css']
})
export class ListCustomersComponent implements OnInit {
  customers: Customers[] = [];

  constructor(private customerService: CustomerService) { }

  ngOnInit()  {
    this.customerService.findAll().subscribe(
      data => {
      this.customers = data;
      }
    );
  }

}

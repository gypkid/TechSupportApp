import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/models/address.model';
import { Customer } from 'src/app/models/customer.model';
import { CustomerService } from 'src/app/_services/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers?: Customer[];
  currentCustomer?: Customer;
  currentIndex = -1;
  firstName = '';

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
    this.retrieveCustomers();
  }

  retrieveCustomers() {
    this.customerService.getCustomers().subscribe(
      data => {
        this.customers = data;
        console.log(data);
      },
      err => {
        console.log(err);
      }
    );
  }

  refreshList(): void {
    this.retrieveCustomers();
    this.currentCustomer = undefined;
    this.currentIndex = -1
  }

  setActiveCustomer(customer: Customer, index: number): void {
    this.currentCustomer = customer;
    this.currentIndex = index;
  }

}

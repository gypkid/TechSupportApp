import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Location } from '@angular/common';
import { Address } from 'src/app/models/address.model';
import { Customer } from 'src/app/models/customer.model';
import { CustomerService } from 'src/app/_services/customer.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {

  customer: Customer = {
    firstName: '',
    lastName: '',
    phonenumber: '',
    address: undefined
  }

  address: Address = {
    street: '',
    number: '',
    zipcode: '',
    city: ''
  }

  submitted = false;

  constructor(private customerService: CustomerService, private router: Router, private location: Location) { }

  ngOnInit(): void {
  }

  onSubmit() {
  }
  

  saveCustomer(): void {
    const addressData = {
      street: this.address.street,
      number: this.address.number,
      zipcode: this.address.zipcode,
      city: this.address.city
    }
    const customerData = {
      firstName: this.customer.firstName,
      lastName: this.customer.lastName,
      phonenumber: this.customer.phonenumber,
      address: addressData
    }

    this.customerService.create(customerData).subscribe(
      response => {
        console.log(response);
        this.submitted = true;
      },
      err => {
        console.log(err);
      }
    );
  }

  newCustomer(): void {
    this.submitted = false;
    this.customer = {
      firstName: '',
      lastName: '',
      address: undefined
    }
  
    this.address = {
      street: '',
      number: '',
      zipcode: '',
      city: ''
    }
  }

}

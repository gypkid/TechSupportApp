import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Address } from 'src/app/models/address.model';
import { Customer } from 'src/app/models/customer.model';
import { CustomerService } from 'src/app/_services/customer.service';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {
  
  currentCustomer: Customer = {
    personId: '',
    firstName: '',
    lastName: '',
    address: undefined
  }

  address: Address = {
    street: '',
    number: '',
    zipcode: '',
    city: ''
  }

  message = ''

  constructor(
    private customerService: CustomerService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.message = '';
    this.getCustomer(this.route.snapshot.params.id);
  }

  getCustomer(id: string): void {
    this.customerService.get(id).subscribe(
      data => {
        this.currentCustomer = data;
        if(data.address != null){
          this.address = data.address as Address;
        }
        console.log(data)
      },
      err => {
        console.log(err);
      }
    ); 
  }

  updateCustomer(): void {
    if(!this.currentCustomer.address){
      const addressData = {
        street: this.address.street,
        number: this.address.number,
        zipcode: this.address.zipcode,
        city: this.address.city
      }
      this.currentCustomer.address = addressData;
    }
    this.customerService.update(this.currentCustomer). subscribe(
      response => {
        console.log(response);
        this.message = response.message;
        this.router.navigate(['/customers']);
      },
      err => {
        console.log(err);
      }
    );
  }

  deleteCustomer(): void {
    this.customerService.delete(this.currentCustomer.personId).subscribe(
      response => {
        console.log(response);
        this.router.navigate(['/customers']);
      },
      err => {
        console.log(err);
      }
    );
  }

}

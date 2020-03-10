import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Customer } from '../customer';

@Component({
  selector: 'app-customersignup',
  templateUrl: './customersignup.component.html',
  styleUrls: ['./customersignup.component.css']
})
export class CustomersignupComponent implements OnInit {
result : string;


customersigning(){
  this._customerService.newcustomer(this.customers).subscribe(x => {
    alert(x);
  })

}
  constructor(private _customerService : CustomerService) { }
  customers = new Customer();
  ngOnInit() {
  }

}

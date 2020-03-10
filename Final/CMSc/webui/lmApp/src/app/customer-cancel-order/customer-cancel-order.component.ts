import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { VendorService } from '../vendor.service';

@Component({
  selector: 'app-customer-cancel-order',
  templateUrl: './customer-cancel-order.component.html',
  styleUrls: ['./customer-cancel-order.component.css']
})
export class CustomerCancelOrderComponent implements OnInit {

  cusId : number;
  ordId : number;
  status : String;
  result : String;

  constructor(private _customerService : CustomerService, private _vendorService : VendorService) { }
  cancel() {
    this._vendorService.acceptOrReject(this.status,this.ordId).subscribe(x => {
      console.log(x);
    })
    //console.log(this.vendors.cusId);
    if(this.status=="Cancel") {
      //this.vendors = JSON.parse(localStorage.getItem('vendor'));
      this._customerService.returnMoney(this.cusId, this.ordId).subscribe(x =>{
        console.log(x);
      })
      this._vendorService.deductVenWallet(this.cusId, this.ordId).subscribe(x =>{
        console.log(x);
      })
    }
  }

  ngOnInit() {
  }


}

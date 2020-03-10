import { Component, OnInit } from '@angular/core';
import { VendorService } from '../vendor.service';
import { Vendor } from '../vendor';
import { Orders } from '../orders';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-vendor-accept-and-reject',
  templateUrl: './vendor-accept-and-reject.component.html',
  styleUrls: ['./vendor-accept-and-reject.component.css']
})
export class VendorAcceptAndRejectComponent implements OnInit {
  vendId : number;
  orderId : number;
  status : string;
  result : string;
  vendors : Vendor;
  order : Orders;
  customer : Customer;

  constructor(private _vendorService : VendorService, private _customerService : CustomerService) { }
  acceptOrReject() {
    console.log(this.status);
    console.log(this.orderId);
    this._vendorService.acceptOrReject(this.status,this.orderId).subscribe(x => {
      console.log(x);
    })

    this._vendorService.findByVendorName(this.vendId).subscribe(x => {
      console.log(x);
      localStorage.setItem('vendor', JSON.stringify(x));
    });
    //console.log(this.vendors.cusId);
    if(this.status=="Rejected") {
      this.vendors = JSON.parse(localStorage.getItem('vendor'));
      this._customerService.returnMoney(this.vendors.cusId, this.orderId).subscribe(x =>{
        console.log(x);
      })
      this._vendorService.deductVenWallet(this.vendors.cusId, this.orderId).subscribe(x =>{
        console.log(x);
      })
    }
  }

  ngOnInit() {
  }
vendor = new Vendor();
order1 = new Orders();
}


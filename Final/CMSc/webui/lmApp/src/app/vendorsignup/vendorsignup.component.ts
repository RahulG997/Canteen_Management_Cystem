import { Component, OnInit } from '@angular/core';
import { VendorService } from '../vendor.service';
import { Vendor } from '../vendor';

@Component({
  selector: 'app-vendorsignup',
  templateUrl: './vendorsignup.component.html',
  styleUrls: ['./vendorsignup.component.css']
})
export class VendorsignupComponent implements OnInit {

  result : string;


vendorsigning(){
  this._vendorService.newvendor(this.vendors).subscribe(x => {
    alert(x);
  })

}
  constructor(private _vendorService : VendorService) { }
  vendors = new Vendor();
  ngOnInit() {
  }

}

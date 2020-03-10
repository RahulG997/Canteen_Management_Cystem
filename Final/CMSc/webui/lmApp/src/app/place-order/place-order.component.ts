import { Component, OnInit } from '@angular/core';
import { Orders } from '../orders';
import { Customer } from '../customer';
import { Menu } from '../menu';
import { Observable } from 'rxjs';
import { MenuService } from '../menu.service';
import { Vendor } from '../vendor';
import { VendorService } from '../vendor.service';
import { Wallet } from '../wallet';
import { WalletService } from '../wallet.service';
import { CustomerService } from '../customer.service';
@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styleUrls: ['./place-order.component.css']
})
export class PlaceOrderComponent implements OnInit {

  customer : Customer;
  menuList : Observable<Menu[]>;
  vendorList : Observable<Vendor[]>;
  walletList : Observable<Wallet[]>;
  result : string;
  //result2 : strin;
  menuFound : Menu;
  price : number;
  ordid : number;
  order : Orders;
  amount : number;
  constructor(private _menuService : MenuService, private _vendorService : VendorService, private _walletService : WalletService, private _customerService : CustomerService) {
    this.customer = localStorage.getItem('customer')? JSON.parse(localStorage.getItem('customer')):[];
    this.model.cusId=this.customer.cusId;

    //this.model.ordId=this.order.ordId;
    this.menuList = _menuService.showMenu();
    this.vendorList = _vendorService.showVendor();
    this.walletList=_walletService.showByWalletCustomerId(this.customer.cusId);
    this.menu.foodName="Dosa";
    //this.model.ordId =parseInt(localStorage.getItem("ordId"));
   }
   showAmount() {
    //  alert("Hi");
    // alert(this.menu.menName);
    let menId : number;
    menId=parseInt(this.menu.foodName);
    this._menuService.searchMenu(menId).subscribe(x => {
      this.menuFound = x;
      this.price=x.foodCost;
    });
    // this.price = this.menuFound.menPrice;
   } 
   placeOrder() {

        console.log("cusid"+this.model.cusId);
        console.log("qua"+this.model.quantity)
        console.log("foodname"+this.menu.foodName);
        console.log("date:"+this.model.ordDate);
        console.log("modeL:" +this.model);
        console.log("balance"+this.customer.currAmt);
    this.model.foodId=parseInt(this.menu.foodName);
    console.log("foodId: "+this.model.foodId);
    //this.model.venId=parseInt(this.vendor.venName);
    //this.model.walType = this.wallet.walType;
    this._customerService.placeOrder(this.model).subscribe(x => {
      this.result= x;
      //localStorage.setItem("ordId", ordid);
    })
    this._customerService.orderidgetting(this.model.cusId).subscribe(data => {
        console.log(data);
        //var myJSON = JSON.stringify(data);
        this.ordid = data["ordId"];
        //this.customer.currAmt = data["currAmt"];
        //this.amount = data[""]
        console.log( this.ordid);
        console.log( this.customer.currAmt);
        
        console.log( this.menuFound.availQuantity);
        
        console.log( this.model.quantity);
        this._customerService.orderTotal(this.ordid).subscribe(x =>{
          console.log(x);
        })
        if(this.menuFound.availQuantity > this.model.quantity)
        {
        if (this.customer.currAmt > data["total"])
        {
          this._customerService.deductAmount(this.customer.cusId, this.ordid).subscribe(x =>{
            alert("Your Order is placed");
            console.log(x);
          })
          this._vendorService.updateCusId(this.customer.cusId).subscribe(x =>{
            console.log(x);
          })
          this._vendorService.updateVenWallet(this.customer.cusId, this.ordid).subscribe(x =>{
            console.log(x);
          })
          this._menuService.updateMenuQuantity(this.model.quantity, this.model.foodId).subscribe(x=>{
            console.log(x);
          })
          this._customerService.orderToken(this.ordid).subscribe(x=>{
            console.log(x);
          })
        }
      } else{
        alert("food quantity is not available");
      }
        //console.log(this.customer.cusId);
    })
    
   }


  model = new Orders();
  menu = new Menu();
  vendor = new Vendor();
  wallet = new Wallet();
  ngOnInit() {
  }

}

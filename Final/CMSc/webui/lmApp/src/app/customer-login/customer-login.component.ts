import { Component, OnInit } from 'node_modules/@angular/core';
import { CustomerService } from '../customer.service';
import { Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import {Router} from '@angular/router';
import { Customer } from '../customer';

@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.css']
})
export class CustomerLoginComponent implements OnInit {

  result : any = {res:''};
  test : string;
  custId : number;
  userName : string;
  passWord : string;
  customer = new Customer();
  count : number;
  amount : number;

  validate()  {
      this.customerService.validateCustomer(this.userName,this.passWord).subscribe( data => {
        if(data[4].toString == this.userName.toString){

        
        localStorage.setItem("user", this.userName);
        localStorage.setItem("pwd", this.passWord);

        //localStorage.setItem("cusno", Number(data[0]));
        //console.log(data[0].toString);
        //var obj = JSON.parse(data);
        //let key = 'custId';
       
        //localStorage.setItem('custId', myJSON[2]);
        this.router.navigate(["/dashBoard"]);
        //console.log(data["cusId"]);
     } else {
        this.count++;
      }
     console.log("DATA " +data);
     //this.amount =data["cusId"];
     var myJSON = JSON.parse(data);
     this.custId = myJSON["cusId"];
     this.customer.currAmt = myJSON["currAmt"];
     //parseInt(localStorage.setItem("custId", data));
     console.log(this.customer.cusId);
     },
    err => {
      console.log(err);
    })
  }
  
  
  constructor(private customerService : CustomerService, private router : Router) { 
    this.count=0;
    
  }

  ngOnInit() {
    this.validate();
  }

}

import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import { Customer } from './customer';
import { Orders } from './orders';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http : Http) { }

  validateCustomer(user : string, pwd : string) : Observable<string> {
    return this.
    http.get("http://localhost:8080/MLP191/api/customer/check/"+user+"/"+pwd).
    map((res : Response) => res.text());
  }
  findByCustomerName(user : string) : Observable<Customer> {
    return this.
    http.get("http://localhost:8080/MLP191/api/customer/displayDetails/"+user).
    map((res : Response) => res.json());
  }
  deductAmount(cusId : number, orderId : number) : Observable<string> {
    return this.
    http.put("http://localhost:8080/MLP191/api/customer/deductAmount/"+cusId+"/"+orderId,null).
    map((res : Response) => res.text());
  }
  orderidgetting(custId : number) : Observable<Orders[]> {
    return this.
    http.get("http://localhost:8080/MLP191/api/orders/getordid/"+custId).
    map((res : Response) => res.json());
  }
  orderToken(orderid : number) : Observable<string> {
    return this.
    http.put("http://localhost:8080/MLP191/api/orders/updateorderstoken/"+orderid, null).
    map((res : Response) => res.text());
  }
  orderTotal(orderid : number) : Observable<string> {
    return this.
    http.put("http://localhost:8080/MLP191/api/orders/updateorderstotal/"+ orderid, null).
    map((res : Response) => res.text());
  }

  returnMoney( cusId: number, orderId : number) : Observable<string> {
    return this.http.put("http://localhost:8080/MLP191/api/customer/returnMoney/"+cusId + "/" +orderId,null).
    map((res : Response) => res.text());
  }
  placeOrder(orders : Orders) : Observable<string> {
    return this.http.post("http://localhost:8080/MLP191/api/orders/placeOrder/",orders).
    map((res : Response) => res.text());
  }
  orderHistory() : Observable<Orders[]> {
    return this.
    http.get("http://localhost:8080/MLP191/api/orders/fullorders").
    map((res : Response) => res.json());
  }

  newcustomer(customers : Customer) : Observable<string> {
    return this.http.post("http://localhost:8080/MLP191/api/customer/addCustomer/",customers).
    map((res : Response) => res.text());
  }
}

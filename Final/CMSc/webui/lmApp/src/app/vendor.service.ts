import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import { Vendor } from './vendor';
import { Orders } from './orders';
@Injectable({
  providedIn: 'root'
})
export class VendorService {

  constructor(private http : Http) { }

  validateVendor(user : string, pwd : string) : Observable<string> {
    return this.
    http.get("http://localhost:8080/MLP191/api/vendor/checkVendor/"+user+"/"+pwd).
    map((res : Response) => res.text());
  }
  findByVendorName(user : number) : Observable<Vendor> {
    return this.
    http.get("http://localhost:8080/MLP191/api/vendor/vendetails/"+user).
    map((res : Response) => res.json());
  }

  updateCusId(cusId : number) : Observable<String> {
    return this.
    http.put("http://localhost:8080/MLP191/api/vendor/updatecustid/"+cusId, null).
    map((res : Response) => res.text());
  }
  updateVenWallet(cusId : number, orderId : number) : Observable<String> {
    return this.
    http.put("http://localhost:8080/MLP191/api/vendor/updateVendorWallet/"+cusId+"/"+orderId, null).
    map((res : Response) => res.text());
  }
  deductVenWallet(cusId : number, orderId : number) : Observable<String> {
    return this.
    http.put("http://localhost:8080/MLP191/api/vendor/deductvendorwallet/"+cusId+"/"+orderId, null).
    map((res : Response) => res.text());
  }
  acceptOrReject( status : String, orderId : number) : Observable<string> {
    return this.http.put("http://localhost:8080/MLP191/api/orders/updatestatus/"+status + "/" +orderId,null).
    map((res : Response) => res.text());
  }
  newvendor(vendors : Vendor) : Observable<string> {
    return this.http.post("http://localhost:8080/MLP191/api/vendor/addVendor/",vendors).
    map((res : Response) => res.text());
  }
  orderHistory(cusId : number) : Observable<Orders[]> {
    return this.
    http.get("http://localhost:8080/MLP191/api/orders/listorders/" +cusId).
    map((res : Response) => res.json());
  }
  pendingHistory() : Observable<Orders[]> {
    return this.
    http.get("http://localhost:8080/MLP191/api/orders/fullorders/").
    map((res : Response) => res.json());
  }
  showVendor() : Observable<Vendor[]>{
    return this.
    http.get("http://localhost:8080/MLP191/api/vendor").
    map((res : Response)=> res.json());
  }


}
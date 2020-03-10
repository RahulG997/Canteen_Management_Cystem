import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs';
import {Wallet} from './wallet';
import 'rxjs/add/operator/map';

@Injectable({
  providedIn: 'root'
})
export class WalletService {

  constructor(private http : Http) { }


  
  addMoney( amount: number, cusId : number) : Observable<string> {
    return this.http.put("http://localhost:8080/MLP191/api/customer/addmoney/"+ amount + "/" +cusId ,null).
    map((res : Response) => res.text());
  }
}

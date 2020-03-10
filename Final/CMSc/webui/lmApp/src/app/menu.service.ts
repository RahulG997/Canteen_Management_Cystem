import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs';
import {Menu} from './menu';
import 'rxjs/add/operator/map';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor(private http : Http) {}
  searchMenu(foodId : number) : Observable<Menu>{
    return this.
    http.get("http://localhost:8080/MLP191/api/menu/selectMenu/"+foodId).
    map((res : Response)=> res.json());
}
  showMenu() : Observable<Menu[]>{
    return this.
    http.get("http://localhost:8080/MLP191/api/menu/showMenu").
    map((res : Response)=> res.json());
}

updateMenuQuantity(quan : number, foodId : number) : Observable<String> {
  return this.
  http.put("http://localhost:8080/MLP191/api/menu/updateMenuQuantity/"+quan+"/"+foodId, null).
  map((res : Response) => res.text());
}

}

import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { map, Subject } from "rxjs";
import { Order, PlaceOrderResponse } from "./models";

const URL = "http://localhost:8080/api/order";

@Injectable()
export class CartService{

    constructor(private http: HttpClient){}

private formChange = new Subject<any>;

    addOrder(order: Order){
        this.http.post(URL, order)
        .subscribe(data => console.log(data));
            // .subscribe(data=>
            //     this.formChange.next(data))
    }
}
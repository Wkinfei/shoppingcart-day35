import { Component } from '@angular/core';
import { CartService } from './cart.service';
import { Order } from './models';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private cartSrv: CartService){}

  newOrder(order: Order){
    console.log(">>>>Order root",order)
    //call service.method
    this.cartSrv.addOrder(order)
  }
}

import { Component, OnInit, Output } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subject } from 'rxjs';
import { Order } from 'src/app/models';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit{

  @Output()
	onNewOrder = new Subject<Order>()
  
  form!: FormGroup;
  lineItems!:FormArray;

  constructor(private fb : FormBuilder){}
  
  ngOnInit(): void {
    this.form = this.createOrderForm()
  }

  addItem(){
    // console.log("add items")
    this.lineItems.push(this.createLineItem());
  }

  saveOrder(){
    const order = this.form.value as Order
		this.onNewOrder.next(order)
  }

  removeItem(idx:number){
    this.lineItems.removeAt(idx)
  }

  formInvalid(): boolean {
		return this.form.invalid || this.lineItems.controls.length <= 0
	}

  private createOrderForm(){
    this.lineItems = this.fb.array([])
    return this.fb.group({
      name: this.fb.control<string>('',[Validators.required]),
      email: this.fb.control<string>('',[Validators.required, Validators.email]),
      lineItems: this.lineItems
    })
  }

  private createLineItem(): FormGroup{
    return this.fb.group({
      items: this.fb.control<string>('',[Validators.required]),
      quantity: this.fb.control<number>(1,[Validators.required,Validators.min(1)])
    })
  }


}

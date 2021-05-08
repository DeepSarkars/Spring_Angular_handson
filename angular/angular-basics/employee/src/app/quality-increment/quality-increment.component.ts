import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-quality-increment',
  templateUrl: './quality-increment.component.html',
  styleUrls: ['./quality-increment.component.css']
})
export class QualityIncrementComponent implements OnInit {

  constructor() { }
 message;
 
  ngOnInit(): void {
    var message=null;
  }
  count:number=0;
  increment(event){
    this.count++;

  }
  decrement(event){
    this.count--;

  }
}

import { Component, OnInit } from '@angular/core';
import { Type } from 'src/app/models/type.model';
import { TypeService } from 'src/app/_services/type.service';

@Component({
  selector: 'app-add-type',
  templateUrl: './add-type.component.html',
  styleUrls: ['./add-type.component.css']
})
export class AddTypeComponent implements OnInit {

  type: Type = {
    type: ''
  };

  submitted = false;

  constructor(private typeService: TypeService) { }

  ngOnInit(): void {
  }

  saveType(): void {
    const typeData = {
      type: this.type.type
    }

    this.typeService.create(typeData).subscribe(
      response => {
        console.log(response);
        this.submitted = true;        
      },
      err => {
        console.log(err);
      }
    );
  }

  newType(): void {
    this.submitted = false;
    this.type = {
      type: ''
    }
  }

}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Type } from 'src/app/models/type.model';
import { TypeService } from 'src/app/_services/type.service';

@Component({
  selector: 'app-type-details',
  templateUrl: './type-details.component.html',
  styleUrls: ['./type-details.component.css']
})
export class TypeDetailsComponent implements OnInit {

  currentType: Type = {
    typeId: 0,
    type: '',
    deviceList: undefined
  };

  message = '';

  constructor(
    private typeService: TypeService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.message = '';
    this.getType(this.route.snapshot.params.id);
  }

  getType(id: string): void {
    this.typeService.get(id).subscribe(
      data => {
        this.currentType = data;
        console.log(data);
      },
      err => {
        console.log(err);
      }
    );
  }

  updateType(): void {
    this.typeService.update(this.currentType).subscribe(
      response => {
        console.log(response);
        this.message = response.message;
        this.router.navigate(['/type']);
      },
      err => {
        console.log(err);
      }
    );
  }

  deleteType(): void {
    this.typeService.delete(this.currentType.typeId).subscribe(
      response => {
        console.log(response);
        this.router.navigate(['/type']);
      },
      err => {
        console.log(err);
      }
    );
  }

}

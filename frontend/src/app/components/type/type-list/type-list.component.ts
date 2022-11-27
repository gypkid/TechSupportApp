import { Component, OnInit } from '@angular/core';
import { Type } from 'src/app/models/type.model';
import { TokenStorageService } from 'src/app/_services/token-storage.service';
import { TypeService } from 'src/app/_services/type.service';

@Component({
  selector: 'app-type-list',
  templateUrl: './type-list.component.html',
  styleUrls: ['./type-list.component.css']
})
export class TypeListComponent implements OnInit {

  types?: Type[];
  currentType?: Type;
  currentIndex = -1;
  type = '';

  constructor(private typeService: TypeService, private tokenService:TokenStorageService) { }

  ngOnInit(): void {
    this.retrieveTypes();
  }

  retrieveTypes() {
    const user = this.tokenService.getUser()

    console.log(user);
    

    this.typeService.getTypes().subscribe(
      data => {
        this.types = data;
        console.log(data);
      },
      err => {
        console.log(err);
      }
    );
  }

  refreshList(){
    this.retrieveTypes();
    this.currentIndex = -1;
    this.currentType = undefined;
  }

  setActiveType(type: Type, index: number): void {
    this.currentIndex = index;
    this.currentType = type;
  }

}

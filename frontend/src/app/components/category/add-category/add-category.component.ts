import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/models/category.model';
import { Device } from 'src/app/models/device.model';
import { CategoryService } from 'src/app/_services/category.service';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit {
  
  category: Category = {
    name: ''
  };

  submitted = false;

  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
  }

  saveCustomer(): void {
    const categoryData = {
      name: this.category.name
    }

    this.categoryService.create(categoryData).subscribe(
      response => {
        console.log(response);
        this.submitted = true;
      },
      err => {
        console.log(err);
      }
    );
  }

  newCategory(): void {
    this.submitted = false;
    this.category = {
      name: '',
    }
  }

}

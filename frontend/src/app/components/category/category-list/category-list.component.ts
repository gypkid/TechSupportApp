import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/models/category.model';
import { CategoryService } from 'src/app/_services/category.service';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

  categories?: Category[];
  currentCategory?: Category;
  currentIndex = -1;
  name = '';

  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.retrieveCategories();
  }

  retrieveCategories() {
    this.categoryService.getCategories().subscribe(
      data => {
        this.categories = data;
        console.log(data);
      },
      err => {
        console.log(err);
      }
    );
  }

  refreshList(){
    this.retrieveCategories();
    this.currentIndex = -1;
    this.currentCategory = undefined;
  }

  setActiveCategory(category: Category, index: number): void{
    this.currentIndex = index;
    this.currentCategory = category;
  }


}

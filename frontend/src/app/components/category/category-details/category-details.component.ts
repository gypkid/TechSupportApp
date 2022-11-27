import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router} from '@angular/router';
import { Category } from 'src/app/models/category.model';
import { CategoryService } from 'src/app/_services/category.service';

@Component({
  selector: 'app-category-details',
  templateUrl: './category-details.component.html',
  styleUrls: ['./category-details.component.css']
})
export class CategoryDetailsComponent implements OnInit {

  currentCategory: Category = {
    categoryId: 0,
    name: '',
    deviceList: undefined
  }

  message = '';

  constructor(
    private categoryService: CategoryService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.message = '';
    this.getCategory(this.route.snapshot.params.id);
  }

  getCategory(id: string): void{
      this.categoryService.get(id).subscribe(
        data => {
          this.currentCategory = data;
          console.log(data);
        },
        err => {
          console.log(err);
        }
      );
  }

  updateCategory(): void {
    this.categoryService.update(this.currentCategory).subscribe(
      response => {
        console.log(response);
        this.message = response.message;
        this.router.navigate(['/category']);
      },
      err => {
        console.log(err);
      }
    );
  }

  deleteCategory(): void {
    this.categoryService.delete(this.currentCategory.categoryId).subscribe(
      response => {
        console.log(response);
        this.router.navigate(['/category']);
      },
      err => {
        console.log(err);
      }
    );
  }

}

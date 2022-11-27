import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../models/category.model';

const API_URL = 'http://localhost:8080/api/categories/';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) { }

  getCategories(): Observable<Category[]>{
    return this.http.get<Category[]>(API_URL);
  }

  get(id: any): Observable<Category>{
    return this.http.get(`${API_URL}${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(API_URL, data);
  } 

  update(data:any): Observable<any> {
    return this.http.put(API_URL, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${API_URL}${id}`);
  }
}

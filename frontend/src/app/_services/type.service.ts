import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Type } from '../models/type.model';

const API_URL = 'http://localhost:8080/api/types';

@Injectable({
  providedIn: 'root'
})
export class TypeService {

  constructor(private http: HttpClient) { }

  getTypes(): Observable<Type[]>{
    return this.http.get<Type[]>(API_URL);
  }

  get(id: any): Observable<Type>{
    return this.http.get(`${API_URL}/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(API_URL, data);
  } 

  update(data:any): Observable<any> {
    return this.http.put(API_URL, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${API_URL}/${id}`);
  }
}

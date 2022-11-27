import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Device } from '../models/device.model';

const API_URL = 'http://localhost:8080/api/devices';

@Injectable({
  providedIn: 'root'
})
export class DeviceService {

  constructor(private http: HttpClient) { }

  getCustomers(): Observable<Device[]>{
    return this.http.get<Device[]>(API_URL);
  }

  get(id: any): Observable<Device>{
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

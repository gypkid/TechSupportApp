import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { ProfileComponent } from './components/profile/profile.component';
import { BoardAdminComponent } from './components/board-admin/board-admin.component';
import { BoardModeratorComponent } from './components/board-moderator/board-moderator.component';
import { BoardUserComponent } from './components/board-user/board-user.component';
import { CustomerListComponent } from './components/customer/customer-list/customer-list.component';
import { AddCustomerComponent } from './components/customer/add-customer/add-customer.component';
import { CustomerDetailsComponent } from './components/customer/customer-details/customer-details.component';

import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { DeviceListComponent } from './components/device/device-list/device-list.component';
import { DeviceDetailsComponent } from './components/device/device-details/device-details.component';
import { AddDeviceComponent } from './components/device/add-device/add-device.component';
import { AddCategoryComponent } from './components/category/add-category/add-category.component';
import { CategoryListComponent } from './components/category/category-list/category-list.component';
import { CategoryDetailsComponent } from './components/category/category-details/category-details.component';
import { AddTypeComponent } from './components/type/add-type/add-type.component';
import { TypeDetailsComponent } from './components/type/type-details/type-details.component';
import { TypeListComponent } from './components/type/type-list/type-list.component';
import { AddTaskComponent } from './components/task/add-task/add-task.component';
import { TaskDetailsComponent } from './components/task/task-details/task-details.component';
import { TaskListComponent } from './components/task/task-list/task-list.component';
import { TaskMyComponent } from './components/task/task-my/task-my.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardModeratorComponent,
    BoardUserComponent,
    CustomerListComponent,
    AddCustomerComponent,
    CustomerDetailsComponent,
    DeviceListComponent,
    DeviceDetailsComponent,
    AddDeviceComponent,
    AddCategoryComponent,
    CategoryListComponent,
    CategoryDetailsComponent,
    AddTypeComponent,
    TypeDetailsComponent,
    TypeListComponent,
    AddTaskComponent,
    TaskDetailsComponent,
    TaskListComponent,
    TaskMyComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }

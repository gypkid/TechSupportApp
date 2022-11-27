import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { ProfileComponent } from './components/profile/profile.component';
import { BoardUserComponent } from './components/board-user/board-user.component';
import { BoardModeratorComponent } from './components/board-moderator/board-moderator.component';
import { BoardAdminComponent } from './components/board-admin/board-admin.component';
import { CustomerListComponent } from './components/customer/customer-list/customer-list.component';
import { CustomerDetailsComponent } from './components/customer/customer-details/customer-details.component';
import { AddCustomerComponent } from './components/customer/add-customer/add-customer.component';
import { CategoryListComponent } from './components/category/category-list/category-list.component';
import { AddCategoryComponent } from './components/category/add-category/add-category.component';
import { CategoryDetailsComponent } from './components/category/category-details/category-details.component';
import { TypeListComponent } from './components/type/type-list/type-list.component';
import { AddTypeComponent } from './components/type/add-type/add-type.component';
import { TypeDetailsComponent } from './components/type/type-details/type-details.component';
import { TaskMyComponent } from './components/task/task-my/task-my.component';
import { TaskListComponent } from './components/task/task-list/task-list.component';
import { TaskDetailsComponent } from './components/task/task-details/task-details.component';
import { AddTaskComponent } from './components/task/add-task/add-task.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  { path: 'mod', component: BoardModeratorComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: 'customer', component: CustomerListComponent },
  { path: 'customer/add', component: AddCustomerComponent},
  { path: 'customer/:id', component: CustomerDetailsComponent},
  { path: 'category', component: CategoryListComponent},
  { path: 'category/add', component: AddCategoryComponent},
  { path: 'category/:id', component: CategoryDetailsComponent},
  { path: 'type', component: TypeListComponent},
  { path: 'type/add', component: AddTypeComponent},
  { path: 'type/:id', component: TypeDetailsComponent},
  { path: 'task', component: TaskListComponent},
  { path: 'task/add', component: AddTaskComponent},
  { path: 'task/my', component: TaskMyComponent},
  { path: 'task/:id', component: TaskDetailsComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

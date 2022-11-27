import { Component, OnInit } from '@angular/core';
import { Task } from 'src/app/models/task.model';
import { TaskService } from 'src/app/_services/task.service';
import { TokenStorageService } from 'src/app/_services/token-storage.service';

@Component({
  selector: 'app-task-my',
  templateUrl: './task-my.component.html',
  styleUrls: ['./task-my.component.css']
})
export class TaskMyComponent implements OnInit {
  currentUser: any;
  user : any = {
    id: ''
  }
  tasks?: Task[];
  currentTask?: Task;
  currentIndex = -1;
  taskId?: '';
  constructor(private taskService: TaskService, private tokenService: TokenStorageService) { }

  ngOnInit(): void {
    this.currentUser = this.tokenService.getUser();
    this.user = {
      userId: this.currentUser.id
    }
    
    this.retrieveTasks();
  }

  retrieveTasks() {
    console.log(this.user);
    
    this.taskService.getTasksByUser(this.user).subscribe(
      data => {
      this.tasks = data;
      console.log(data);
    },
    err => {
      console.log(err);
    });
  }

  refreshList(): void {
    this.currentUser = this.tokenService.getUser();
    this.retrieveTasks();
    this.currentTask = undefined;
    this.currentIndex = -1
  }

  setActiveTask(task: Task, index: number): void {
    this.currentTask = task;
    this.currentIndex = index;
  }

}

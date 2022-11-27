import { Component, OnInit } from '@angular/core';
import { Task } from 'src/app/models/task.model';
import { TaskService } from 'src/app/_services/task.service';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {
  tasks?: Task[];
  taskId?: '';

  constructor(private taskService: TaskService) { }

  ngOnInit(): void {
    this.retrieveTasks();
  }

  retrieveTasks() {
    this.taskService.getTasks().subscribe(
      data => {
      this.tasks = data;
      console.log(data);
    },
    err => {
      console.log(err);
    });
  }

  refreshList(): void {
    this.retrieveTasks();
  }

}

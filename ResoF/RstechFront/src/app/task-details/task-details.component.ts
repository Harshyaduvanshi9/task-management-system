import { Component, OnInit } from '@angular/core';
import { Task } from '../task.model';
import { ActivatedRoute } from '@angular/router';
import { TaskService } from '../Service/TaskService';

@Component({
  selector: 'app-task-details',
  templateUrl: './task-details.component.html',
  styleUrls: ['./task-details.component.css']
})
export class TaskDetailsComponent implements OnInit{

  task: Task | undefined;

  constructor(
    private route: ActivatedRoute,
    private taskService: TaskService,
    
  ) { }

  ngOnInit(): void {
    this.getTaskDetail();
  }

  getTaskDetail(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.taskService.getTask(id).subscribe(task => this.task = task);
  }

}

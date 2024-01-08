import { Component, OnInit } from '@angular/core';
import { Task } from '../task.model';
import { TaskService } from '../Service/TaskService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-task-component',
  templateUrl: './task-component.component.html',
  styleUrls: ['./task-component.component.css']
})
export class TaskComponentComponent implements OnInit{

  tasks: Task[] = [];
  newTask: Task = { taskName: '', description: '', dueDate: new Date() };
  selectedTask: Task | null = null;  // Track the selected task for editing

  constructor(
    private taskService: TaskService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getTasks();
  }

  getTasks(): void {
    this.taskService.getTasks().subscribe(tasks => this.tasks = tasks);
  }

  addTask(): void {
    if (this.selectedTask) {
      // If a task is selected, update it
      this.taskService.updateTask(this.selectedTask.id!, this.newTask).subscribe(() => {
        this.clearForm();
        this.getTasks();
      });
    } else {
      // If no task is selected, add a new task
      this.taskService.addTask(this.newTask).subscribe(() => {
        this.clearForm();
        this.getTasks();
      });
    }
  }

  updateTask(task: Task): void {
    this.selectedTask = task;
    this.newTask = { ...task };  // Copy the task for editing
  }

  deleteTask(id: number): void {
    this.taskService.deleteTask(id).subscribe(() => this.getTasks());
  }

  viewTaskDetails(id: number): void {
    this.router.navigate(['/task', id]);
  }

  clearForm(): void {
    this.selectedTask = null;
    this.newTask = { taskName: '', description: '', dueDate: new Date() };
  }

  

}

package com.resotech.resotech.Service;



import java.util.List;

import com.resotech.resotech.Model.Task;

public interface TaskService {

    List<Task> getAllTasks();

    Task getTaskById(Long taskId);

    Task createTask(Task task);

    Task updateTask(Long taskId, Task updatedTask);

    void deleteTask(Long taskId);
}


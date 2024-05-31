package com.csc340.jpademo.task;

import com.csc340.jpademo.goal.GoalRepository;
import com.csc340.jpademo.student.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    GoalRepository goalRepository;

    public Object getAllTasks(){
        return taskRepository.findAll();
    }

    public Object getTaskById(int id){
        return taskRepository.findById(id).orElse(null);
    }

    public void addNewTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteTaskById(int id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTaskByGoalId(int goalId) {
        return taskRepository.findByGoalID(goalId);
    }

}

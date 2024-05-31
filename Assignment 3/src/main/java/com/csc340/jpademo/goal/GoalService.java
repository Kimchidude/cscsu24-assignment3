package com.csc340.jpademo.goal;

import com.csc340.jpademo.student.TaskRepository;
import com.csc340.jpademo.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    @Autowired
    GoalRepository goalRepository;

    @Autowired
    TaskRepository taskRepository;

    public Object getAllGoals(){
        return goalRepository.findAll();
    }

    public Object getGoalById(int id){
        return goalRepository.findById(id).orElse(null);
    }

    public void addNewGoal(Goal goal) {
        goalRepository.save(goal);
    }

    public void deleteGoalById(int id) {
        goalRepository.deleteById(id);
    }


    public void addTaskToGoal(int taskId, int goalId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalArgumentException("Invalid task ID"));
        Goal goal = goalRepository.findById(goalId).orElseThrow(() -> new IllegalArgumentException("Invalid goal ID"));
        task.setGoalID(goalId);
        taskRepository.save(task);
    }
}

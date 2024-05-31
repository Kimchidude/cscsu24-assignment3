package com.csc340.jpademo.goal;


import com.csc340.jpademo.task.Task;
import com.csc340.jpademo.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/goals")
public class GoalController {

    @Autowired
    GoalService goalService;
    @Autowired
    TaskService taskService;

    @GetMapping("/all")
    public String allGoals(Model model) {
        model.addAttribute("goalList", goalService.getAllGoals());
        return "goal-list";
    }

    @GetMapping("/{id}")
    public String showGoal(@PathVariable int id, Model model) {
        model.addAttribute("goal", goalService.getGoalById(id));
        model.addAttribute("taskList", taskService.getTaskByGoalId(id));
        return "goal-detail";
    }

    @PostMapping("/create")
    public String createGoal(Goal goal) {
        goalService.addNewGoal(goal);
        return "redirect:/goals/all";
    }

    @PostMapping("/update")
    public String updateGoal(Goal goal) {
        goalService.addNewGoal(goal);
        return "redirect:/goals/" + goal.getId();
    }

    @GetMapping("/update/{id}")
    public String updateGoal(@PathVariable int id, Model model) {
        model.addAttribute("taskList", taskService.getAllTasks());
        model.addAttribute("goal", goalService.getGoalById(id));
        return "goal-update";
    }

    @GetMapping("delete/{id}")
    public String deleteGoal(@PathVariable int id) {
        goalService.deleteGoalById(id);
        return "redirect:/goals/all";
    }

    @PostMapping("/addTaskToGoal")
    public String addTaskToGoal(@RequestParam("goalId") int goalId, @RequestParam("taskId") int taskId) {
        goalService.addTaskToGoal(taskId, goalId);
        return "redirect:/goals/update/" + goalId;
    }



}

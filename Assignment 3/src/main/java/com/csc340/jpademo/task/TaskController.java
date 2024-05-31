package com.csc340.jpademo.task;


import com.csc340.jpademo.goal.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;
    @Autowired
    GoalService goalService;

    @GetMapping("/all")
    public String allTasks(Model model) {
        model.addAttribute("taskList", taskService.getAllTasks());
        return "task-list";
    }

    @GetMapping("/{id}")
    public String showTask(@PathVariable int id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "task-detail";
    }

    @PostMapping("/create")
    public String createTask(Task task) {
        taskService.addNewTask(task);
        return "redirect:/goals/";
    }

    @PostMapping("update")
    public String updateTask(Task task) {
        taskService.addNewTask(task);
        return "redirect:/tasks/" + task.getId();
    }

    @GetMapping("update/{id}")
    public String showUpdateTask(@PathVariable int id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "task-update";
    }

    @GetMapping("delete/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.deleteTaskById(id);
        return "redirect:/tasks/all";
    }

    @PostMapping("/createForGoal")
    public String createTaskForGoal(@RequestParam("name") String name,
                                    @RequestParam("description") String description,
                                    @RequestParam("goalId") int goalId) {
        Task task = new Task();
        task.setName(name);
        task.setDescription(description);
        task.setGoalID(goalId);
        taskService.addNewTask(task);
        return "redirect:/goals/" + goalId;
    }

}

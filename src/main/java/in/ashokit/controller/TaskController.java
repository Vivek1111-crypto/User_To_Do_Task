package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import in.ashokit.Entity.Task;
import in.ashokit.Entity.User;
import in.ashokit.service.TaskService;
import jakarta.servlet.http.HttpSession;

@Controller 
public class TaskController {

    @Autowired
    private TaskService taskService;

    // 🔹 Dashboard Page
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    // 🔹 Show Create Task Page
    @GetMapping("/create-task")
    public String showTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "create-tasks";
    }

    // 🔹 Save Task
    @PostMapping("/save-task")
    public String saveTask(Task task, HttpSession session) {

        User user = (User) session.getAttribute("user");

        taskService.savetask(task, user);  // ✅ fixed method name

        return "redirect:/view-tasks";
    }

    // 🔹 View Tasks
    @GetMapping("/view-tasks")
    public String viewTasks(Model model, HttpSession session) {

        User user = (User) session.getAttribute("user");

        List<Task> tasks = taskService.getTaskByUser(user);

        model.addAttribute("tasks", tasks);  // 🔥 IMPORTANT

        return "view-tasks";
    }
}
package net.felipe.app.controller;

import net.felipe.app.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import net.felipe.app.repository.TaskRepository;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", taskRepository.findAll());
        model.addAttribute("newTodo", new Task());
        return "index";
    }

    @PostMapping("/add")
    public String addTodo(@ModelAttribute Task task) {
        taskRepository.save(task);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "redirect:/";
    }
}
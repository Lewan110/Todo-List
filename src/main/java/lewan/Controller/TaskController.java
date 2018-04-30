package lewan.Controller;

import lewan.dao.TaskDAO;
import lewan.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskDAO taskDAO;

    @RequestMapping("/tasks")
    public String getDays(Model model){

        List<Task> taskList =taskDAO.getTasks();

        model.addAttribute("tasks",taskList);

        return "tasks";
    }
    @GetMapping("/AddTaskForm")
    public String addTaskForm(Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        return "add-task-form";
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute("task") Task task){
        taskDAO.saveTask(task);
        return "redirect:/tasks";
    }
    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("taskId") int id, Model model){
        Task task = taskDAO.getTask(id);
        model.addAttribute("task", task);
        return "add-task-form";
    }

    @GetMapping("/delete")
    public String deleteTask(@RequestParam("taskId") int id){
        taskDAO.deleteTask(id);
        return "redirect:/tasks";
    }
}

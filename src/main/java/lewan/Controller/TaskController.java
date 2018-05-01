package lewan.Controller;

import lewan.dao.TaskDAO;
import lewan.dao.TaskHistoryDAO;
import lewan.entity.Task;
import lewan.entity.TaskHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskDAO taskDAO;

    @Autowired
    private TaskHistoryDAO taskHistoryDAO;

    @RequestMapping("/tasks")
    public String getDays(Model model){

        List<Task> taskList =taskDAO.getTasks();

        model.addAttribute("tasks",taskList);

        List<TaskHistory> taskHistoryList = taskHistoryDAO.getTasks();
        model.addAttribute("tasksHistory",taskHistoryList);

        for (TaskHistory temptask: taskHistoryList
             ) {
            System.out.println(temptask.toString());

        }

        return "/WEB-INF/tasks.jsp";
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

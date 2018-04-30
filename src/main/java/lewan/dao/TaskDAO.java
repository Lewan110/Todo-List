package lewan.dao;

import lewan.entity.Task;

import java.util.List;


public interface TaskDAO {
    public List<Task> getTasks();

    public void saveTask(Task task);

    public Task getTask(int id);

    public void deleteTask(int id);

}

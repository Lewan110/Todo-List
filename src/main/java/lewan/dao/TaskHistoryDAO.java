package lewan.dao;

import lewan.entity.Task;
import lewan.entity.TaskHistory;

import java.util.List;

/**
 * Created by Lewan on 30.04.2018.
 */
public interface TaskHistoryDAO {
    public List<TaskHistory> getTasks();
}

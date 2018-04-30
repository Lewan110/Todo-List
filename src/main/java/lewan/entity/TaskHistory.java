package lewan.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Lewan on 30.04.2018.
 */
@Entity
@Table(name = "task_history")
public class TaskHistory {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "execution_date", columnDefinition="DATE")
    private Date executionDate;

    @Column(name="task_name")
    private String taskName;

    @Column(name="estimated_time")
    private int estimatedTime;

    @Column(name="description")
    private String description;

    public TaskHistory() {
    }

    public TaskHistory(Date executionDate, String taskName, int estimatedTime, String description) {
        this.executionDate = executionDate;
        this.taskName = taskName;
        this.estimatedTime = estimatedTime;
        this.description = description;
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TaskHistory{" +
                "executionDate=" + executionDate +
                ", taskName='" + taskName + '\'' +
                ", estimatedTime=" + estimatedTime +
                ", description='" + description + '\'' +
                '}';
    }
}

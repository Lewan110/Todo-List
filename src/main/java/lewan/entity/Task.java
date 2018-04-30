package lewan.entity;

import javax.persistence.*;


@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="task_name")
    private String taskName;

    @Column(name="estimated_time")
    private int estimatedTime;

    @Column(name="description")
    private String description;

    public Task() {
    }

    public Task(String taskName, int estimatedTime, String description) {
        this.taskName = taskName;
        this.estimatedTime = estimatedTime;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", estimatedTime=" + estimatedTime +
                ", description='" + description + '\'' +
                '}';
    }
}



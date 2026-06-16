package LLD.Problems.TaskManagementSystem.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import LLD.Problems.TaskManagementSystem.enums.PriorityLevel;
import LLD.Problems.TaskManagementSystem.enums.TaskStatus;
import LLD.Problems.TaskManagementSystem.observer.ActivityLogger;
import LLD.Problems.TaskManagementSystem.observer.ITaskObserver;

public class Task {
  private String taskId;
  private String title;
  private String description;
  private User createdBy;
  private User assignedTo;
  private PriorityLevel priority;
  private LocalDateTime dueDate;
  private TaskStatus status;
  private List<ITaskObserver> observers;
  private List<ActivityLog> activityLogs;

  public Task(String id, String heading, String des, User author, PriorityLevel level, LocalDateTime lastDateTime) {
    taskId = id;
    title = heading;
    description = des;
    createdBy = author;
    assignedTo = null;
    priority = level;
    dueDate = lastDateTime;
    status = TaskStatus.TODO;
    observers = new ArrayList<>();
    addObserver(new ActivityLogger());

    activityLogs = new ArrayList<>();
    activityLogs.add(new ActivityLog("Task created. " + taskId));
    notifyObserver();
  }

  public void setAssignedUser(User assignee) {
    if(assignedTo != null) observers.remove(assignedTo);
    assignedTo = assignee;
    observers.add(assignedTo);
  }

  public void addObserver(ITaskObserver observer) {
    observers.add(observer);
  }

  public void removeObserver(ITaskObserver observer) {
    observers.remove(observer);
  }

  public void addLog(ActivityLog log) {
    activityLogs.add(log);
  }

  public void setStatus(TaskStatus updatedStatus) {
    status = updatedStatus;
    ActivityLog log = new ActivityLog("Task status updated to " + status.toString());
    activityLogs.add(log);
    notifyObserver();
  }

  public void setDueDate(LocalDateTime updatedDueDate) {
    dueDate = updatedDueDate;
    ActivityLog log = new ActivityLog("Task due date updated to " + status.toString());
    activityLogs.add(log);
    notifyObserver();
  }

  public void notifyObserver() {
    for(ITaskObserver observer: observers) {
      observer.update(this);
    }
  }

  public void display() {
    System.out.println("Task ID: " + taskId);
    System.out.println("- " + title);
    System.out.println("- " + description);
  }

  // GETTERS
  public String getTaskId() {
    return taskId;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public User getCreatedByUser() {
    return createdBy;
  }

  public User getAssignedUser() {
    return assignedTo;
  }

  public List<ActivityLog> getActivityLogs() {
    return activityLogs;
  }

  public TaskStatus getTaskStatus() {
    return status;
  }

  public PriorityLevel getPriorityLevel() {
    return priority;
  }

  public LocalDateTime getDueDate() {
    return dueDate;
  }
}

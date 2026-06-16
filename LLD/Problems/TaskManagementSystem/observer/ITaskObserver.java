package LLD.Problems.TaskManagementSystem.observer;

import LLD.Problems.TaskManagementSystem.models.ActivityLog;
import LLD.Problems.TaskManagementSystem.models.Task;

public interface ITaskObserver {
  public void update(Task task);
}

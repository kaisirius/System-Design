package LLD.Problems.TaskManagementSystem.observer;

import LLD.Problems.TaskManagementSystem.models.ActivityLog;
import LLD.Problems.TaskManagementSystem.models.Task;

public class ActivityLogger implements ITaskObserver {
  @Override
  public void update(Task task) {
    ActivityLog lastLog = task.getActivityLogs().getLast();
    System.out.println("[LOGGER UPDATE]: Task update received.");
    System.out.println("[LOGGER UPDATE]: " + lastLog.getLogDescription() + " at " + lastLog.getLogTimeStamp() );
  }
}

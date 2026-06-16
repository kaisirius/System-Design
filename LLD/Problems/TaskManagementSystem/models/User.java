package LLD.Problems.TaskManagementSystem.models;

import LLD.Problems.TaskManagementSystem.observer.ITaskObserver;

public class User implements ITaskObserver {
  private String userId;
  private String name;

  public User(String id, String name) {
    userId = id;
    this.name = name;
  }

  public String getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }

  @Override
  public void update(Task task) {
    ActivityLog lastLog = task.getActivityLogs().getLast();
    System.out.println("[USER "+ userId + " UPDATE]: Assigned Task user update received.");
    System.out.println("[USER "+ userId + " UPDATE]: " + lastLog.getLogDescription() + " at " + lastLog.getLogTimeStamp());
  }
}

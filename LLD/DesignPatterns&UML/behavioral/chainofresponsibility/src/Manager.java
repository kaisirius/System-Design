public class Manager extends LeaveApprover {
  @Override 
  public void handleLeaveApproveReq(int days) {
    if(days > 0 && days < 4) {
      System.out.println("Leave approved by Manager");
    } else {
      nextApprover.handleLeaveApproveReq(days);
    }
  }
}

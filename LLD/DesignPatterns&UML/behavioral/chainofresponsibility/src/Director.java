public class Director extends LeaveApprover {
  @Override 
  public void handleLeaveApproveReq(int days) {
    if(days > 3 && days < 8) {
      System.out.println("Leave approved by Director");
    } else {
      System.out.println("Leave not approved");
    }
  }
}

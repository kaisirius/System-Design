public abstract class LeaveApprover {
  protected LeaveApprover nextApprover = null;
  
  public void setNextApprover(LeaveApprover approver) {
    nextApprover = approver;
  }

  public abstract void handleLeaveApproveReq(int days); 
}

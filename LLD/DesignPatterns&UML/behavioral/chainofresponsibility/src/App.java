public class App {
    public static void main(String[] args) throws Exception {
        LeaveApprover manager = new Manager();
        LeaveApprover director = new Director();

        manager.setNextApprover(director);

        manager.handleLeaveApproveReq(2);
        manager.handleLeaveApproveReq(5);
        manager.handleLeaveApproveReq(10);
    }
}

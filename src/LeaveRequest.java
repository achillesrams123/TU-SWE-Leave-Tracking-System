import java.util.ArrayList;

public abstract class LeaveRequest implements Approvable {
    protected int requestId;
    protected Employee employee;
    protected String startDate;
    protected String endDate;
    protected String status;
    protected String leaveType;

    protected ArrayList<StatusChange> statusHistory = new ArrayList<>();

    public LeaveRequest(int requestId, Employee employee, String startDate, String endDate, String leaveType) {
        this.requestId = requestId;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveType = leaveType;
        this.status = "Pending";
    }

    public boolean approve(String approverName) {
        this.status = "Approved";
        statusHistory.add(new StatusChange("Approved", java.time.LocalDate.now().toString(), approverName));
        System.out.println("Request #" + requestId + " approved by " + approverName);
        return true;
    }

    public boolean deny(String approverName, String reason) {
        this.status = "Denied";
        statusHistory.add(new StatusChange("Denied", java.time.LocalDate.now().toString(), approverName));
        System.out.println("Request #" + requestId + " denied by " + approverName + ". Reason: " + reason);
        return true;
    }

    public abstract int calculateLeaveDays();
    public boolean processRequest() {
        System.out.println("Processing generic leave request...");
        return true;
    }

    public void printStatusHistory() {
        System.out.println("---- Status History for Request #" + requestId + " ----");
        for (StatusChange sc : statusHistory) {
            System.out.println(" -> Status set to '" + sc.newStatus + "' by " + sc.changedBy + " on " + sc.changeDate);
        }
        System.out.println("------------------------------------");
    }

    public int getRequestId() { return requestId; }
    public Employee getEmployee() { return employee; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public String getStatus() { return status; }
    public String getLeaveType() { return leaveType; }

    // Inner class
    public class StatusChange {
        private String newStatus;
        private String changeDate;
        private String changedBy;

        public StatusChange(String newStatus, String changeDate, String changedBy) {
            this.newStatus = newStatus;
            this.changeDate = changeDate;
            this.changedBy = changedBy;
        }
    }
}

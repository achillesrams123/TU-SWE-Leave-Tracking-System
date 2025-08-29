public class LeaveRequest {
    private int requestId;
    private Employee employee;
    private String startDate;
    private String endDate;
    private String status;

    // Constructor
    public LeaveRequest(int requestId, Employee employee, String startDate, String endDate) {
        this.requestId = requestId;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "Pending"; // default status
    }
    
    // Approve/Deny Methods
    public void approve() {
        this.status = "Approved";
    }

    public void deny() {
        this.status = "Denied";
    }

    // Getters and Setters
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
}

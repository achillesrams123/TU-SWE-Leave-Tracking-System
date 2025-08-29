import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SickLeaveRequest extends LeaveRequest {
    private boolean medicalCertificateProvided;

    public SickLeaveRequest(int requestId, Employee employee, String startDate, String endDate, boolean medicalCertificateProvided) {
        super(requestId, employee, startDate, endDate, "Sick Leave");
        this.medicalCertificateProvided = medicalCertificateProvided;
    }

    @Override
    public int calculateLeaveDays() {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return (int) ChronoUnit.DAYS.between(start, end) + 1; 
    }

    @Override
    public boolean processRequest() {
        int days = calculateLeaveDays();
        if (days > 2 && !medicalCertificateProvided) {
            System.out.println("-> VALIDATION FAILED: Sick leave longer than 2 days requires a medical certificate.");
            deny("System", "System validation failed");
            return false;
        }
        System.out.println("Processing sick leave request for " + employee.getName() + "...");
        approve("System");
        return true;
    }
}

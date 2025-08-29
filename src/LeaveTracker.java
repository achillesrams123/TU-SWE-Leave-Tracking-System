import java.util.Scanner;

public class LeaveTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create Employee with Scanner
        System.out.print("Enter Employee ID: ");
        int empId = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Employee Name: ");
        String empName = sc.nextLine();

        System.out.print("Enter Department: ");
        String empDept = sc.nextLine();

        Employee emp = new Employee(empId, empName, empDept);

        System.out.println("\nEmployee Created:");
        System.out.println("ID: " + emp.getEmployeeID());
        System.out.println("Name: " + emp.getName());
        System.out.println("Department: " + emp.getDepartment());
        System.out.println("Leave Balance: " + emp.getLeaveBalance());
        
        

        // Create Leave Request
        System.out.print("\nEnter Leave Request ID: ");
        int reqId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Start Date (YYYY-MM-DD): ");
        String startDate = sc.nextLine();

        System.out.print("Enter End Date (YYYY-MM-DD): ");
        String endDate = sc.nextLine();

        System.out.print("Enter number of leave days requested: ");
        int days = sc.nextInt();
        sc.nextLine();

        LeaveRequest request = new LeaveRequest(reqId, emp, startDate, endDate);

        // Process leave request
        boolean approved = emp.requestLeave(days);
        if (approved) {
            request.approve();
            System.out.println("Leave Approved!");
        } else {
            request.deny();
            System.out.println("Leave Denied!");
        }

        // Print Leave Request details
        System.out.println("\nLeave Request Details:");
        System.out.println("Request ID: " + request.getRequestId());
        System.out.println("Employee: " + request.getEmployee().getName());
        System.out.println("Start Date: " + request.getStartDate());
        System.out.println("End Date: " + request.getEndDate());
        System.out.println("Status: " + request.getStatus());
        System.out.println("Remaining Leave Balance: " + emp.getLeaveBalance());

        sc.close();
    }
}

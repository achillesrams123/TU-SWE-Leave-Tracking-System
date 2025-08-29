import java.util.ArrayList;
import java.util.Scanner;

public class LeaveTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<LeaveRequest> leaveRequests = new ArrayList<>();

        // Sample Employees
        employees.add(new Employee(1, "Alice", "HR"));
        employees.add(new Employee(2, "Bob", "IT"));

        System.out.println("Welcome to the HR Leave Management System!");

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Create New Leave Request");
            System.out.println("2. Process a Pending Request");
            System.out.println("3. View All Request Histories");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- Create New Leave Request ---");
                    // List Employees
                    System.out.println("Select an employee:");
                    for (int i = 0; i < employees.size(); i++) {
                        System.out.println((i + 1) + ". " + employees.get(i).getName());
                    }
                    System.out.print("Enter employee number: ");
                    int empIndex = sc.nextInt() - 1;
                    sc.nextLine();
                    Employee emp = employees.get(empIndex);

                    // Leave Type
                    System.out.println("\nSelect leave type:");
                    System.out.println("1. Sick Leave");
                    System.out.println("2. Vacation Leave");
                    System.out.println("3. Maternity Leave");
                    System.out.print("Enter leave type number: ");
                    int leaveType = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Leave Request ID: ");
                    int reqId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Start Date (YYYY-MM-DD): ");
                    String startDate = sc.nextLine();

                    System.out.print("Enter End Date (YYYY-MM-DD): ");
                    String endDate = sc.nextLine();

                    LeaveRequest request = null;

                    if (leaveType == 1) { // Sick Leave
                        System.out.print("Is a medical certificate provided? (true/false): ");
                        boolean medCert = sc.nextBoolean();
                        sc.nextLine();
                        request = new SickLeaveRequest(reqId, emp, startDate, endDate, medCert);
                    } else if (leaveType == 2) { // Vacation Leave
                        System.out.print("Is it paid time off? (true/false): ");
                        boolean paid = sc.nextBoolean();
                        sc.nextLine();
                        request = new VacationLeaveRequest(reqId, emp, startDate, endDate, paid);
                    } else if (leaveType == 3) { // Maternity Leave
                        System.out.print("Enter expected delivery date (YYYY-MM-DD): ");
                        String delivery = sc.nextLine();
                        request = new MaternityLeaveRequest(reqId, emp, startDate, endDate, delivery);
                    }

                    leaveRequests.add(request);
                    System.out.println("\nSuccessfully created " + request.getLeaveType() + " request for " + emp.getName() + ".");
                    break;

                case 2:
                    System.out.println("\n--- Processing Next Pending Request ---");
                    boolean found = false;
                    for (LeaveRequest lr : leaveRequests) {
                        if (lr.getStatus().equals("Pending")) {
                            found = true;
                            System.out.println("Request ID: " + lr.getRequestId());
                            System.out.println("Employee: " + lr.getEmployee().getName());
                            System.out.println("Leave Type: " + lr.getLeaveType());
                            System.out.println("Dates: " + lr.getStartDate() + " to " + lr.getEndDate());
                            System.out.println("Status: " + lr.getStatus());
                            boolean result = lr.processRequest();
                            if (!result) {
                                System.out.println("Request #" + lr.getRequestId() + " denied by System. Reason: System validation failed.");
                            }
                            break; 
                        }
                    }
                    if (!found) {
                        System.out.println("No pending requests found.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- All Leave Request Histories ---");
                    for (LeaveRequest lr : leaveRequests) {
                        System.out.println("Request ID: " + lr.getRequestId() + " | Employee: " + lr.getEmployee().getName() + " | Type: " + lr.getLeaveType() + " | Status: " + lr.getStatus());
                        lr.printStatusHistory();
                    }
                    break;

                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

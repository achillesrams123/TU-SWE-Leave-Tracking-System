
public class Employee {

	private int employeeID;
	private String name;
	private String department;
	private int leaveBalance;
	
	
	
	public Employee(int employeeID, String name, String department) {
		this.employeeID = employeeID;
		this.name = name;
		this.department = department;
		this.leaveBalance = 20;
	}
	
	
	public Employee() {
		this.employeeID = 0;
		this.name = "Unkown";
		this.department = "Unkown";
		this.leaveBalance = 15;
	}
	
	public boolean requestLeave(int numberofDays) {
		
		if (numberofDays <= leaveBalance) {
			leaveBalance -= numberofDays;
			return true;
		}else {
			System.out.println("Insuficient leave balance.");
			return false;
		}
		
	}
	
	
	
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getLeaveBalance() {
		return leaveBalance;
	}
	public void setLeaveBalance(int leaveBalance) {
		this.leaveBalance = leaveBalance;
	}
	
	
	

	
    
    
    
	
	
	
}

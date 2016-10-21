import java.util.Date;

public class Employee extends Person {
	private String officeNumber;
	private double salary;
	private Date dateHired;
	/**
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * @param email
	 */
	public Employee(String name, String address, String phoneNumber, String email, String officeNumber, double salary) {
		super(name, address, phoneNumber, email);
		this.officeNumber = officeNumber;
		this.salary = salary;
		this.dateHired = new Date();
		// TODO Auto-generated constructor stub
	}
	public String getOfficeNumber() {
		return officeNumber;
	}
	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getDateHired() {
		return dateHired;
	}
	@Override
	public String toString() {
		return "CLASS Employee [getName()=" + getName() + "]";
	}
	
	
	
	
}

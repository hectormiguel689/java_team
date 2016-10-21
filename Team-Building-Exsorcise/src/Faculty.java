
public class Faculty extends Employee {
	private String officeHours;
	private String rank;
	/**
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * @param email
	 * @param officeNumber
	 * @param salary
	 * @param officeHours
	 * @param rank
	 */
	public Faculty(String name, String address, String phoneNumber, String email, String officeNumber, double salary,
			String officeHours, String rank) {
		super(name, address, phoneNumber, email, officeNumber, salary);
		this.officeHours = officeHours;
		this.rank = rank;
	}
	public String getOfficeHours() {
		return officeHours;
	}
	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "CLASS Faculty [getName()=" + getName() + "]";
	}

	
	
}


public class Staff extends Employee {
	private String title;

	/**
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * @param email
	 * @param officeNumber
	 * @param salary
	 * @param rank
	 */
	public Staff(String name, String address, String phoneNumber, String email, String officeNumber, double salary,
			String rank) {
		super(name, address, phoneNumber, email, officeNumber, salary);
		this.title = rank;
	}

	public String getRank() {
		return title;
	}

	public void setRank(String rank) {
		this.title = rank;
	}

	@Override
	public String toString() {
		return "CLASS Staff [getName()=" + getName() + "]";
	}
	
	
	
}

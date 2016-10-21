
public class Student extends Person {

	private static final String STATUS = "JUNIOR";

	/**
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * @param email
	 */
	public Student(String name, String address, String phoneNumber, String email) {
		super(name, address, phoneNumber, email);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CLASS Student [getName()=" + getName() + "]";
	}
	
	
	
}

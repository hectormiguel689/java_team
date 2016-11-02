
public class Person implements Comparable<Person> {
	private String name;
	private String address;
	private String phoneNumber;
	private String email;
	/**
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * @param email
	 */
	public Person(String name, String address, String phoneNumber, String email) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "CLASS Person [name=" + name + "]";
	}

	public void bubbleSort(){

	}

	@Override
	public int compareTo(Person person) {
		return this.name.compareTo(person.name);
	}


	
}

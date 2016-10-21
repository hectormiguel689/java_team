
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String name = "Hector";
			String addr = "861 E 41ST";
			String phnmbr = "+17869709425";
			String email = "hector.ramirez07151997@gmail.com";
			String offcenmbr = "A23C";
			double salary = 65031.32;
			String offcehr = "8:00AM - 10:00PM";
			String rank = "Prof";
			String title = "Janitor";
			
			Person hector = new Person(name,addr,phnmbr,email);
			Student hector2 = new Student(name,addr,phnmbr,email);
			Employee hector3 = new Employee(name,addr,phnmbr,email,offcehr,salary);
			Faculty hector4 = new Faculty(name,addr,phnmbr,email,offcenmbr,salary,offcehr,rank);
			Staff hector5 = new Staff(name, addr, phnmbr, email,offcenmbr,salary,rank);
			
			System.out.println(hector);
			System.out.println(hector2);
			System.out.println(hector3);
			System.out.println(hector4);
			System.out.println(hector5);
			
	}

}

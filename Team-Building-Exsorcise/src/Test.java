;import java.util.ArrayList;

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
			String title = "Jantor";

			Person[] person = new Person[5];
			
			person[0] = ( new Person("John",addr,phnmbr,email));
            person[1] =  (new Person("Brian",addr,phnmbr,email));
            person[2] = ( new Person("Hector",addr,phnmbr,email));
            person[3] = ( new Person("Cruz",addr,phnmbr,email));
            person[4] = ( new Person("Lopez",addr,phnmbr,email));

            boubble_sort(person);

        for(int i =0;i < person.length;i++){
            System.out.println(person[i]);
        }

	}

	private static void boubble_sort(Person[] personList){
        Boolean swap;
        do{
            swap = false;
            for(int i = 0;i < personList.length -1;i++){
                if(personList[i].compareTo(personList[i+1]) > 0 ){
                  Person temp = personList[i];
                    personList[i] = personList[i+1];
                    personList[i+1] = temp;
                    swap = true;
                }
            }

        }while(swap);
    }
}

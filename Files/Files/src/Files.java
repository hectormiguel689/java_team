import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class Files {
	public static void main(String[] args){
		JFileChooser fileChooser = new JFileChooser();
		File file = null;
		
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			file = fileChooser.getSelectedFile();
		
		try {
			PrintWriter output = new PrintWriter(file);
			output.println("Test T Test");
			output.println(90);
			output.println("test2 T Test");
			output.println(80);
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Scanner input = new Scanner(file);
			while(input.hasNext()){
				String firstName = input.next();
				String mi = input.next();
				String lastName = input.next();
				int score = input.nextInt();
				System.out.println(firstName + " " + mi + " " + lastName + " "+ score);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else{
			System.out.println("File not Selected!");
		}
	

	/*	System.out.println("Does it exits? " + file.exists());
		System.out.println("The file has " + file.length() + " bytes");
		System.out.println("Can it be read? " + file.canRead());
		System.out.println("Can it be written? " + file.canWrite());
		System.out.println("Is it a Directory? " + file.isDirectory());
		System.out.println("Is it a file? " + file.isFile());
		System.out.println("Is it absolute? " + file.isAbsolute());
		System.out.println("Is it hidden? " + file.isHidden());
		System.out.println("Absolute path is? " + file.getAbsolutePath());
		System.out.println("Last modified? " +  new java.util.Date(file.lastModified()));
		*/
		
	}
	
}

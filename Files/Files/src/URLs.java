import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class URLs {
	public static void main(String[] args){
		int letterCount = 0;
		int wordCount = 0;
		int lineCount = 0;
		int countNonLetters = 0;
		String line = null;
		int count = 0;
		
		try {
			URL url = new URL("https://raw.githubusercontent.com/hectormiguel689/java-projects/master/test");
			URL url2 = new URL("http://cs.armstrong.edu/liang/data/Lincoln.txt");
			Scanner input = new Scanner(url2.openStream());
			while(input.hasNext()){
				line = input.nextLine();
				lineCount++;
				wordCount += countWords(line);
				letterCount += countLetters(line);
				countNonLetters += line.split("\\W").length;
				count += line.length();
			
			}
			System.out.println("File Size: " + count);
			System.out.println("Number of Lines: " + lineCount);
			System.out.println("Number of Words: " + wordCount);
			System.out.println("Number of Letters: " + letterCount);
			System.out.println("Number of Non Letters: " + countNonLetters);
		
			input.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("INVALID URL");;
		}
		catch(IOException ex){
			System.out.println("IO Error!");;

		}
		
		
	}
	private static int countWords(String line){
		return line.split("\\s+").length;
			
	}
	private static int countLetters(String line){
		return line.split("\\w").length;
	}
}

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by hector on 10/28/16.
 */
public class StudentList {
    private ArrayList<Student> students = new ArrayList<Student>();
    private JFileChooser fileChooser = new JFileChooser();

    //Reads Students from the File. -Hector
    public void readStudents(){

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File inputFile = fileChooser.getSelectedFile();
            try {
                Scanner input = new Scanner(inputFile);
                input.useDelimiter("|");
                while(input.hasNext()) {
                    String name = input.next();
                    String grade1 = input.next();
                    String grade2 = input.next();
                    String grade3 = input.next();
                    try {
                        students.add(new Student(name,
                                Integer.parseInt(grade1),
                                Integer.parseInt(grade2),
                                Integer.parseInt(grade3)));

                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public void sortStudents(){
                   students.sort(Comparator.comparing(Student::getAverage).reversed());
            }

    public void writeStudents(){
        if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File outFile = fileChooser.getSelectedFile();
            try {
                PrintWriter output = new PrintWriter(outFile);
                output.println("Name \t\t Grade 1 \t Grade 2 \t Grade 3 \t Average \t\t Status");
                for(int i = 0; i < students.size(); i++){
                    String name = students.get(i).getName();
                    int grade1  = students.get(i).getGrade1();
                    int grade2  = students.get(i).getGreade2();
                    int grade3  = students.get(i).getGrade3();
                    double average = students.get(i).getAverage();
                    String status = students.get(i).getStatus();
                    output.println( name + "\t\t" +
                            grade1 + "\t" +
                            grade2 + "\t" +
                            grade3 + "\t" +
                            average + "\t\t" +
                            status);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

}






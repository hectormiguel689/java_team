/**
 * Created by brian on 10/30/16.
 */
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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

                while(input.hasNext()) {
                    String line = input.nextLine();
                    String name = getData(line,0);
                    String grade1 = getData(line, 1);
                    String grade2 = getData(line, 2);
                    String grade3 = getData(line, 3);
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
                output.println("Name \t\t Grade 1 \t\t Grade 2 \t\t Grade 3 \t\t\t Average \t\t Status\n");
                for(int i = 0; i < students.size(); i++){
                    /*  Too much code..
                    String name = students.get(i).getName();
                    int grade1  = students.get(i).getGrade1();
                    int grade2  = students.get(i).getGreade2();
                    int grade3  = students.get(i).getGrade3();
                    double average = students.get(i).getAverage();
                    String status = students.get(i).getStatus();
                    String data = name + "\t\t" +
                            grade1 + "\t" +
                            grade2 + "\t" +
                            grade3 + "\t" +
                            average + "\t\t" +
                            status;
                    output.print(data);
                    System.out.println(name + "\t\t" +
                            grade1 + "\t" +
                            grade2 + "\t" +
                            grade3 + "\t" +
                            average + "\t\t" +
                            status);
                    */

                    output.print(students.get(i).getName() + "\t\t ");
                    output.print(students.get(i).getGrade1() + " \t\t\t ");
                    output.print(students.get(i).getGrade2() + " \t\t\t ");
                    output.print(students.get(i).getGrade3() + " \t\t\t\t ");
                    output.print(students.get(i).getAverage() + " \t\t\t ");
                    output.print(students.get(i).getStatus() + "\n");
                }
                output.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private String getData(String line, int Index){
        String[] seperateParts = line.split("\\W+");

        return  seperateParts[Index];
    }

}

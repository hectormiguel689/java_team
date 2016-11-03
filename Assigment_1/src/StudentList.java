/**
 * Created by brian on 10/30/16.
 */
import javax.swing.*;
import java.io.*;
import java.util.*;

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
       students = mergeSort(students);
    }


    public void writeStudents(){
        if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File outFile = fileChooser.getSelectedFile();
            try {
                PrintWriter output = new PrintWriter(outFile);
                output.printf("%-10s %8s %8s %8s %10s %10s\n", "Name", "Grade 1", "Grade 2", "Grade 3", "Average", "Status");
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

                   output.printf("%-10s %8s %8s %8s %10s %10s\n", students.get(i).getName(), students.get(i).getGrade1(),
                           students.get(i).getGrade2(),students.get(i).getGrade3(),students.get(i).getAverage(),
                           students.get(i).getStatus());





                }
                output.close();

            } catch (FileNotFoundException e) {
                JOptionPane.showConfirmDialog(null,"Error in Opening the File","Error",JOptionPane.OK_CANCEL_OPTION);
            } catch (IOException e) {
                JOptionPane.showConfirmDialog(null,"Error in Opening the File","Error",JOptionPane.OK_CANCEL_OPTION);
            }

        }
    }

    private String getData(String line, int Index){
        String[] seperateParts = line.split("\\W+");

        return  seperateParts[Index];
    }




    private ArrayList<Student> mergeSort(ArrayList<Student> temp) {
            //students.sort(Comparator.comparing(Student::getAverage).reversed()); --This is the K.I.S.S way, but you want it the hard way...
        ArrayList<Student> list1 = new ArrayList<Student>();
        ArrayList<Student> list2 = new ArrayList<Student>();
        int center;

        if(temp.size() == 1)
            return temp;
        else{
            center = temp.size()/2;
            for(int i = 0; i < center;i++){
                list1.add(temp.get(i));
            }
            for(int i = center; i < temp.size();i++){
                list2.add(temp.get(i));
            }

            list1 = mergeSort(list1);
            list2 = mergeSort(list2);
            merge(list1,list2,temp);
        }

        return temp;
    }

    private void merge(ArrayList<Student> list1, ArrayList<Student> list2, ArrayList<Student> temp) {
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;

        while (counter1 < list1.size() && counter2 < list2.size()) {
            if ( (list1.get(counter1).getAverage().compareTo(list2.get(counter2).getAverage())) > 0) {
                temp.set(counter3, list1.get(counter1));
                counter1++;
            }
            else {
                temp.set(counter3, list2.get(counter2));
                counter2++;
            }
            counter3++;
        }
        ArrayList<Student> remaining;
        int remaindingCounter;
        if (counter1 >= list1.size()) {

            remaining = list2;
            remaindingCounter = counter2;
        }
        else {

            remaining = list1;
            remaindingCounter = counter1;
        }

        for (int i=remaindingCounter; i<remaining.size(); i++) {
            temp.set(counter3, remaining.get(i));
            counter3++;
        }
    }

}


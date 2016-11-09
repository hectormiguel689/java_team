/*---------------------------------------------------
 Group Members:  Brian Delgado, Ileana Manzano, Hector Ramirez

 Student IDs: 1001324591,1001033660,1001095960

 COP 2805C – Java Programming 2

 Fall 2016 - T Th 6:00PM - 9:20PM

 Project # 1

 Plagiarism Statement: I certify that this assignment is my own work and that I have not copied in part or
 whole or otherwise plagiarized the work of other students and/or persons.

----------------------------------------------------------*/
import javax.swing.*;
import java.io.*;
import java.util.*;

public class StudentList {
    private ArrayList<Student> students = new ArrayList<Student>();
    private JFileChooser fileChooser    = new JFileChooser();

    //Reads Student Info from the File. -Hector
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
    //Sort the ArrayList.
    public void sortStudents(){
       students = mergeSort(students);
    }

    //Writes the ArrayList to the File.
    public void writeStudents(){
        if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File outFile = fileChooser.getSelectedFile();
            try {
                PrintWriter output = new PrintWriter(outFile);
                output.printf("%-10s %8s %8s %8s %10s %10s\n", "Name", "Grade 1", "Grade 2", "Grade 3", "Average", "Status");
                for (int i = 0; i < students.size(); i++) {

                    output.printf("%-10s %8s %8s %8s %10s %10s\n", students.get(i).getName(), students.get(i).getGrade1(),
                            students.get(i).getGrade2(), students.get(i).getGrade3(), students.get(i).getAverage(),
                            students.get(i).getStatus());


                }
                output.close();

            } catch (FileNotFoundException e) {
                JOptionPane.showConfirmDialog(null, "Error in Opening the File", "Error", JOptionPane.OK_CANCEL_OPTION);
            }
        }
    }

    //used to split the String and return the section of the string requested.
    private String getData(String line, int Index){
        String[] separateParts = line.split("\\W+");

        return  separateParts[Index];
    }

    //Gets an Array List of Obejects and splits it down into single block lists.
    private ArrayList<Student> mergeSort(ArrayList<Student> temp) {
            //students.sort(Comparator.comparing(Student::getAverage).reversed()); --This is the K.I.S.S way, but you want it the hard way...
      //Creates the new 2 lists.
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
            //If the incoming list is not of 1 item size, recursively return it to be broken down
            list1 = mergeSort(list1);
            list2 = mergeSort(list2);
            //Calls the merge class to combine the single block items into a sorted ArrayList;
            merge(list1,list2,temp);
        }
        //returns the resulting sorted list.
        return temp;
    }
    //Gets 2 incoming ArrayList and merges them into a sorted Array list.
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


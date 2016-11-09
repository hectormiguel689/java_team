/*---------------------------------------------------
 Group Members:  Brian Delgado, Ileana Manzano, Hector Ramirez

 Student IDs: 1001324591,1001033660,1001095960

 COP 2805C – Java Programming 2

 Fall 2016 - T Th 6:00PM - 9:20PM

 Project # 1

 Plagiarism Statement: I certify that this assignment is my own work and that I have not copied in part or
 whole or otherwise plagiarized the work of other students and/or persons.

----------------------------------------------------------*/
public class TestStudents {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();

        studentList.readStudents();
        studentList.sortStudents();
        studentList.writeStudents();
    }
}
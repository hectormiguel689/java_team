/**
 * Created by brian on 10/30/16.
 */

public class TestStudents {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();

        studentList.readStudents();
        studentList.sortStudents();
        studentList.writeStudents();
    }
}
/**
 * Created by hector on 10/28/16.
 */
public class TestStudents {
       public static void main(String[] args) {
        StudentList studentList = new StudentList();

        studentList.readStudents();
        studentList.sortStudents();
        studentList.writeStudents();
    }
}

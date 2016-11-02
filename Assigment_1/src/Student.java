/**
 * Created by brian on 10/30/16.
 */
public class Student implements Comparable<Student> {
    private String name;
    private String status;
    private int grade1;
    private int grade2;
    private int grade3;
    private Double average;

    //4-arg Consutructor -Hector
    public Student(String name, int grade1, int grade2, int grade3) {
        this.name = name;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
        this.average = computeAverage(grade1, grade2, grade3);
        this.status = computeStatus(average);
    }

    //Getters and Setters for all Fields -Hector
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getGrade1() {
        return grade1;
    }

    public void setGrade1(int grade1) {
        this.grade1 = grade1;
    }

    public int getGrade2() {
        return grade2;
    }

    public void setGrade2(int grade2) {
        this.grade2 = grade2;
    }

    public int getGrade3() {
        return grade3;
    }

    public void setGrade3(int grade3) {
        this.grade3 = grade3;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    //Computes Avergae -Hector
    private double computeAverage(int grade1, int grade2, int grade3){
        return (grade1 + grade2 + grade3) / 3;
    }
    //Computes Averge -Hector
    private String computeStatus(double average){
        if(average < 70)
            return "Failing";
        else
            return "Passing";
    }
    //CompareTo Method  -Hector
    @Override
    public int compareTo(Student o) {
        return (this.average).compareTo(((Student)o).average);
    }
}
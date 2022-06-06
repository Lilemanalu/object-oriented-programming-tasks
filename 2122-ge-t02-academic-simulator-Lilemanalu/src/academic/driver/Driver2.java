package academic.driver;

import java.util.Scanner;
import java.util.Arrays;
import academic.model.Student;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */
public class Driver2 {
    static Student[] students = new Student[0];

    public static void main(String[] _args) {

        // codes
        Scanner sc = new Scanner(System.in);
        String data = "";
        Boolean loop = true;
        while (loop) {
            data = sc.nextLine();
            if (data.equals("---")) {
                break;
            }
            String separator = "#";
            String[] newData = data.split(separator);
            Student newStudent = arrayToStudent(newData);
            addStudent(newStudent);
        }
        printAllStudents();
        sc.close();
    }

    private static void printAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void addStudent(Student student) {
        students = Arrays.copyOf(students, students.length + 1);
        students[students.length - 1] = student;
    }

    private static Student arrayToStudent(String[] newData) {
        Student student = new Student(
                newData[0],
                newData[1],
                newData[2],
                newData[3]);
        return student;
    }
}
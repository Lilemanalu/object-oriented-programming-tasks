package academic.driver;
import java.util.Scanner;
import java.util.Arrays;
import academic.model.Student;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */

public class Driver1 {

    // codes
    static Student[] students = new Student[0];
    public static void main(String[] _args) {

        // codes
        Scanner sc = new Scanner(System.in);
        String data = "";
        Boolean loop = true;
        while (loop) {
            data = sc.nextLine();
            String separator = "#";
            String[] newData = data.split(separator);
            if (newData[0].equals("student-add")) {
                Integer studentCounter = 0;
                for (Student student : students) {
                    if (newData[1].equals(student.getStudentId())) {
                        studentCounter++;
                    }
                }
                if (studentCounter == 0) {
                    Student student = new Student(newData[1],
                            newData[2],
                            Float.parseFloat(newData[3]),
                            Integer.parseInt(newData[4]));
                    students = Arrays.copyOf(students, students.length + 1);
                    students[students.length - 1] = student;
                }
            } 
            
            if (data.equals("---")) {
                break;
            } else if (data.equals("student-show-all")) {
//            	Arrays.sort(students, (a, b) -> b.getStudentGPA().compareTo(a.getStudentGPA()));
//            	Arrays.sort(students, (a, b) -> a.getStudentId().compareTo(b.getStudentId()));
            	for (Student student : students) {
                    System.out.println(student);
                }
            } 
        }

 
        sc.close();
    }
}
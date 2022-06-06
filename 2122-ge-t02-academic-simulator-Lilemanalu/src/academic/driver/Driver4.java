package academic.driver;

import java.util.Scanner;
import java.util.Arrays;
import academic.model.Enrollment;
import academic.model.Student;
import academic.model.Course;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */
public class Driver4 {
    static Enrollment[] enrollments = new Enrollment[0];
    static Student[] students = new Student[0];
    static Course[] courses = new Course[0];

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
            if (newData[0].equals("enrollment-add")) {
                Enrollment newEnrollment = arrayToEnrollment(newData);
                addEnrollment(newEnrollment);
            } else if (newData[0].equals("course-add")) {
                Course newCourse = arrayToCourse(newData);
                addCourse(newCourse);
            } else {
                Student newStudent = arrayToStudent(newData);
                addStudent(newStudent);
            }
        }
        printAllCourses();
        printAllStudents();
        printAllEnrollments();
        sc.close();
    }

    // Enrollments
    private static void printAllEnrollments() {
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
    }

    private static void addEnrollment(Enrollment enrollment) {
        enrollments = Arrays.copyOf(enrollments, enrollments.length + 1);
        enrollments[enrollments.length - 1] = enrollment;
    }

    private static Enrollment arrayToEnrollment(String[] newData) {
        Enrollment student = new Enrollment(
                newData[1],
                newData[2],
                newData[3],
                newData[4],
                "None");
        return student;
    }

    // Courses
    private static void printAllCourses() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private static void addCourse(Course course) {
        courses = Arrays.copyOf(courses, courses.length + 1);
        courses[courses.length - 1] = course;
    }

    private static Course arrayToCourse(String[] newData) {
        Course course = new Course(
                newData[1],
                newData[2],
                Integer.parseInt(newData[3]),
                newData[4]);
        return course;
    }

    // Students
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
        Student enrollment = new Student(
                newData[1],
                newData[2],
                newData[3],
                newData[4]);
        return enrollment;
    }
}
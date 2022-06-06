package academic.driver;

import java.util.Scanner;
import java.util.Arrays;
import academic.model.Enrollment;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */
public class Driver3 {
    static Enrollment[] enrollments = new Enrollment[0];

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
            Enrollment newEnrollment = arrayToEnrollment(newData);
            addEnrollment(newEnrollment);
        }
        printAllEnrollments();
        sc.close();
    }

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
        Enrollment enrollment = new Enrollment(
                newData[0],
                newData[1],
                newData[2],
                newData[3],
                "None");
        return enrollment;
    }
}
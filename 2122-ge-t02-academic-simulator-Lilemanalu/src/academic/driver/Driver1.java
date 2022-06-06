package academic.driver;

import java.util.Arrays;
import java.util.Scanner;

import academic.model.Course;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */
public class Driver1 {
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
                Course newCourse = arrayToCourse(newData);
                addCourse(newCourse);
            }
            printAllCourses();
            sc.close();
        }

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
                    newData[0],
                    newData[1],
                    Integer.parseInt(newData[2]),
                    newData[3]);
            return course;
        }

}
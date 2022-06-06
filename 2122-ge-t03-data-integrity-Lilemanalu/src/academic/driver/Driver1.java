package academic.driver;
import java.util.Scanner;
import java.util.Arrays;
import academic.model.Enrollment;
import academic.model.Course;
import academic.model.Student;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */
public class Driver1 {
 	static Course[] courses = new Course[0];
 	static Student[] students = new Student[0];
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
	            if (newData[0].equals("enrollment-add")) {
	                Enrollment enrollment = new Enrollment(newData[1],
	                										newData[2],
	                										newData[3],
	                										newData[4]);
	                enrollments = Arrays.copyOf(enrollments, enrollments.length + 1);
	                enrollments[enrollments.length - 1] = enrollment;
//	                System.out.println(enrollment);
	            } else if (newData[0].equals("course-add")) {
	            	Integer counter = 0;
	            	for(Course course : courses) {
	            		if(newData[1].equals(getCourseCode(course))) {
	            			counter++;
	            		}
	            	}
	            	if(counter == 0) {
	            	Course course = new Course(newData[1],
							newData[2],
							Integer.parseInt(newData[3]),
							newData[4]);
	            	courses = Arrays.copyOf(courses, courses.length + 1);
	                courses[courses.length - 1] = course;
//	            	System.out.println(course);
	                }
	            } else if (newData[0].equals("student-add")) {
	            	Integer studentCounter = 0;
	            	for(Student student : students) {
	            		if(newData[1].equals(getStudentId(student))) {
	            			studentCounter++;
	            		}
	            	}
	            	if(studentCounter == 0) {
	            	Student student = new Student(newData[1],
							newData[2],
							newData[3],
							newData[4]);
	            	students = Arrays.copyOf(students, students.length + 1);
	                students[students.length - 1] = student;
	                }
//	            	System.out.println(student);
	            } else {
	                break;
	            }
	        }
	        for(Course course : courses) {
	        	System.out.println(course);
	        }
	        for(Student student : students) {
	        	System.out.println(student);
	        }
	        for(Enrollment enrollment : enrollments) {
	        	System.out.println(enrollment);
	        }
	        
	        sc.close();
} 
public static String getStudentId(Student student) {
	return student.studentId;
}
public static String getCourseCode(Course course) {
	return course.courseCode;
}
}

package academic.driver;

import java.util.Scanner;
import java.util.Arrays;
import academic.model.Enrollment;
import academic.model.Course;
import academic.model.Student;
import academic.model.Lecturer;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */

public class Driver1 {

    // codes
    static Course[] courses = new Course[0];
    static Student[] students = new Student[0];
    static Enrollment[] enrollments = new Enrollment[0];
    static Lecturer[] lecturers = new Lecturer[0];

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
            } else if (newData[0].equals("enrollment-grade")) {
                for (Enrollment enrollment : enrollments) {
                    if (newData[1].equals(enrollment.getEnrollmentCourseCode()) &&
                            newData[2].equals(enrollment.getEnrollmentStudentId())) {
                        enrollment.setGrade(newData[5]);
                    }
                }
            } else if (newData[0].equals("course-add")) {
                String lecturerseparator = ",";
                String theLecturer = null;
                String lecturerData[] = newData[5].split(lecturerseparator);
                for (int counterlecturer = 0; counterlecturer < lecturerData.length; counterlecturer++) {
                    // int x = 0;
                    for (Lecturer lecturer : lecturers) {
                        if (lecturerData[counterlecturer].equals(lecturer.getLecturerInitial())) {
                            if (theLecturer == null) {
                                if (counterlecturer != lecturerData.length - 1) {
                                    theLecturer = lecturerData[counterlecturer] + " " + lecturer.getLecturerEmail()
                                            + ";";
                                } else {
                                    theLecturer = lecturerData[counterlecturer] + " " + lecturer.getLecturerEmail();
                                }
                            } else {
                                if (counterlecturer != lecturerData.length - 1) {
                                    theLecturer = theLecturer + lecturerData[counterlecturer] + " "
                                            + lecturer.getLecturerEmail()
                                            + ";";
                                } else {
                                    theLecturer = theLecturer + lecturerData[counterlecturer] + " "
                                            + lecturer.getLecturerEmail();
                                }
                            }
                        }
                    }
                }
                
                Integer counter = 0;
                for (Course course : courses) {
                    if (newData[1].equals(course.getCourseCode())) {
                        counter++;
                    }
                }
                if (counter == 0) {
                    Course course = new Course(newData[1],
                            newData[2],
                            Integer.parseInt(newData[3]),
                            newData[4],
                            theLecturer);
                    courses = Arrays.copyOf(courses, courses.length + 1);
                    courses[courses.length - 1] = course;
                }
            } else if (newData[0].equals("student-add")) {
                Integer studentCounter = 0;
                for (Student student : students) {
                    if (newData[1].equals(student.getStudentId())) {
                        studentCounter++;
                    }
                }
                if (studentCounter == 0) {
                    Student student = new Student(newData[1],
                            newData[2],
                            newData[3],
                            newData[4]);
                    students = Arrays.copyOf(students, students.length + 1);
                    students[students.length - 1] = student;
                }
            } else if (newData[0].equals("lecturer-add")) {
                Integer lecturerCounter = 0;
                for (Lecturer lecturer : lecturers) {
                    if (newData[1].equals(lecturer.getLecturerId())) {
                        lecturerCounter++;
                    }
                }
                if (lecturerCounter == 0) {
                    Lecturer lecturer = new Lecturer(newData[1],
                            newData[2],
                            newData[3],
                            newData[4],
                            newData[5]);
                    lecturers = Arrays.copyOf(lecturers, lecturers.length + 1);
                    lecturers[lecturers.length - 1] = lecturer;
                }
            } else {
                break;
            }
        }

        for (Lecturer lecturer : lecturers) {
            System.out.println(lecturer);
        }
        for (Course course : courses) {
            System.out.println(course);
        }
        for (Student student : students) {
            System.out.println(student);
        }
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }


        sc.close();
    }
}


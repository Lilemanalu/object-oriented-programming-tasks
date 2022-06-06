package academic.driver;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Arrays;
import academic.model.Enrollment;
import academic.model.Course;
import academic.model.Student;
import academic.model.Lecturer;
import academic.model.StudentDetail;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */

public class Driver2 {
    static Course[] courses = new Course[0];
    static Student[] students = new Student[0];
    static Enrollment[] enrollments = new Enrollment[0];
    static Lecturer[] lecturers = new Lecturer[0];
    static StudentDetail[] details = new StudentDetail[0];

    public static void main(String[] _args) {

        // codes
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
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

            // enrollment add
            if (newData[0].equals("enrollment-add")) {

                Enrollment enrollment = new Enrollment(newData[1],
                        newData[2],
                        newData[3],
                        newData[4]);
                enrollments = Arrays.copyOf(enrollments, enrollments.length + 1);
                enrollments[enrollments.length - 1] = enrollment;
                // System.out.println(enrollment);
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
                    // System.out.println(course);
                }
            }

            // Student add
            else if (newData[0].equals("student-add")) {
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
            }

            // lecturer add
            else if (newData[0].equals("lecturer-add")) {
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
            }

            // enrollment grade
            else if (newData[0].equals("enrollment-grade")) {
                for (Enrollment enrollment : enrollments) {
                    if (newData[1].equals(enrollment.getEnrollmentCourseCode()) &&
                            newData[2].equals(enrollment.getEnrollmentStudentId())) {
                        if (newData[3].equals(enrollment.getAcademicYear())) {
                            enrollment.setGrade(newData[5]);
                        }
                    }
                }

            }

            // student details
            else if (newData[0].equals("student-details")) {
                Integer detCredit = 0;
                Integer totalCredit = 0;
                Integer thetotalcredit = 0;
                String theGrade;
                Float detGps = 0.00f;
                Float totalGps = 0.00f;
                Float totalGpa;
                for (Student student : students) {
                    if (newData[1].equals(student.getStudentId())) {
                        for (Enrollment enrollment : enrollments) {
                            if (enrollment.getEnrollmentStudentId().equals(student.getStudentId())) {
                                for (Course course : courses) {
                                    if (enrollment.getEnrollmentCourseCode().equals(course.getCourseCode())) {
                                        String theCode = enrollment.getEnrollmentCourseCode();
                                        String theId = enrollment.getEnrollmentStudentId();
                                        String theAcademicYear = enrollment.getAcademicYear();
                                        String[] theYear = theAcademicYear.split("/");
                                        int y = 0;
                                        for (int x = 0; x < enrollments.length; x++) {
                                            if (enrollments[x].getEnrollmentCourseCode().equals(theCode) &&
                                                    enrollments[x].getEnrollmentStudentId().equals((theId))) {
                                                String theAcademicYear2 = enrollments[x].getAcademicYear();
                                                String[] theYear2 = theAcademicYear2.split("/");
                                                if (Integer.parseInt(theYear[0]) < Integer.parseInt(theYear2[0])) {
                                                    detCredit = 0;
                                                    detGps = 0.00f;
                                                } else {
                                                    theGrade = enrollment.getGrade();
                                                    detCredit = course.getCredits();
                                                    detGps = getFLoatGrade(theGrade) * detCredit;
                                                }

                                            } else {
                                                y++;
                                                if (y == enrollments.length - 1) {
                                                    if (enrollment.getGrade().equals("None")) {
                                                        detCredit = 0;
                                                        detGps = 0.00f;

                                                    } else {
                                                        theGrade = enrollment.getGrade();
                                                        detCredit = course.getCredits();
                                                        detGps = getFLoatGrade(theGrade) * detCredit;
                                                    }
                                                }
                                            }
                                        }

                                        totalCredit = totalCredit + detCredit;
                                        totalGps = totalGps + detGps;
                                        thetotalcredit = thetotalcredit + totalCredit;

                                    }
                                }
                            }
                        }
                        if (totalCredit == 0 && totalGps == 0.00f) {
                            StudentDetail detail = new StudentDetail(student.studentId, student.studentName,
                                    student.year,
                                    student.studyProgram, totalGps, totalCredit);
                            details = Arrays.copyOf(details, details.length + 1);
                            details[details.length - 1] = detail;
                        } else {
                            totalGpa = totalGps / totalCredit;
                            // theGpa = df.format(totalGpa);
                            StudentDetail detail = new StudentDetail(student.studentId, student.studentName,
                                    student.year,
                                    student.studyProgram, totalGpa, totalCredit);
                            details = Arrays.copyOf(details, details.length + 1);
                            details[details.length - 1] = detail;
                        }
                    }
                }
            } else {
                break;
            }
        }

        for (StudentDetail detail : details) {
            System.out.println(detail);
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

    static Float getFLoatGrade(String _grades) {
        Float floatGrade;
        if (_grades.equals("A")) {
            floatGrade = 4.00f;
        } else if (_grades.equals("AB")) {
            floatGrade = 3.50f;
        } else if (_grades.equals("B")) {
            floatGrade = 3.00f;
        } else if (_grades.equals("BC")) {
            floatGrade = 2.50f;
        } else if (_grades.equals("C")) {
            floatGrade = 2.00f;
        } else if (_grades.equals("D")) {
            floatGrade = 1.00f;
        } else {
            floatGrade = 0.00f;
        }
        return floatGrade;
    }
}
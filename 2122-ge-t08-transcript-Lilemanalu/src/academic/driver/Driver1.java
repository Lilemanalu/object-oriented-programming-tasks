package academic.driver;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Arrays;
import academic.model.*;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */

public class Driver1 {
    static Course[] courses = new Course[0];
    static Student[] students = new Student[0];
    static Enrollment[] enrollments = new Enrollment[0];
    static Lecturer[] lecturers = new Lecturer[0];
    static StudentDetail[] details = new StudentDetail[0];
    static Remedial[] remedials = new Remedial[0];
    static CourseOpening[] courseOpenings = new CourseOpening[0];
    static Course.CourseHistory[] courseHistories = new Course.CourseHistory[0];
    static StudentTranscript[] studentTranscripts = new StudentTranscript[0];
    static StudentTranscript.Transcript[] transcripts = new StudentTranscript.Transcript[0];

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
                Integer enrollmentCounter = 0;
                for (Enrollment enrollment : enrollments) {
                    if (newData[1].equals(enrollment.getEnrollmentCourseCode()) &&
                            newData[2].equals(enrollment.getEnrollmentStudentId()) &&
                            newData[3].equals(enrollment.getAcademicYear()) &&
                            newData[4].equals(enrollment.getGrade())) {
                        enrollmentCounter++;
                    }
                }
                if (enrollmentCounter == 0) {
                    String theGrade = "None";

                    Enrollment enrollment = new Enrollment(newData[1],
                            newData[2],
                            newData[3],
                            newData[4],
                            theGrade);
                    enrollments = Arrays.copyOf(enrollments, enrollments.length + 1);
                    enrollments[enrollments.length - 1] = enrollment;
                }

            }

            // student-transcripst
            else if (newData[0].equals("student-transcript")) {
                StudentTranscript.Transcript transcript = new StudentTranscript(separator, separator, separator, separator, null, null).new Transcript(newData[1]);
                transcripts = Arrays.copyOf(transcripts, transcripts.length + 1);
                transcripts[transcripts.length - 1] = transcript;

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
                            StudentTranscript studentTranscript = new StudentTranscript(student.studentId,
                                    student.studentName,
                                    student.year,
                                    student.studyProgram, totalGps, totalCredit);
                            studentTranscripts = Arrays.copyOf(studentTranscripts, studentTranscripts.length + 1);
                            studentTranscripts[studentTranscripts.length - 1] = studentTranscript;
                        } else {
                            totalGpa = totalGps / totalCredit;
                            // theGpa = df.format(totalGpa);
                            StudentTranscript studentTranscript = new StudentTranscript(student.studentId,
                                    student.studentName,
                                    student.year,
                                    student.studyProgram, totalGpa, totalCredit);
                            studentTranscripts = Arrays.copyOf(studentTranscripts, studentTranscripts.length + 1);
                            studentTranscripts[studentTranscripts.length - 1] = studentTranscript;
                        }
                    }
                }
            }

            // course-opening
            else if (newData[0].equals("course-open")) {
                String lecturerseparator = ",";
                String theLecturer = null;
                String lecturerData[] = newData[4].split(lecturerseparator);
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
                for (CourseOpening courseOpening : courseOpenings) {
                    if (newData[1].equals(courseOpening.getCourseOpeningCode())) {
                        counter++;
                    }
                }
                if (counter == 0) {
                    for (Course course : courses) {
                        if (newData[1].equals(course.getCourseCode())) {
                            CourseOpening courseOpening = new CourseOpening(newData[1],
                                    course.getCourseName(),
                                    course.getCredits(),
                                    course.getPassingGrade(),
                                    newData[2],
                                    newData[3],
                                    theLecturer);
                            courseOpenings = Arrays.copyOf(courseOpenings, courseOpenings.length + 1);
                            courseOpenings[courseOpenings.length - 1] = courseOpening;
                        }
                    }

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
                        if (newData[3].equals(enrollment.getAcademicYear()) &&
                                newData[4].equals(enrollment.getSemester())) {
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
            }
            // Remedial
            else if (newData[0].equals("enrollment-remedial")) {
                Integer remedialCounter = 0;
                for (Remedial remedial : remedials) {
                    if (remedial.getEnrollmentCourseCode().equals(newData[1]) &&
                            remedial.getEnrollmentStudentId().equals(newData[2]) &&
                            remedial.getAcademicYear().equals(newData[3])) {
                        remedialCounter = remedialCounter + 1;
                    }
                }
                if (remedialCounter == 0) {
                    for (Enrollment enrollment : enrollments) {
                        if (enrollment.getEnrollmentCourseCode().equals(newData[1]) &&
                                enrollment.getEnrollmentStudentId().equals(newData[2]) &&
                                enrollment.getAcademicYear().equals(newData[3]) &&
                                enrollment.getSemester().equals(newData[4])) {
                            if (!enrollment.getGrade().equals("None")) {
                                String theGrade = enrollment.getGrade();
                                Remedial remedial = new Remedial(newData[1], newData[2], newData[3], newData[4],
                                        theGrade, newData[5]);
                                remedials = Arrays.copyOf(remedials, remedials.length + 1);
                                remedials[remedials.length - 1] = remedial;
                                enrollment.setGrade(newData[5]);
                            }

                        }

                    }
                }
            }

            // course-add
            else if (newData[0].equals("course-add")) {
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
                            newData[4]);
                    courses = Arrays.copyOf(courses, courses.length + 1);
                    courses[courses.length - 1] = course;
                    // System.out.println(course);
                }

            }
            // course-history
            else if (newData[0].equals("course-history")) {
                Course.CourseHistory courseHistory = new Course(separator, separator, 0,
                        separator).new CourseHistory(newData[1]);
                courseHistories = Arrays.copyOf(courseHistories, courseHistories.length + 1);
                courseHistories[courseHistories.length - 1] = courseHistory;
            }

            else {
                break;
            }
        }

        // print course history odd
        for (Course.CourseHistory courseHistory : courseHistories) {
            for (CourseOpening courseOpening : courseOpenings) {
                if (courseHistory.getHistoryCourseCode().equals(courseOpening.getCourseCode())) {
                    if (courseOpening.getSemester().equals("odd")) {
                        System.out.println(courseOpening);
                        for (Enrollment enrollment : enrollments) {
                            if (enrollment.getEnrollmentCourseCode().equals(courseOpening.getCourseCode()) &&
                                    enrollment.getAcademicYear().equals(courseOpening.getAcademicYear()) &&
                                    enrollment.getSemester().equals(courseOpening.getSemester())) {
                                Integer counterPrinter = 0;
                                for (Remedial remedial : remedials) {
                                    if (remedial.getEnrollmentCourseCode().equals(enrollment.getEnrollmentCourseCode())
                                            &&
                                            remedial.getEnrollmentStudentId()
                                                    .equals(enrollment.getEnrollmentStudentId())
                                            &&
                                            remedial.getAcademicYear().equals(enrollment.getAcademicYear()) &&
                                            remedial.getSemester().equals(enrollment.getSemester())) {
                                        counterPrinter = counterPrinter + 1;
                                    }
                                }
                                if (counterPrinter == 0) {
                                    System.out.println(enrollment);
                                } else if (counterPrinter != 0) {
                                    for (Remedial remedial : remedials) {
                                        if (remedial.getEnrollmentCourseCode()
                                                .equals(enrollment.getEnrollmentCourseCode())
                                                &&
                                                remedial.getEnrollmentStudentId()
                                                        .equals(enrollment.getEnrollmentStudentId())
                                                &&
                                                remedial.getAcademicYear().equals(enrollment.getAcademicYear())) {
                                            System.out.println(remedial);
                                        }
                                    }
                                }
                                // System.out.println(enrollment);
                            }
                        }
                    }
                }

            }

        }

        // print course history even
        for (Course.CourseHistory courseHistory : courseHistories) {
            for (CourseOpening courseOpening : courseOpenings) {
                if (courseHistory.getHistoryCourseCode().equals(courseOpening.getCourseCode())) {
                    if (courseOpening.getSemester().equals("even")) {
                        System.out.println(courseOpening);
                        for (Enrollment enrollment : enrollments) {
                            if (enrollment.getEnrollmentCourseCode().equals(courseOpening.getCourseCode()) &&
                                    enrollment.getAcademicYear().equals(courseOpening.getAcademicYear()) &&
                                    enrollment.getSemester().equals(courseOpening.getSemester())) {
                                Integer counterPrinter = 0;
                                for (Remedial remedial : remedials) {
                                    if (remedial.getEnrollmentCourseCode().equals(enrollment.getEnrollmentCourseCode())
                                            &&
                                            remedial.getEnrollmentStudentId()
                                                    .equals(enrollment.getEnrollmentStudentId())
                                            &&
                                            remedial.getAcademicYear().equals(enrollment.getAcademicYear()) &&
                                            remedial.getSemester().equals(enrollment.getSemester())) {
                                        counterPrinter = counterPrinter + 1;
                                    }
                                }
                                if (counterPrinter == 0) {
                                    System.out.println(enrollment);
                                } else if (counterPrinter != 0) {
                                    for (Remedial remedial : remedials) {
                                        if (remedial.getEnrollmentCourseCode()
                                                .equals(enrollment.getEnrollmentCourseCode())
                                                &&
                                                remedial.getEnrollmentStudentId()
                                                        .equals(enrollment.getEnrollmentStudentId())
                                                &&
                                                remedial.getAcademicYear().equals(enrollment.getAcademicYear())) {
                                            System.out.println(remedial);
                                        }
                                    }
                                }
                                // System.out.println(enrollment);
                            }
                        }
                    }
                }

            }

        }
        for (StudentDetail detail : details) {
            System.out.println(detail);
        }
        for (StudentTranscript studentTranscript : studentTranscripts) {
            System.out.println(studentTranscript);
            for (StudentTranscript.Transcript transcript : transcripts) {
                for (Enrollment enrollment : enrollments) {
                    if (transcript.getTranscriptId().equals(enrollment.getEnrollmentStudentId())) {
                        if (enrollment.getEnrollmentStudentId().equals(transcript.getTranscriptId())) {
                            if (enrollment.getSemester().equals("odd")) {
                                Integer counterPrinter = 0;
                                for (Remedial remedial : remedials) {
                                    if (remedial.getEnrollmentCourseCode().equals(enrollment.getEnrollmentCourseCode())
                                            &&
                                            remedial.getEnrollmentStudentId()
                                                    .equals(enrollment.getEnrollmentStudentId())
                                            &&
                                            remedial.getAcademicYear().equals(enrollment.getAcademicYear())) {
                                        counterPrinter = counterPrinter + 1;
                                    }
                                }
                                if (counterPrinter == 0) {
                                    Integer yearCounter = 0;
                                    for (int x = 0; x < enrollments.length; x++) {
                                        if (enrollments[x].enrollmentCourseCode
                                                .equals(enrollment.getEnrollmentCourseCode())) {

                                            String syear1 = enrollments[x].academicYear;
                                            String[] theyear1 = syear1.split("/");
                                            String syear2 = enrollment.getAcademicYear();
                                            String[] theyear2 = syear2.split("/");
                                            Integer year1 = Integer.parseInt(theyear1[0]);
                                            Integer year2 = Integer.parseInt(theyear2[0]);
                                            ;
                                            if (year1 > year2) {
                                                yearCounter++;
                                            }
                                        }
                                    }

                                    for (int x = 0; x < remedials.length; x++) {
                                        if (remedials[x].enrollmentCourseCode
                                                .equals(enrollment.getEnrollmentCourseCode())) {

                                            String syear1 = remedials[x].academicYear;
                                            String[] theyear1 = syear1.split("/");
                                            String syear2 = enrollment.getAcademicYear();
                                            String[] theyear2 = syear2.split("/");
                                            Integer year1 = Integer.parseInt(theyear1[0]);
                                            Integer year2 = Integer.parseInt(theyear2[0]);
                                            ;
                                            if (year1 > year2) {
                                                yearCounter++;
                                            }
                                        }
                                    }
                                    if (yearCounter == 0) {
                                        System.out.println(enrollment);
                                    }

                                } else if (counterPrinter != 0) {
                                    for (Remedial remedial : remedials) {
                                        if (remedial.getEnrollmentCourseCode()
                                                .equals(enrollment.getEnrollmentCourseCode())
                                                &&
                                                remedial.getEnrollmentStudentId()
                                                        .equals(enrollment.getEnrollmentStudentId())
                                                &&
                                                remedial.getAcademicYear().equals(enrollment.getAcademicYear())) {
                                            if (remedial.getSemester().equals("odd")) {
                                                Integer yearCounter = 0;
                                                for (int x = 0; x < enrollments.length; x++) {
                                                    if (enrollments[x].enrollmentCourseCode
                                                            .equals(enrollment.getEnrollmentCourseCode())) {

                                                        String syear1 = enrollments[x].academicYear;
                                                        String[] theyear1 = syear1.split("/");
                                                        String syear2 = enrollment.getAcademicYear();
                                                        String[] theyear2 = syear2.split("/");
                                                        Integer year1 = Integer.parseInt(theyear1[0]);
                                                        Integer year2 = Integer.parseInt(theyear2[0]);
                                                        ;
                                                        if (year1 > year2) {
                                                            yearCounter++;
                                                        }
                                                    }
                                                }

                                                for (int x = 0; x < remedials.length; x++) {
                                                    if (remedials[x].enrollmentCourseCode
                                                            .equals(enrollment.getEnrollmentCourseCode())) {

                                                        String syear1 = remedials[x].academicYear;
                                                        String[] theyear1 = syear1.split("/");
                                                        String syear2 = enrollment.getAcademicYear();
                                                        String[] theyear2 = syear2.split("/");
                                                        Integer year1 = Integer.parseInt(theyear1[0]);
                                                        Integer year2 = Integer.parseInt(theyear2[0]);
                                                        ;
                                                        if (year1 > year2) {
                                                            yearCounter++;
                                                        }
                                                    }
                                                }
                                                if (yearCounter == 0) {
                                                    System.out.println(remedial);
                                                }
                                                // System.out.println(remedial);
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // even
            for (StudentTranscript.Transcript transcript : transcripts) {
                for (Enrollment enrollment : enrollments) {
                    if (transcript.getTranscriptId().equals(enrollment.getEnrollmentStudentId())) {
                        if (enrollment.getEnrollmentStudentId().equals(transcript.getTranscriptId())) {
                            if (enrollment.getSemester().equals("even")) {
                                Integer counterPrinter = 0;
                                for (Remedial remedial : remedials) {
                                    if (remedial.getEnrollmentCourseCode().equals(enrollment.getEnrollmentCourseCode())
                                            &&
                                            remedial.getEnrollmentStudentId()
                                                    .equals(enrollment.getEnrollmentStudentId())
                                            &&
                                            remedial.getAcademicYear().equals(enrollment.getAcademicYear())) {
                                        counterPrinter = counterPrinter + 1;
                                    }
                                }
                                if (counterPrinter == 0) {
                                    Integer yearCounter = 0;
                                    for (int x = 0; x < enrollments.length; x++) {
                                        if (enrollments[x].enrollmentCourseCode
                                                .equals(enrollment.getEnrollmentCourseCode())) {

                                            String syear1 = enrollments[x].academicYear;
                                            String[] theyear1 = syear1.split("/");
                                            String syear2 = enrollment.getAcademicYear();
                                            String[] theyear2 = syear2.split("/");
                                            Integer year1 = Integer.parseInt(theyear1[0]);
                                            Integer year2 = Integer.parseInt(theyear2[0]);
                                            ;
                                            if (year1 > year2) {
                                                yearCounter++;
                                            }
                                        }
                                    }

                                    for (int x = 0; x < remedials.length; x++) {
                                        if (remedials[x].enrollmentCourseCode
                                                .equals(enrollment.getEnrollmentCourseCode())) {

                                            String syear1 = remedials[x].academicYear;
                                            String[] theyear1 = syear1.split("/");
                                            String syear2 = enrollment.getAcademicYear();
                                            String[] theyear2 = syear2.split("/");
                                            Integer year1 = Integer.parseInt(theyear1[0]);
                                            Integer year2 = Integer.parseInt(theyear2[0]);
                                            ;
                                            if (year1 > year2) {
                                                yearCounter++;
                                            }
                                        }
                                    }
                                    if (yearCounter == 0) {
                                        System.out.println(enrollment);
                                    }

                                } else if (counterPrinter != 0) {
                                    for (Remedial remedial : remedials) {
                                        if (remedial.getEnrollmentCourseCode()
                                                .equals(enrollment.getEnrollmentCourseCode())
                                                &&
                                                remedial.getEnrollmentStudentId()
                                                        .equals(enrollment.getEnrollmentStudentId())
                                                &&
                                                remedial.getAcademicYear().equals(enrollment.getAcademicYear())) {
                                            if (remedial.getSemester().equals("even")) {
                                                Integer yearCounter = 0;
                                                for (int x = 0; x < enrollments.length; x++) {
                                                    if (enrollments[x].enrollmentCourseCode
                                                            .equals(enrollment.getEnrollmentCourseCode())) {

                                                        String syear1 = enrollments[x].academicYear;
                                                        String[] theyear1 = syear1.split("/");
                                                        String syear2 = enrollment.getAcademicYear();
                                                        String[] theyear2 = syear2.split("/");
                                                        Integer year1 = Integer.parseInt(theyear1[0]);
                                                        Integer year2 = Integer.parseInt(theyear2[0]);
                                                        ;
                                                        if (year1 > year2) {
                                                            yearCounter++;
                                                        }
                                                    }
                                                }

                                                for (int x = 0; x < remedials.length; x++) {
                                                    if (remedials[x].enrollmentCourseCode
                                                            .equals(enrollment.getEnrollmentCourseCode())) {

                                                        String syear1 = remedials[x].academicYear;
                                                        String[] theyear1 = syear1.split("/");
                                                        String syear2 = enrollment.getAcademicYear();
                                                        String[] theyear2 = syear2.split("/");
                                                        Integer year1 = Integer.parseInt(theyear1[0]);
                                                        Integer year2 = Integer.parseInt(theyear2[0]);
                                                        ;
                                                        if (year1 > year2) {
                                                            yearCounter++;
                                                        }
                                                    }
                                                }
                                                if (yearCounter == 0) {
                                                    System.out.println(remedial);
                                                }
                                                // System.out.println(remedial);
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
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
            if (enrollment.getSemester().equals("odd")) {
                Integer counterPrinter = 0;
                for (Remedial remedial : remedials) {
                    if (remedial.getEnrollmentCourseCode().equals(enrollment.getEnrollmentCourseCode()) &&
                            remedial.getEnrollmentStudentId().equals(enrollment.getEnrollmentStudentId()) &&
                            remedial.getAcademicYear().equals(enrollment.getAcademicYear()) &&
                            remedial.getSemester().equals(enrollment.getSemester())) {
                        counterPrinter = counterPrinter + 1;
                    }
                }
                if (counterPrinter == 0) {
                    System.out.println(enrollment);
                } else if (counterPrinter != 0) {
                    for (Remedial remedial : remedials) {
                        if (remedial.getEnrollmentCourseCode().equals(enrollment.getEnrollmentCourseCode()) &&
                                remedial.getEnrollmentStudentId().equals(enrollment.getEnrollmentStudentId()) &&
                                remedial.getAcademicYear().equals(enrollment.getAcademicYear())) {
                            if (remedial.getSemester().equals("odd")) {
                                System.out.println(remedial);
                            }

                        }
                    }
                }
            }
        }

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getSemester().equals("even")) {
                Integer counterPrinter = 0;
                for (Remedial remedial : remedials) {
                    if (remedial.getEnrollmentCourseCode().equals(enrollment.getEnrollmentCourseCode()) &&
                            remedial.getEnrollmentStudentId().equals(enrollment.getEnrollmentStudentId()) &&
                            remedial.getAcademicYear().equals(enrollment.getAcademicYear())) {
                        counterPrinter = counterPrinter + 1;
                    }
                }
                if (counterPrinter == 0) {
                    System.out.println(enrollment);
                } else if (counterPrinter != 0) {
                    for (Remedial remedial : remedials) {
                        if (remedial.getEnrollmentCourseCode().equals(enrollment.getEnrollmentCourseCode()) &&
                                remedial.getEnrollmentStudentId().equals(enrollment.getEnrollmentStudentId()) &&
                                remedial.getAcademicYear().equals(enrollment.getAcademicYear())) {
                            if (remedial.getSemester().equals("even")) {
                                System.out.println(remedial);
                            }

                        }
                    }
                }
            }
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

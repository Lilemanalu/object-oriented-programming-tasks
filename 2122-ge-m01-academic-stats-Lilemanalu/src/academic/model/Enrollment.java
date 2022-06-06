package academic.model;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */

public class Enrollment {

    // class definition
    private String enrollmentCourseCode;
    private String enrollmentStudentId;
    private String academicYear;
    private String semester;
    private String grade;

    public Enrollment(String courseCode, String studentId, String academicYear, String semester) {
        this.enrollmentCourseCode = courseCode;
        this.enrollmentStudentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None";
    }

    public String getEnrollmentCourseCode() {
        return enrollmentCourseCode;
    }

    public void setEnrollmentCourseCode(String enrollmentCourseCode) {
        this.enrollmentCourseCode = enrollmentCourseCode;
    }

    public String getEnrollmentStudentId() {
        return enrollmentStudentId;
    }

    public void setEnrollmentStudentId(String enrollmentStudentId) {
        this.enrollmentStudentId = enrollmentStudentId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String toString() {
        return enrollmentCourseCode + "|" + enrollmentStudentId + "|" + academicYear + "|" + semester + "|" + grade;
    }

}
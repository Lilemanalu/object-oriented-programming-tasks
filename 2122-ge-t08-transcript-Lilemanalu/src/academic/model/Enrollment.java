package academic.model;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */

public class Enrollment {

    // class definition
    public String enrollmentCourseCode;
    public String enrollmentStudentId;
    public String academicYear;
    public String semester;
    public String grade;

    public Enrollment(String courseCode, String studentId, String academicYear, String semester, String grade) {
        this.enrollmentCourseCode = courseCode;
        this.enrollmentStudentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = grade;
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

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String toString() {
        return enrollmentCourseCode + "|" + enrollmentStudentId + "|" + academicYear + "|" + semester + "|" + grade;
    }

}
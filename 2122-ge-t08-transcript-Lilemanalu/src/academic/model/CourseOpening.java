package academic.model;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */

public class CourseOpening extends Course {

    // class definition
    String courseOpeningCode;
    String academicYear;
    String semester;
    String lecturer;

    public CourseOpening(String courseCode, String courseName, Integer credits,
            String passingGrade, String academicYear, String semester, String lecturer) {
        super(courseCode, courseName, credits, passingGrade);
        this.academicYear = academicYear;
        this.semester = semester;
        this.lecturer = lecturer;
    }

    public String getCourseOpeningCode() {
        return courseOpeningCode;
    }

    public void setCourseOpeningCode(String courseOpeningCode) {
        this.courseOpeningCode = courseOpeningCode;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public String toString() {
        return super.courseCode + "|" + super.courseName + "|"
                + super.credits + "|" + super.passingGrade + "|" + this.academicYear + "|" + this.semester + "|"
                + this.lecturer;
    }

}
package academic.model;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */

public class Course {

    // class definition
    String courseCode;
    String courseName;
    Integer credits;
    String passingGrade;

    public Course(String courseCode, String courseName, Integer credits, String passingGrade) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.passingGrade = passingGrade;
    }

    public class CourseHistory {
        public String historyCOurseCode;

        public CourseHistory(String historyCOurseCode) {
            this.historyCOurseCode = historyCOurseCode;
        }

        public String getHistoryCourseCode() {
            return historyCOurseCode;
        }

        public void setHistoryCourseCode(String historyCOurseCode) {
            this.historyCOurseCode = historyCOurseCode;
        }

    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getPassingGrade() {
        return passingGrade;
    }

    public void setPassingGrade(String passingGrade) {
        this.passingGrade = passingGrade;
    }

    @Override
    public String toString() {
        return this.courseCode + "|" + this.courseName + "|" + this.credits + "|" + this.passingGrade;
    }

}
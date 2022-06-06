package academic.model;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */

public class Course {

    // class definition
    // Making the object's attributes
    private String courseCode;
    private String courseName;
    private Integer credits;
    private String passingGrade;
    private String theLecturer;

    // Making the constructor
    public Course(String courseCode, String courseName, 
    		Integer credits, String passingGrade, String thelecturer) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.passingGrade = passingGrade;
        this.theLecturer = thelecturer;
    }

    // Making some mutator
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseData() {
        return courseCode + courseName + credits + passingGrade + theLecturer;
    }

    // an toString that will give the string output
    public String toString() {
        return this.courseCode + "|" + this.courseName + "|"
                + this.credits + "|" + this.passingGrade + "|" + theLecturer;
    }

}
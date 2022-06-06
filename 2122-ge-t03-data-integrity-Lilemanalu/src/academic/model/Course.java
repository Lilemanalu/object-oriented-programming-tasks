package academic.model;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */
public class Course {
	Course[] courses = new Course[0];
	public String courseCode;
	private String courseName;
	private Integer credits;
	private String passingGrade;
	
	public Course(String courseCode, String courseName, Integer credits, String passingGrade) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.credits = credits;
		this.passingGrade = passingGrade;
	}
   
    public String getCourseCode(Course course) {
    	return course.courseCode;
    }
    
    public String toString() {
        return this.courseCode + "|" + this.courseName + "|"
                + this.credits + "|" + this.passingGrade;
    }

}
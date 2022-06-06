package academic.model;

//import academic.model.Student;
//import academic.model.Course;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */
public class Enrollment {
	private String courseCode;
	private String studentId;
	private String academicYear;
	private String semester;
	private String grade;
	
	public Enrollment(String courseCode, String studentId, String academicYear, String semester) {
		this.courseCode = courseCode;
		this.studentId = studentId;
		this.academicYear = academicYear;
		this.semester = semester;
		this.grade = "none";
	}
   

//	public String getCourseCode(courseCode) {
//		return courseCode;
//	}


	public String toString() {
        return courseCode + "|" + studentId + "|" + academicYear + "|" + semester + "|" + grade;
    }

}
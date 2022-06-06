package academic.model;

/**
 * @author 12S20017 Lile Asima Manalu
 */
public class Enrollment {

    // class definition
	private String code;
	private String id;
	private String academicYear;
	private String semester;
	private String grade;
	
	//define the default constructor - accept no parameter
	public Enrollment() {
		this.code = "";
		this.id = "";
		this.academicYear = "";
		this.semester = "";
		this.grade = "";
	}
	
	//define another object constructor(custom) - with parameters
	public Enrollment(String code, String id, 
			String academicYear, String semester, String grade) {
		this.code = code;
		this.id = id;
		this.academicYear = academicYear;
		this.semester = semester;
		this.grade = grade;
		
	}
	
	//accessor method to retrieve the value of an instance's attribute
	public String getCode() {
		return code;
	}
	
	//mutator method to offer a modification value to an attribute of an object/instance
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	/*
	 * The toString() method is invoked/called to
	 * generate a string that represents the object
	 */
	public String toString() {
		return this.code + "|" + this.id + "|"
				+ this.academicYear + "|" + this.semester + "|" + this.grade;
	}
	
}
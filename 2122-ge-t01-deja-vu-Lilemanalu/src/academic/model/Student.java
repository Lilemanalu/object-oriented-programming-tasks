package academic.model;

/**
 * @author 12S20017 Lile Asima Manalu
 */
public class Student {

    // class definition
	private String id;
	private String name;
	private String year;
	private String studyProgram;
	
	//define the default constructor - accept no parameter
	public Student() {
		this.id= "";
		this.name = "";
		this.year = "";
		this.studyProgram = "";
	}
	
	//accessor method to retrieve the value of an instance's attribute
	public String getId() {
		return id;
	}
	
	//mutator method to offer a modification value to an attribute of an object/instance
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getStudyProgram() {
		return studyProgram;
	}
	
	public void setStudyProgram(String studyProgram) {
		this.studyProgram = studyProgram;
	}
	
	/*
	 * The toString() method is invoked/called to
	 * generate a string that represents the object
	 */
	public String toString() {
		return this.id + "|" + this.name + "|"
				+ this.year + "|" + this.studyProgram;
	}
}
package academic.model;

/**
 * @author 12S20017 Lile Asima Manalu
 */
public class Course {

    // class definition
	private String code;
	private String name;
	private Integer credit;
	private String passingGrade;
	
	//define the default constructor - no parameter
	public Course() {
		this.code = "";
		this.name = "";
		this.credit = 0;
		this.passingGrade = "";
	}
	
	//define another object constructor(custom) - with parameters
	public Course(String code, String name, 
			Integer credit, String passingGrade) {
		this.code = code;
		this.name = name;
		this.credit = credit;
		this.passingGrade = passingGrade;
	}
	
	//accessor method to retrieve the value of an instance's attribute
	public String getCode() {
		return code;
	}
	
	//mutator method to offer a modification value to an attribute of an object/instance
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getCredit() {
		return credit;
	}
	
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	
	public String getPassingGrade() {
		return passingGrade;
	}
	
	public void setPassingGrade(String passingGrade) {
		this.passingGrade = passingGrade;
	}
	
	/*
	 * The toString() method is invoked/called to
	 * generate a string that represents the object
	 */
	public String toString() {
		return this.code + "|" + this.name + "|"
				+ this.credit + "|" + this.passingGrade;
	}
}
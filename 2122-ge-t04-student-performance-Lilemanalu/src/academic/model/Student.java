package academic.model;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */

public class Student {

    // class definition
    private String studentId;
    private String studentName;
    private Float studentGPA;
    private Integer studentCredit;
    
    public Student(String studentId, 
    		String studentName, 
    		Float studentGPA, 
    		Integer studentCredit) {
    	this.studentId = studentId;
    	this.studentName = studentName;
    	this.studentGPA = studentGPA;
    	this.studentCredit = studentCredit;
    }

    public String getStudentId() {
    	return studentId;
    }
   
    public Float getStudentGPA() {
    	return studentGPA;
    }
    
    
    @Override
    public String toString() {
        return studentId + "|" + studentName + "|" + studentGPA + "|" + studentCredit;
    }
}
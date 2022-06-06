package academic.model;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */

public class Student {

    // class definition
    public String studentId;
    private String studentName;
    private String year;
    private String studyProgram;
    
    public Student(String studentId, 
    		String studentName, 
    		String year, 
    		String studyProgram) {
    	this.studentId = studentId;
    	this.studentName = studentName;
    	this.year = year;
    	this.studyProgram = studyProgram;
    }

    public String getStudentId() {
    	return studentId;
    }
    
    @Override
    public String toString() {
        return studentId + "|" + studentName + "|" + year + "|" + studyProgram;
    }
}
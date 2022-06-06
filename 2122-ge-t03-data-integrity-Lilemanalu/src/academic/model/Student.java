package academic.model;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */
public class Student {

    // class definition
	static Student[] students = new Student[0];
    public String studentId;
    private String studentName;
    private String year;
    private String studyProgram;
    
    public Student(String studentId, String studentName, String year, String studyProgram) {
    	this.studentId = studentId;
    	this.studentName = studentName;
    	this.year = year;
    	this.studyProgram = studyProgram;
    }
    
    public void setStudentId(String studentId) {
    	this.studentId = studentId;
    }
    public void setStudentName(String studentName) {
    	this.studentName = studentName;
    }
    public void setYear(String year) {
    	this.year = year;
    }
    public void setStudyProgram(String studyProgram) {
    	this.studyProgram = studyProgram;
    }
    
    public String getStudentId(Student student) {
    	return student.studentId;
    }
    
    @Override
    public String toString() {
        return studentId + "|" + studentName + "|" + year + "|" + studyProgram;
    }
}
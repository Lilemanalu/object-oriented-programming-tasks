package academic.model;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */
public class Student {

    // class definition
	private String studentId;
    private String studentName;
    private String year;
    private String studyProgram;

    public Student(String studentId, String studentName, String year, String studyProgram) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.year = year;
        this.studyProgram = studyProgram;
    }

//    public String getstudentId(String studentId) {
//        return studentId;
//    }
//
//    public void setId(String studentId) {
//        this.studentId = studentId;
//    }
//
//    public String getstudentName() {
//        return studentName;
//    }
//
//    public void setName(String studentName) {
//        this.studentName = studentName;
//    }
//
//    public String getYear() {
//        return year;
//    }
//
//    public void setYear(String year) {
//        this.year = year;
//    }
//
//    public String getstudyProgram() {
//        return studyProgram;
//    }
//
//    public void setStudyProgram(String studyProgram) {
//        this.studyProgram = studyProgram;
//    }

    public String toString() {
        return studentId + "|" + studentName + "|" + year + "|" + studyProgram;
    }
}
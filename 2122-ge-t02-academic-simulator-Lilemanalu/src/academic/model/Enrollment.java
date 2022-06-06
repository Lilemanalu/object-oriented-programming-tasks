package academic.model;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */
public class Enrollment {

    // class definition
    private String code;
    private String studentId;
    private String academicYear;
    private String semester;
    private String grade;

    public Enrollment(String code, String studentId, String academicYear, String semester, String grade) {
        this.code = code;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None";
    }
//
//    public String getCode(String code) {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getstudentId(String studentId) {
//        return studentId;
//    }
//
//    public void setstudentId(String studentId) {
//        this.studentId = studentId;
//    }
//
//    public String getAcademicYear() {
//        return academicYear;
//    }
//
//    public void setAcademicYear(String academicYear) {
//        this.academicYear = academicYear;
//    }
//
//    public String getSemester() {
//        return semester;
//    }
//
//    public void setSemester(String semester) {
//        this.semester = semester;
//    }
//
//    public String getgrade() {
//        return grade;
//    }
//
//    public void setGrade(String grade) {
//        this.grade = grade;
//    }

    public String toString() {
        return code + "|" + studentId + "|" + academicYear + "|" + semester + "|" + grade;
    }

}
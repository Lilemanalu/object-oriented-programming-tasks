package academic.model;

public class Remedial extends Enrollment {
    String remedialGrade;

    public Remedial(String enrollmentCourseCode, String enrollmentStudentId, String academicYear,
            String semester, String grade, String remedialGrade) {
        super(enrollmentCourseCode, enrollmentStudentId, academicYear, semester, grade);
        this.remedialGrade = remedialGrade;
    }

    public String getRemedialGrade() {
        return remedialGrade;
    }

    public void setRemedialGrade(String remedialGrade) {
        this.remedialGrade = remedialGrade;
    }

    @Override
    public String toString() {
        return super.enrollmentCourseCode + "|" + super.enrollmentStudentId + "|" + super.academicYear + "|"
                + super.semester + "|"
                + this.remedialGrade + "(" + super.grade + ")";
    }

}

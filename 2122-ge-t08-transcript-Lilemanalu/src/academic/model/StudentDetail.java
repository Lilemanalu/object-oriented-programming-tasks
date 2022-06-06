package academic.model;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */

import java.text.DecimalFormat;

public class StudentDetail extends Student {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public Integer detailCredit;
    public Float detailGpa;

    public StudentDetail(String studentId,
            String studentName,
            String year,
            String studyProgram,
            Float detailGpa,
            Integer detailCredit) {
        super(studentId, studentName, year, studyProgram);
        this.detailCredit = detailCredit;
        this.detailGpa = detailGpa;
    }

    public Integer getDetailCredit() {
        return detailCredit;
    }

    public void setDetailCredit(Integer detailCredit) {
        this.detailCredit = detailCredit;
    }

    public Float getDetailGpa() {
        return detailGpa;
    }

    public void setDetailGpa(Float detailGpa) {
        this.detailGpa = detailGpa;
    }

    @Override
    public String toString() {
        return super.studentId + "|" + super.studentName
                + "|" + super.year + "|" + super.studyProgram
                + "|" + df.format(this.detailGpa) + "|" + this.detailCredit;
    }
}

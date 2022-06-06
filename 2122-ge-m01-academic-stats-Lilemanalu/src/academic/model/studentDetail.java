package academic.model;

import java.text.DecimalFormat;

public class studentDetail {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private Student student;
    private Integer detailCredit;
    private Float detailGpa;

    public studentDetail(Student student, Float detailGpa, Integer detailCredit) {
        this.student = student;
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
        return student + "|" + df.format(this.detailGpa) + "|" + this.detailCredit;
    }

}

package academic.model;

public enum Grade {
    A("A"),
    AB("AB"),
    B("B"),
    BC("BC"),
    C("C"),
    D("D"),
    E("E");

    String grade;

    private Grade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return this.grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public static Float getFLoatGrade(String _grades) {
        Float floatGrade;
        if (_grades.equals("A")) {
            floatGrade = 4.00f;
        } else if (_grades.equals("AB")) {
            floatGrade = 3.50f;
        } else if (_grades.equals("B")) {
            floatGrade = 3.00f;
        } else if (_grades.equals("BC")) {
            floatGrade = 2.50f;
        } else if (_grades.equals("C")) {
            floatGrade = 2.00f;
        } else if (_grades.equals("D")) {
            floatGrade = 1.00f;
        } else {
            floatGrade = 0.00f;
        }
        return floatGrade;
    }
}

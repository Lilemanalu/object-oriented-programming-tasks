package academic.model;

public enum Semester {
    ODD("odd"),
    EVEN("even"),
    SHORT("short");

    private final String semester;

    private Semester(String semester) {
        this.semester = semester;
    }

    public String getSemeter() {
        return this.semester;
    }
}

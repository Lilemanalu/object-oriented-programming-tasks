package academic.model;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */

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

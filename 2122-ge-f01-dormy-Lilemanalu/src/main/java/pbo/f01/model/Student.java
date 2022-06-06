package pbo.f01.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "students")
public class Student {
    
    @Id
    @Column(name = "studentId", nullable = false, length = 255)
    public String studentId;
    @Column(name = "studentName", nullable = false, length = 255)
    public String studentName;
    @Column(name = "entranceYear", nullable = false, length = 255)
    public String entranceYear;
    @Column(name = "gender", nullable = false, length = 255)
    public String gender;

    @ManyToMany(targetEntity = Dorm.class, cascade = CascadeType.ALL)
    @JoinTable(name = "student_dorm", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"), 
    inverseJoinColumns = @JoinColumn(name = "dorm_name", referencedColumnName = "dormName"))
    private Set<Dorm> dorms;

    public Student() {
        // empty
    }

    public Student(String studentId, String studentName, String entranceYear, String gender) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.entranceYear = entranceYear;
        this.gender = gender;
    }

    public Student(String studentId, String studentName, String entranceYear, String gender, Set<Dorm> dorms) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.entranceYear = entranceYear;
        this.gender = gender;
        this.dorms = null;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEntranceYear() {
        return entranceYear;
    }

    public void setEntranceYear(String entranceYear) {
        this.entranceYear = entranceYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<Dorm> getDorms() {
        return dorms;
    }

    public void setDorms(Set<Dorm> dorms) {
        this.dorms = dorms;
    }

    @Override
    public String toString() {
        return studentId + "|" + studentName + "|" + entranceYear;
    }

}

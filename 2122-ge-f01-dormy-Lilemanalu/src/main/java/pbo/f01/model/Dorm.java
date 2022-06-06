package pbo.f01.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dorms")  //entity class
public class Dorm {

    @Id
    @Column(name = "dormName", nullable = false)  //entity instance attrobut
    public String dormName;
    @Column(name = "dormCapacity", nullable = false)
    public Integer dormCapacity;
    @Column(name = "dormGender", nullable = false)
    public String dormGender;
    @Column(name = "dormResident", nullable = false)
    public Integer dormResident;

    @ManyToMany(mappedBy = "dorms", cascade = CascadeType.ALL)

    private Set<Student> students;

    public Dorm() {
        // empty
    }

    public Dorm(String dormName, Integer dormCapacity, String dormGender, Integer dormResident) {
        this.dormName = dormName;
        this.dormCapacity = dormCapacity;
        this.dormGender = dormGender;
        this.dormResident = dormResident;
    }

    public Dorm(String dormName, Integer dormCapacity, String dormGender, Integer dormResident, Set<Student> students) {
        this.dormName = dormName;
        this.dormCapacity = dormCapacity;
        this.dormGender = dormGender;
        this.dormResident = dormResident;
        this.students = students;
    }

    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName;
    }

    public Integer getDormCapacity() {
        return dormCapacity;
    }

    public void setDormCapacity(Integer dormCapacity) {
        this.dormCapacity = dormCapacity;
    }

    public String getDormGender() {
        return dormGender;
    }

    public void setDormGender(String dormGender) {
        this.dormGender = dormGender;
    }

    public Integer getDormResident() {
        return dormResident;
    }

    public void setDormResident(Integer dormResident) {
        this.dormResident = dormResident;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return dormName + "|" + dormGender + "|" + dormCapacity + "|" + dormResident;
    }

}
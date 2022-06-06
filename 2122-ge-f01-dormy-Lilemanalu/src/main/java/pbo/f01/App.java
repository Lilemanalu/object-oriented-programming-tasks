package pbo.f01;

import pbo.f01.model.*;

import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * 12S20017 - Lile Asima Manalu
 * 12S20034 - Daniel Limbong
 */

public class App {
    static Student[] students = new Student[0];
    static Dorm[] dorms = new Dorm[0];
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] _args) {

        factory = Persistence.createEntityManagerFactory("dormy_pu");
        entityManager = factory.createEntityManager();
        Scanner sc = new Scanner(System.in);
        String data = "";
        Boolean loop = true;
        cleanTables();
        while (loop) {
            data = sc.nextLine();
            String separator = "#";
            String[] newData = data.split(separator);
            switch (newData[0]) {
                // stop
                case "---":
                    loop = false;
                    break;

                // student-add
                case "student-add":
                    Integer duplicateStudent = checkDuplicateStudent(newData[1]);
                    if (duplicateStudent == 0) {
                        seedTablesStudent(newData);
                    }
                    break;

                // dorm-add
                case "dorm-add":
                    Integer duplicateDorm = checkDuplicateDorm(newData[1]);
                    if (duplicateDorm == 0) {
                        seedTablesDorm(newData);
                        ;
                    }
                    break;

                case "assign":
                    Integer assignMatcher = checkingMatcher(newData[1], newData[2]);
                    if (assignMatcher == 1) {
                        for (Dorm dorm : dorms) {
                            if (dorm.getDormName().equals(newData[2])) {
                                for (Student student : students) {
                                    if (newData[1].equals(student.getStudentId())) {
                                        if (dorm.getDormResident() < dorm.getDormCapacity()) {
                                            student.setDorms(Set.of(dorm));
                                            entityManager.persist(dorm);
                                            entityManager.persist(student);
                                            dorm.setDormResident(dorm.getDormResident() + 1);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;

                case "display-all":
                    // displayAll();
                    displayAllDorms();
                    break;
            }
        }

        cleanTables();
        entityManager.close();
        sc.close();
    }

    // function
    private static Integer checkDuplicateStudent(String param1) {
        Integer duplicateCheck = 0;
        for (Student student : students) {
            if (student.getStudentId().equals(param1)) {
                duplicateCheck++;
            }
        }

        return duplicateCheck;
    }

    private static Integer checkDuplicateDorm(String param1) {
        Integer duplicateCheck = 0;
        for (Dorm dorm : dorms) {
            if (dorm.getDormName().equals(param1)) {
                duplicateCheck++;
            }
        }

        return duplicateCheck;
    }

    private static void newStudent(String[] newData) {
        Student student = new Student(newData[1], newData[2], newData[3], newData[4]);
        students = Arrays.copyOf(students, students.length + 1);
        students[students.length - 1] = student;
    }

    private static void newDorm(String[] newData) {
        Integer defaultDorm = 0;
        Dorm dorm = new Dorm(newData[1], Integer.parseInt(newData[2]), newData[3], defaultDorm);
        dorms = Arrays.copyOf(dorms, dorms.length + 1);
        dorms[dorms.length - 1] = dorm;
    }

    private static void displayAllDorms() {
        String jpql = "SELECT d FROM Dorm d ORDER BY d.dormName";
        List<Dorm> dorms = entityManager.createQuery(jpql, Dorm.class).getResultList();

        for (Dorm d : dorms) {
            System.out.println(d);

            // Set<Student> students = d.getStudents();
            Arrays.sort(students, (a, b) -> a.getStudentName().compareTo(b.getStudentName()));
            for (Student s : students) {
                if (s.getDorms().equals(Set.of(d))) {
                    System.out.println(s);
                }

            }
        }

    }

    private static void seedTablesStudent(String[] newData) {
        entityManager.getTransaction().begin();
        newStudent(newData);
        entityManager.persist(students[students.length - 1]);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    private static void seedTablesDorm(String[] newData) {
        entityManager.getTransaction().begin();
        newDorm(newData);
        entityManager.persist(dorms[dorms.length - 1]);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    private static Integer checkingMatcher(String theId, String theDorm) {
        Integer match = 0;
        for (Dorm dorm : dorms) {
            if (dorm.getDormName().equals(theDorm)) {
                for (Student student : students) {
                    if (student.getStudentId().equals(theId)) {
                        if (student.getGender().equals(dorm.getDormGender())) {
                            match++;
                        }
                    }
                }
            }
        }

        return match;
    }

    private static void cleanTables() {
        String deleteStudentJpql = "DELETE FROM Student s";
        String deleteDormJpql = "DELETE FROM Dorm d";

        entityManager.getTransaction().begin();
        entityManager.createQuery(deleteStudentJpql).executeUpdate();
        entityManager.createQuery(deleteDormJpql).executeUpdate();

        entityManager.flush();
        entityManager.getTransaction().commit();
    }

}
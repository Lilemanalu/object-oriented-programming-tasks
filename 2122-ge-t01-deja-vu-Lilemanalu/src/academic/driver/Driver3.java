package academic.driver;
import java.util.*;
import academic.model.Enrollment;

/**
 * @author 12S20017 Lile Asima Manalu
 */
public class Driver3 {

	public static void main(String[] _args) {
        
		/*
		 * instantiate(create an instance of a class)
		 * using 'new' keyword 
		 */
		Enrollment enrollment = new Enrollment();
      
        /*
         * The Scanner class is used to get user input, 
         * and it is found in the java.util package
         */
        Scanner myEnrollment = new Scanner(System.in);
        
        //nextLine() method to read Strings from user
        String code = myEnrollment.nextLine();
        String id = myEnrollment.nextLine();
        String academicYear = myEnrollment.nextLine();
        String semester = myEnrollment.nextLine();
        
        //mutator to set the value of an attribute
        enrollment.setCode(code);
        enrollment.setId(id);
        enrollment.setAcademicYear(academicYear);
        enrollment.setSemester(semester);
        enrollment.setGrade("None");

        System.out.println(enrollment);
    }

}
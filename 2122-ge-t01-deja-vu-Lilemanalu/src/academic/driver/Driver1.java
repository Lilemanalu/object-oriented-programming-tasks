package academic.driver;

import academic.model.Course;

/**
 * DO NOT EDIT THIS CLASS
 * 
 * @author MSS *
 */
public class Driver1 {

    public static void main(String[] _args) {
        Course course = new Course(
                _args[0],
                _args[1],
                Integer.parseInt(_args[2]),
                _args[3]);

        System.out.println(course);
    }

}
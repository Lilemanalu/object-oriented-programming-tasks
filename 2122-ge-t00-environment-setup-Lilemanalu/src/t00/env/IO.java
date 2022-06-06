package t00.env;

import java.util.*; 
/**
 * @author 12S20017 Lile Asima Manalu
 * 
 */
public class IO {
    public static void main(String[] _args) {
        Scanner input= new Scanner(System.in);
        String NIM =  input.nextLine();
        String Name =  input.nextLine();
        
        System.out.printf("%s|%s\n", NIM, Name);
    }
}
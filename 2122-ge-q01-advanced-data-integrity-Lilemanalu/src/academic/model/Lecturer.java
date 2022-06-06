package academic.model;

/**
 * @author 12S20017 Lile Asima Manalu
 * @author 12S20034 Daniel Limbong
 */

public class Lecturer {
	   	private String lecturerId;
	    private String lecturerName;
	    private String lecturerInitial;
	    private String lecturerEmail;
	    private String lecturerStudyProgram;

	    public Lecturer(String lecturerId, String lecturerName, 
	    		String lecturerInitial, String lecturerEmail,
	            String lecturerStudyProgram) {
	        this.lecturerId = lecturerId;
	        this.lecturerName = lecturerName;
	        this.lecturerInitial = lecturerInitial;
	        this.lecturerEmail = lecturerEmail;
	        this.lecturerStudyProgram = lecturerStudyProgram;
	    }

	    public String getLecturerId() {
	        return lecturerId;
	    }

	    public String getLecturerInitial() {
	        return lecturerInitial;
	    }

	    public String getLecturerEmail() {
	        return "(" + lecturerEmail + ")";
	    }

	    @Override
	    public String toString() {
	        return lecturerId + "|" + lecturerName + "|" + 
	    lecturerInitial + "|" + lecturerEmail + "|"
	                + lecturerStudyProgram;
	    }
}

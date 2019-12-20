//Lab 6
//File name:Student_Tsui
//Name: Wei-Hsuan Tsui
//Course:COSC2436
import java.util.Random;

public class Student_Tsui {
	
	protected String studentID;
	protected String lastName;
	protected String firstName;
	protected Class aClass;
	
	public void assignID() {
		Random rand = new Random();
		int tempNum=rand.nextInt(9000000)+1000000;
		this.studentID= Integer.toString(tempNum);
	}

	public String toString () {
		return ("Student ID: " +studentID+
				"\nStudent: " +firstName+" "+lastName+
				"\nClasses: " +aClass);
	}
	public Student_Tsui deepCopy(){
		Student_Tsui clone = new Student_Tsui();
		clone.studentID=studentID;
		clone.lastName=lastName;
		clone.firstName=firstName;
		clone.aClass=aClass;
	    return clone;
	   }
	public int compareTo(String targetKey) {
	       return studentID.compareTo(targetKey);
	}
	public String getKey() {
		return studentID;
	}
}

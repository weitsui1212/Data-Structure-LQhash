//Lab 6
//File name:FA2019_HashedStructureDemo_Tsui
//Name: Wei-Hsuan Tsui
//Course:COSC2436

import java.util.*;

import java. io. *;

public class FA2019_HashedStructureDemo_Tsui {

	static Scanner console = new Scanner (System.in);

	
	public static void main (String[]args) {
		int MainChoice;
		int choice;
		int MainWhile=0;
		
		System.out.println ("\n"+"Please enter student file location: " +
							"\n" + "for example: C:\\\\Users\\\\wei-hsuan.tsui\\\\eclipse-workspace\\\\testtest\\\\src\\\\testtest\\\\students.csv");

		String fileLocation =console.nextLine();
		
		while (MainWhile<1) {
			showMainChoices ();
			MainChoice=console.nextInt();
		///////LQHashed////////	
			if (MainChoice==1) { 

				// Location of file to read
				File file = new File(fileLocation);

				LQHashed_Tsui  hashed1=new LQHashed_Tsui(200);
				try {
					String [] temp;
					Scanner scanner = new Scanner(file);
					while (scanner.hasNextLine()) {
						Class aClass = new Class();
						Student_Tsui aStudent=new Student_Tsui();
				       String line = scanner. nextLine();//read one line
				       String delimiter =",";
				       temp=line.split(delimiter);
				       aStudent.studentID=temp[0];
				       aStudent.firstName=temp[1];
				       aStudent.lastName=temp[2];
				       
				       if (temp.length<16)
				    	   for(int i=3;i<15;i=i+2) {
				    		   aClass.name=temp[i];
						       aClass.letterGrade=temp[i+1];
						       aStudent.aClass=aClass;
						       hashed1.insert(aStudent);
				    	   }
				       else {
				    	   for(int i=1;i<17;i=i+2) {
				    		   aClass.name=temp[i];
						       aClass.letterGrade=temp[i+1];
						       aStudent.aClass=aClass;
						       hashed1.insert(aStudent);
				    	   }
				       }
				       
					}
					
				   scanner.close();
				} catch ( FileNotFoundException e) {
					System.out. println("File not found");
					System.exit(0);
				}
				
				
				int LQWhile=0;
				while (LQWhile<1) {
					showHashChoices (); //show menu
					choice=console.nextInt();
					if (choice==1) { //insert account
						Class aClass = new Class();
						Student_Tsui aStudent=new Student_Tsui();
						
						System.out.println ("\n"+"Please enter first name: ");
						console.nextLine();
						aStudent.firstName=console.nextLine();
						System.out.println ("\n"+"Please enter last name: ");
						aStudent.lastName=console.nextLine();
						System.out.println ("\n"+"Please enter Class name: ");
						aClass.name=console.nextLine();
						aClass.letterGrade="X";
						aStudent.aClass=aClass;
						aStudent.assignID(); //generated random number for id

						
						hashed1.insert(aStudent);
						if (hashed1.fetch(aStudent.getKey())!=null){
							System.out.println ("Student record Created ");
							System.out.println (hashed1.fetch(aStudent.getKey()));
						}
						else 
							System.out.println ("Insert Failed");
					}
					else if (choice ==2) {
						System.out.println ("\n"+"Please type student ID: ");
						console.nextLine();
						String tempStudentID = console.nextLine();
						Student_Tsui temp =hashed1.fetch(tempStudentID);
						if (temp==null)
							System.out.println("Student cannot be found");
						else 
							System.out.println("Student found");
							System.out.println (temp.toString());
						
					}
					else if (choice ==3) {
						System.out.println ("Please type student ID that you want to verify encapsulation");
						console.nextLine();
						String tempStudentID = console.nextLine();
						Student_Tsui temp = hashed1.fetch(tempStudentID);
						
						System.out.println ("Please type the new last name to verify encapsulation");
						temp.lastName = console.nextLine();
						if(hashed1.fetch(tempStudentID).lastName == temp.lastName)
							System.out.println("LQHashed is not encapsulated");
	                    else
	                    	System.out.println("LQHashed is encapsulated");
					}
					else if (choice ==4) {
						System.out.println ("Please type student ID that you want for update");
						console.nextLine();
						String tempStudentID = console.nextLine();
						Student_Tsui temp3 = hashed1.fetch(tempStudentID);
						
						System.out.println ("Please type the new last name for update");
						temp3.lastName = console.nextLine();
		
						 if(hashed1.update(hashed1.fetch(tempStudentID).studentID,temp3)==true)
			                	System.out.println("Update successfully");                
			             else 
			                	System.out.println("Update Not successfully");
					}
					else if (choice ==5) {
						System.out.println ("Please type student ID that you want for delete");
						console.nextLine();
						String tempStudentID = console.nextLine();
						
						if(hashed1.delete(tempStudentID)==true)
		                	System.out.println("Delete successfully");                
		                else 
		                	System.out.println("Delete Not successfully");
					}
					else if (choice==6) {
						hashed1.showAll();
					}
					else if (choice==0) {
						LQWhile++;
					}
				}
			}
		///////Hashtable////////	
			else if (MainChoice==2) {
				
				// Location of file to read
				File file = new File(fileLocation);
				Hashtable<String,Student_Tsui> javaHash = new Hashtable<String,Student_Tsui>();
				try {
					
					String [] temp;
					Scanner scanner = new Scanner(file);
					while (scanner. hasNextLine()) {
						Class aClass = new Class();
						Student_Tsui aStudent=new Student_Tsui();
				       String line = scanner. nextLine();//read one line
				       String delimiter =",";
				       temp=line.split(delimiter);
				       aStudent.studentID=temp[0];
				       aStudent.firstName=temp[1];
				       aStudent.lastName=temp[2];
				       
				       if (temp.length<16)
				    	   for(int i=3;i<15;i=i+2) {
				    		   aClass.name=temp[i];
						       aClass.letterGrade=temp[i+1];
						       aStudent.aClass=aClass;
						       javaHash.put(aStudent.studentID,aStudent);
				    	   }
				       else {
				    	   for(int i=1;i<17;i=i+2) {
				    		   aClass.name=temp[i];
						       aClass.letterGrade=temp[i+1];
						       aStudent.aClass=aClass;
						       javaHash.put(aStudent.studentID,aStudent);
				    	   }
				       }
				       //javaHash.put(aStudent.studentID,aStudent);
					}
				   scanner.close();
				} catch ( FileNotFoundException e) {
					System.out. println("File not found");
					System.exit(0);
				}
				int JHWhile=0;
				while (JHWhile<1) {
					showHashChoices (); //show menu
					choice=console.nextInt();
					if (choice==1) { //insert account
						Class aClass = new Class();
						Student_Tsui aStudent=new Student_Tsui();
						
						System.out.println ("\n"+"Please enter first name: ");
						console.nextLine();
						aStudent.firstName=console.nextLine();
						System.out.println ("\n"+"Please enter last name: ");
						aStudent.lastName=console.nextLine();
						System.out.println ("\n"+"Please enter Class name: ");
						aClass.name=console.nextLine();
						aClass.letterGrade="X";
						aStudent.aClass=aClass;
						aStudent.assignID(); //generated random number for id
						
						javaHash.put(aStudent.studentID,aStudent);
						System.out.println ("Student record Created ");
						System.out.println (aStudent.toString());
					}
					else if (choice ==2) {
						System.out.println ("\n"+"Please type student ID: ");
						console.nextLine();
						String tempStudentID = console.nextLine();
				
						if (javaHash.get(tempStudentID)==null)
							System.out.println("Student cannot be found");
						else 
							System.out.println (javaHash.get(tempStudentID).toString());
					}
					else if (choice ==3) {
						System.out.println ("Please type student ID that you want to verify encapsulation");
						console.nextLine();
						String tempStudentID = console.nextLine();
						Student_Tsui temp = javaHash.get(tempStudentID);
						
						System.out.println ("Please type the new last name to verify encapsulation");
						temp.lastName = console.nextLine();
						if(javaHash.get(tempStudentID).lastName == temp.lastName)
							System.out.println("Hashtable is not encapsulated");
	                    else
	                    	System.out.println("Hashtable is encapsulated");
					}
					else if (choice ==4) {
						System.out.println ("Please type student ID that you want for update");
						console.nextLine();
						String tempStudentID = console.nextLine();
						Student_Tsui temp3 = javaHash.get(tempStudentID);
						
						System.out.println ("Please type the new last name for update");
						temp3.lastName = console.nextLine();
						javaHash.put(temp3.studentID,temp3);
						
						 if(javaHash.get(tempStudentID).lastName==temp3.lastName)
			                	System.out.println("Update successfully");                
			             else 
			                	System.out.println("Update Not successfully");
					}
					else if (choice ==5) {
						System.out.println ("Please type student ID that you want for delete");
						console.nextLine();
						String tempStudentID = console.nextLine();
						javaHash.remove(tempStudentID);
						if(javaHash.get(tempStudentID)==null)
		                	System.out.println("Delete successfully");                
		                else 
		                	System.out.println("Delete Not successfully");
					}
					else if (choice ==6) {
						Enumeration keyset = javaHash.keys();
						while (keyset.hasMoreElements())
						{
							String studentId = (String) keyset.nextElement();
							System.out.println(javaHash.get(studentId)); //get will fetch the student by studentId
						}
					}
					else if (choice==0) {
						JHWhile++;
					}
					
				}
			}
			else if (MainChoice==0) {
				MainWhile++;
			}
		}
	}
	
	public static void showMainChoices (){

		System.out.println("---------------------------------");
		System.out.println ("1. LQHashed Structure");
		System.out.println ("2. Java Hashtable");
		System.out.println ("0. Exit");
	} 
	public static void showHashChoices (){

		System.out.println("---------------------------------");
		System.out.println ("HASHED DATA STRUCTURE-WEI TSUI");
		System.out.println ("1.Insert Student");
		System.out.println ("2.Fetch");
		System.out.println ("3.Verify Encapsulation");
		System.out.println ("4.Update");
		System.out.println ("5.Delete");
		System.out.println ("6.Show All");
		System.out.println ("0.Exit");
	}
	
}

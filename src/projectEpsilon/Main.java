package projectEpsilon;
import javax.swing.*;
import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		//Flags here control various parts of the prototype for ease of testing.
		boolean windowGenerateTest = false;
		boolean takeStudentInfo = true;
		//MenuGeneration should be the only one set to true if testing how the program will normally run
		boolean menuGeneration = false;
		boolean configGeneration = false;
		boolean arrayTestDump = true;
		
		int studentInt, homeworkInt, i, hwAmount, hwPosition, studentAmount, winHeight, winWidth;
		String input, winName, winCaste;
		Scanner keyboard = new Scanner(System.in);
		
		
		//Tests window generation - use for debugging
		if(windowGenerateTest == true){
			
			//Allows you to change the height of the desired window
			System.out.println("How tall do you want this window?");
			System.out.print("> ");
			input = keyboard.next();
			winHeight = Integer.parseInt(input);
			System.out.println("");
			
			//Allows you to change the width of the desired window
			System.out.println("How wide do you want this window?");
			System.out.print("> ");
			input = keyboard.next();
			winWidth = Integer.parseInt(input);
			System.out.println("");
			
			//Allows you to change the name of the desired window
			System.out.println("What would you like this window to be called?");
			System.out.print("> ");
			winName = keyboard.next();
			
			//Actually creates the window
			WindowController Window = new WindowController(winWidth, winHeight, winName, null);
			
			System.out.println("");
			System.out.println("Generating window hopefully...");
			
		}
		
		//Creates the menu
		if(menuGeneration == true){
			WindowController Menu = new WindowController(300, 100, "Menu", "MENU");
		}
		
		//Forces creation of the config page
		if(configGeneration == true){
			WindowController Config = new WindowController(400, 400, "Configuration", "CONFIG");
		}
		
		//Takes student info and stores it in various arrays, shouldn't be too hard to repurpose once GUI is done
		if(takeStudentInfo == true){
		//Gets the number of students in the class
		System.out.println("Lets set up your gradebook.");
		System.out.println("How many students are in this class?");
		System.out.print("> ");
		input = keyboard.next();
		studentInt = Integer.parseInt(input);
		
		//Sets up an array of students
		Student[] student = new Student[studentInt];
		
		//stores number of students, needed for method getTestValues
		studentAmount = studentInt;
		
		//Gets the number of homework assignments per student
		System.out.println("");
		System.out.println("How many homework assignments will each student be doing?");
		System.out.print("> ");
		input = keyboard.next();
		homeworkInt = Integer.parseInt(input);
		
		//Sets up which student in the array to work with
		studentInt--;
		while(studentInt >= 0){
			student[studentInt] = new Student();
			hwAmount = homeworkInt - 1;
			hwPosition = 0;
			
			//Sets the amount of homework the student has, no input needed
			student[studentInt].setHomeworkAmount(homeworkInt);
			
			//Sets the student's name
			System.out.println("");
			System.out.println("Input student name:");
			System.out.print("> ");
			input = keyboard.next();
			student[studentInt].setName(input);
			
			//Sets the student's lab grade
			System.out.println("");
			System.out.println("Input the student's grade on their lab assignment.");
			System.out.print("> ");
			input = keyboard.next();
			i = Integer.parseInt(input);
			student[studentInt].setLabGrade(i);
			
			//Determines if the student passes their midterm exam
			System.out.println("");
			System.out.println("Input the student's grade on their midterm exam.");
			System.out.print("> ");
			input = keyboard.next();
			i = Integer.parseInt(input);
			student[studentInt].setExamGrade(i);
			
			//Sets the student's essay grade
			System.out.println("");
			System.out.println("Input the student's essay grade.");
			System.out.print("> ");
			input = keyboard.next();
			i = Integer.parseInt(input);
			student[studentInt].setEssayGrade(i);
			
			//Sets the student's grade on their final
			System.out.println("");
			System.out.println("Input the student's grade on their final exam.");
			System.out.print("> ");
			input = keyboard.next();
			i = Integer.parseInt(input);
			student[studentInt].setFinalGrade(i);
			
			//Allows you to input the various homework grades for the student
			while(hwAmount >= 0){
				System.out.println("");
				System.out.println("Input the grade earned on homework assignment number " + (hwPosition + 1));
				System.out.print("> ");
				input = keyboard.next();
				i = Integer.parseInt(input);
				student[studentInt].setHomeworkGrade(i, hwPosition);
				hwPosition++;
				hwAmount--;
			}
			studentInt--;
			System.out.println("Student grades complete.");
		}
		//This makes the student class output all its values, to make sure it is storing them properly
		if(arrayTestDump == true){
		studentAmount--;
		while(studentAmount >= 0){
			hwAmount = homeworkInt - 1;
			student[studentAmount].getTestValues(hwAmount);
			studentAmount--;
			}
		}
		}
	}
}

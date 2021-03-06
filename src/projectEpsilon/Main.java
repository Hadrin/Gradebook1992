package projectEpsilon;
import javax.swing.*;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		//Flags here control various parts of the prototype for ease of testing.
		boolean windowGenerateTest = false;
		boolean takeStudentInfo = true;
		//MenuGeneration should be the only one set to true if testing how the program will normally run
		boolean menuGeneration = true;
		boolean configGeneration = false;
		boolean arrayTestDump = false;
		
		int studentInt, homeworkInt, i, hwAmount, hwPosition, studentAmount, winHeight, winWidth;
		String input, winName, winCaste;
		Scanner keyboard = new Scanner(System.in);
		
		
		//Tests window generation - use for debugging
		if(windowGenerateTest == true)
		{
			
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
			System.out.println("MENU, CONFIG, APPLICATION");
			System.out.print("> ");
			winName = keyboard.next();
			
			//Actually creates the window
			WindowController Window = new WindowController(winWidth, winHeight, winName, null);
			
			System.out.println("");
			System.out.println("Generating window hopefully...");
			
		}
		
		WindowController LoadMenu = new WindowController(500, 500, "Load Menu", "MENU");
		
		

	}
}
		


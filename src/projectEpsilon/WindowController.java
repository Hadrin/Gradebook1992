package projectEpsilon;
import javax.swing.*;
import java.awt.event.*;
/** Used to generate various windows for main.java (gradebook)
 *  Arguments should be in the form (Int x, Int y, String title, String caste) h
 *  
 * @param x width of desired window in pixels
 * @param y height of desired window in pixels
 * @param title title of generated window
 * @param caste Used to determine what to generate inside window (Valid strings: "MENU", "APPLICATION"(not yet), "CONFIG")
 */
public class WindowController extends JFrame {
	
	private JPanel menuPanel;
	private JLabel menuLabel;
	private JButton menuButtonNew;
	private JButton menuButtonLoad;
	
	private JPanel configPanel;
	private JLabel configLabelStudents;
	private JLabel configLabelHomework;
	private JTextField configFieldStudents;
	private JTextField configFieldHomework;
	private JButton configButtonContinue;
	
	private JPanel gradePanel;
	
	private int students = 0;
	private int assignments = 0;
	
	
	//Makes different windows depending on what is given to it
	public WindowController(int x, int y, String title, String caste){
		int WINDOW_HEIGHT = y;
		int WINDOW_WIDTH = x;
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(caste.equals("MENU")){
			buildMenu();
			add(menuPanel);
		}else if(caste.equals("CONFIG")){
			buildConfig();
			add(configPanel);
		}else if(caste.equals("APPLICATION")) {
			System.out.println("Error: Attempted to create an application window without student/assignment values.");
		}else {
			System.out.println("Unrecognized window caste");
		}
		setVisible(true);
	}
		
	public WindowController(int x, int y, String title, String caste, int students, int assignments) {
		int WINDOW_HEIGHT = y;
		int WINDOW_WIDTH = x;
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(caste.equals("APPLICATION")) {
			buildApplication(students, assignments);
			add(gradePanel);
		}
	}
	
		
		
	
	//Creates the main menu window
	private void buildMenu(){
		menuLabel = new JLabel("Welcome to Grade Book 1996.");
		menuButtonNew = new JButton("New Gradebook");
		//Makes the new button work
		menuButtonNew.addActionListener(new MenuButtonNewListener());
		menuButtonLoad = new JButton("Load Gradebook");
		menuPanel = new JPanel();
		menuPanel.add(menuLabel);
		menuPanel.add(menuButtonNew);
		menuPanel.add(menuButtonLoad);
	}
	//Generates the config window when the NEW button is pressed.
	private class MenuButtonNewListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			WindowController Config = new WindowController(300, 300, "Configuration", "CONFIG");
			
		}
	}
	
	
	
	//Creates the configuration page, should be activated by the "new" button on the menu window
	private void buildConfig(){
		String[] studentAmount = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
		String[] assignmentAmount = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
		configLabelStudents = new JLabel("How many students are in this class?");
		JTextField configFieldStudents = new JTextField();
		configLabelHomework = new JLabel("How many assignments are due this semester?");
		JTextField configFieldHomework = new JTextField();
		configButtonContinue = new JButton("Continue");
		configPanel = new JPanel();
		configPanel.add(configLabelStudents);
		configPanel.add(configFieldStudents);
		configPanel.add(configLabelHomework);
		configPanel.add(configFieldHomework);
		configPanel.add(configButtonContinue);
		
	}
	
	private class ConfigButtonContinueListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			students = Integer.parseInt(configFieldStudents);
			WindowController Application = new WindowController(800, 600, "Gradebook 1992", "APPLICATION", students, assignments);
		}
		
	}
	
	private void buildApplication(int students, int assignments) { 
		JButton[] Buttons = new JButton[students * (assignments + 5)];
		int n = 0;
		int i = 0;
		n = (students * (assignments + 5));
		while(i < n) {
			Buttons[i] = new JButton("");
		}
		gradePanel = new JPanel();
		i = 0;
		while(i < n) {
			gradePanel.add(Buttons[i]);
		}
	}
}

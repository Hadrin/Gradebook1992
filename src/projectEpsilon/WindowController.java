package projectEpsilon;
import javax.swing.*;
import java.awt.event.*;
/** Used to generate various windows for main.java (gradebook)
 *  Arguments should be in the form (Int x, Int y, String title, String caste)
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
		}
		setVisible(true);
	
		
		
	}
	//Creates the main menu window
	private void buildMenu(){
		menuLabel = new JLabel("Welcome to Grade Book 1996.");
		menuButtonNew = new JButton("New Gradebook");
		//Makes the new button work
		menuButtonNew.addActionListener(new NewButtonListener());
		menuButtonLoad = new JButton("Load Gradebook");
		menuPanel = new JPanel();
		menuPanel.add(menuLabel);
		menuPanel.add(menuButtonNew);
		menuPanel.add(menuButtonLoad);
	}
	//Generates the config window when the NEW button is pressed.
	private class NewButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			WindowController Config = new WindowController(300, 300, "Configuration", "CONFIG");
			
		}
	}
	
	
	
	//Creates the configuration page, should be activated by the "new" button on the menu window
	private void buildConfig(){
		configLabelStudents = new JLabel("How many students are in this class?");
		configFieldStudents = new JTextField(2);
		configLabelHomework = new JLabel("How many homework assignments are due this semester?");
		configFieldHomework = new JTextField(2);
		configButtonContinue = new JButton("Continue");
		configPanel = new JPanel();
		configPanel.add(configLabelStudents);
		configPanel.add(configFieldStudents);
		configPanel.add(configLabelHomework);
		configPanel.add(configFieldHomework);
		configPanel.add(configButtonContinue);
	}
	
	private void buildApplication(int students, int assignments) { 
		
	}
}

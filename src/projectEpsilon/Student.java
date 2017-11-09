package projectEpsilon;

public class Student {
	private String Name = "";
	private int labGrade = 0;
	private boolean examPass = false;
	private int essayGrade = 0;
	private int finalGrade = 0;
	private int[] homeworkGrades;
	
	
	/** The setHomeworkAmount method sets the number of homework assignments are expected.
	 *
	 * @param n integer number of homework assignments
	 */
	public void setHomeworkAmount(int n){
	homeworkGrades = new int[n];
	}
	
	/** The setName method takes a string and sets it as the student's name.
	 * 
	 * @param str String to set the student's name as
	 */
	public void setName(String str){
		Name = str;
	}
	
	/** The setLabGrade method sets the student's grade for their lab project
	 * 
	 * @param n is the integer grade for their lab project
	 */
	public void setLabGrade(int n){
		labGrade = n;
	}
	
	/** The setExamGrade method takes the student's exam grade, and if it is 70 or above they pass, or else they fail.
	 * 
	 * @param n integer representing student's grade 
	 */
	public void setExamGrade(int n){
		if(n < 70){
			examPass = false;
		}else{
			examPass = true;
		}
	}
	
	/** The setEssayGrade method sets the student's essay grade
	 * 
	 * @param n integer the student's essay grade should be set to
	 */
	public void setEssayGrade(int n){
		essayGrade = n;
	}
	
	/** The setFinalGrade method sets the student's grade on their final exam.
	 * 
	 * @param n integer to set finalGrade to
	 */
	public void setFinalGrade(int n){
		finalGrade = n;
	}
	
	/** The setHomeworkGrade method allows you to set a given homework assignment's grade
	 * 
	 * @param grade is the grade for the given homework assignment
	 * @param position controls which homework assignment grade you are changing
	 */
	public void setHomeworkGrade(int grade, int position){
		homeworkGrades[position] = grade;
	}
	
	/** The getTestValues method outputs all grade information regarding a student, useful for testing
	 * 
	 * @param n controls output of homework data, get from (homeworkInt - 1) in main.class
	 */
	public void getTestValues(int n){
		System.out.println("String name: " + Name);
		System.out.println("Integer labGrade: " + labGrade);
		System.out.println("Boolean examPass: " + examPass);
		System.out.println("Integer essayGrade: " + essayGrade);
		System.out.println("Integer finalGrade: " + finalGrade);
		System.out.print("Homework grades:");
		while(n >= 0){
			System.out.print(homeworkGrades[n]);
			n--;
		}
	}
}

package ST;

public class FlowExGradeBook {
	private String courseName = new String();
	private String instructor = new String();

	public FlowExGradeBook() {
	}

	public FlowExGradeBook(String name) {
		setCourseName(name);
	}
	
	public FlowExGradeBook(String course, String instructor){
		setCourseName(course);
		setInstructorName(instructor);
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String name) {
		courseName = name;
	}
	
	public String getInstructorName(){
		return instructor;
	}
	
	public void setInstructorName(String name){
		instructor = name;
	}

	public void displayMessage() {
		System.out.printf("歡迎來到%s老師的%s成績簿物件\n", getInstructorName(),getCourseName());
	}
	
	
}

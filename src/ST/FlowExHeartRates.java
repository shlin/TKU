package ST;
import java.util.*;

public class FlowExHeartRates {
	private String lastName = new String();
	private String firstName = new String();
	private int year = 0;
	private int month = 0;
	private int day = 0;
	
	public FlowExHeartRates(String lastName, String firstName, int year, int month, int day){
		setLastName(lastName);
		setFirstName(firstName);
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
	public int calcAge(){
		Calendar today = Calendar.getInstance();
		int newYear = 0, newMonth = 0, newDay = 0;
		
		newYear = today.get(Calendar.YEAR) - year;
		newMonth = today.get(Calendar.MONTH) - month;
		newDay = today.get(Calendar.DATE) - day;
		
		if(newMonth < 0 || (newMonth == 0 && newDay < 0))
			newYear ++;
		
		return newYear;
	}
	
	public int calcMaximumHeartRate(){
		return 220 - calcAge();
	}
	
	public void calcTargetHeartRate(){
		int lower = 0;
		int upper = 0;
		
		lower = (int) Math.round(calcMaximumHeartRate() * 0.5);
		upper = (int) Math.round(calcMaximumHeartRate() * 0.85);
		
		System.out.println("目標心跳率範圍：" + lower + " to " + upper);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
}

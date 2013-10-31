package ST;

public class FlowExDate {
	private int year = 0;
	private int month = 0;
	private int day = 0;
	
	public FlowExDate(int year, int month, int day){
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
	public void displayDate(){
		System.out.printf("%04d/%02d/%02d\n", getYear(), getMonth(), getDay());
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

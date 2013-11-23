package ST;

public class FlowExHealthProfile {
	private String lastName = new String();
	private String firstName = new String();
	private int year = 0;
	private int month = 0;
	private int day = 0;
	private int height = 0;
	private int weight = 0;
	
	private FlowExBMI bmi = null;
	private FlowExHeartRates heartRate = null;

	public FlowExHealthProfile(String lastName, String firstName, int year,
			int month, int day, int height, int weight) {
		
		setLastName(lastName);
		setFirstName(firstName);
		setYear(year);
		setMonth(month);
		setDay(day);
		setHeight(height);
		setWeight(weight);
		
		bmi = new FlowExBMI(lastName + firstName, weight, (double) height / 100);
		heartRate = new FlowExHeartRates(lastName, firstName, year, month, day);
	}
	
	public int calcAge(){
		return heartRate.calcAge();
	}
	
	public int calcMaximumHeartRate(){
		return heartRate.calcMaximumHeartRate();
	}
	
	public void calcTargetHeartRate(){
		heartRate.calcTargetHeartRate();
	}
	
	public double calcBMI(){
		return bmi.calcBMI();
	}
	
	public void printBMI(){
		bmi.displayMessage();
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}

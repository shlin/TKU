package ST;

public class FlowExEmployee {
	private String lastName = new String();
	private String firstName = new String();
	private double salary = 0;

	public FlowExEmployee(String lastName, String firstName, double salary) {
		setLastName(lastName);
		setFirstName(firstName);
		setSalary(salary);
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary > 0 ? salary : 0;
	}
}

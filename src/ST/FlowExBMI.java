package ST;

public class FlowExBMI {
	private String name = new String();
	private double weight = 0; // 公斤
	private double height = 0; // 公尺

	public FlowExBMI(String name, double weight, double height) {
		setName(name);
		setWeight(weight);
		setHeight(height);
	}

	public double calcBMI() {
		return weight / Math.pow(height, 2);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight > 0 ? weight : 0;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height > 0 ? height : 0;
	}

	public void displayMessage() {
		double bmi = calcBMI();
		// s8
		System.out.println(getName() + "您好，" + "您的身高" + getHeight() * 100
				+ "公分，" + "體重" + getWeight() + "公斤，" + "體質數=" + bmi);
		
		
		// s9
		if(bmi < 18.5)
			System.out.println("目前過輕");
		else if(bmi > 24)
			System.out.println("目前過重");
		else
			System.out.println("目前正常");
	}
}

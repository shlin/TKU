package ST;

import java.util.*;
import java.util.regex.*;

public class FlowEx {
	static double max = Double.MIN_VALUE;
	static double min = Double.MAX_VALUE;

	// (輸出練習) o1
	public static void o1() {
		System.out.println("1 2 3 4");
		System.out.print("1 2 3 4\n");
		System.out.printf("1 2 3 4\n");
		System.out.print("1 ");
		System.out.print("2 ");
		System.out.print("3 ");
		System.out.print("4\n");
	}

	// (輸出練習) o2
	public static void o2() {
		System.out.println("\t*******         ***           *           *");
		System.out.println("\t*     *       *     *        ***         * *");
		System.out.println("\t*     *      *       *      *****       *   *");
		System.out.println("\t*     *      *       *        *        *     *");
		System.out.println("\t*     *      *       *        *         *   *");
		System.out.println("\t*     *       *     *         *          * *");
		System.out.println("\t*******         ***           *           *");
	}

	// (輸出練習) o3
	public static void o3() {
		System.out.println("\t* * * * * * * *");
		System.out.println("\t * * * * * * * *");
		System.out.println("\t* * * * * * * *");
		System.out.println("\t * * * * * * * *");
		System.out.println("\t* * * * * * * *");
		System.out.println("\t * * * * * * * *");
		System.out.println("\t* * * * * * * *");
	}

	// (輸出練習) o4
	public static void o4() {
		System.out.println("數字\t平方\t立方");

		for (int i = 0; i <= 10; i++)
			System.out.println(i + "\t" + i * i + "\t" + i * i * i);
	}

	// (輸入練習) i1
	public static void i1() {
		Scanner input = new Scanner(System.in);
		int a = 0, b = 0;

		System.out.println("公式 y = a x b ^ 3 + 7");
		System.out.print("a = ");
		if (input.hasNext())
			a = input.nextInt();

		System.out.print("b = ");
		if (input.hasNext())
			b = input.nextInt();

		System.out.println("y = " + (a * (int) Math.pow(b, 3) + 7));
	}

	// (輸入練習) i2
	public static void i2() {
		Scanner input = new Scanner(System.in);
		double a = 0, b = 0;

		System.out.println("輸入兩數字 a, b");
		System.out.print("a = ");
		if (input.hasNext())
			a = input.nextDouble();

		System.out.print("b = ");
		if (input.hasNext())
			b = input.nextDouble();

		System.out.println("和 = " + (a + b));
		System.out.println("積 = " + (a * b));
		System.out.println("差 = " + (a - b));
		System.out.println("商 = " + (a / b));
	}

	// (輸入練習) i3
	public static void i3() {
		Scanner input = new Scanner(System.in);
		double a = 0, b = 0, c = 0;

		System.out.println("輸入三個數字 a, b, c");
		System.out.print("a = ");
		if (input.hasNext())
			a = input.nextDouble();

		System.out.print("b = ");
		if (input.hasNext())
			b = input.nextDouble();

		System.out.print("c = ");
		if (input.hasNext())
			c = input.nextDouble();

		System.out.println("積 = " + (a * b * c));
	}

	// (輸入練習) i4
	public static void i4() {
		Scanner input = new Scanner(System.in);
		double r = 0;

		System.out.println("輸入半徑 r");
		System.out.print("r = ");
		if (input.hasNext())
			r = input.nextDouble();

		System.out.println("直徑 = " + (2 * r));
		System.out.println("周長 = " + (2 * r * Math.PI));
		System.out.println("面積 = " + (Math.PI * Math.pow(r, 2)));
	}

	// (輸入練習) i5
	public static void i5() {
		Scanner input = new Scanner(System.in);
		int num = 0;

		System.out.println("輸入一個五位數");
		System.out.print("五位數整數 > ");
		while (input.hasNextInt()) {
			num = input.nextInt();
			if (num > 9999 && num < 100000) {
				System.out.print("結果：");
				System.out.printf("%d ", num / 10000);
				num %= 10000;
				System.out.printf("%d ", num / 1000);
				num %= 1000;
				System.out.printf("%d ", num / 100);
				num %= 100;
				System.out.printf("%d ", num / 10);
				num %= 10;
				System.out.printf("%d\n", num);
				break;
			}

			num = 0;
			System.out.print("請重新輸入五位數整數 > ");
		}
	}

	// (輸入練習) i6
	public static void i6() {
		Scanner input = new Scanner(System.in);
		String firstName = new String();
		String lastName = new String();

		System.out.println("輸入姓名");
		System.out.print("姓：");
		if (input.hasNext())
			lastName = input.nextLine();

		System.out.print("名：");
		if (input.hasNext())
			firstName = input.nextLine();

		System.out.printf("招呼：Hi，%s%s，您好！\n", lastName, firstName);
	}

	// (輸入練習) i7
	public static void i7() {
		Scanner input = new Scanner(System.in);
		char inChar;

		do {
			System.out.print("Char > ");
			if (input.hasNext(Pattern.compile("."))) {
				inChar = input.nextLine().charAt(0);
				System.out.println("Code = " + (int) inChar);
				break;
			}

			inChar = input.nextLine().charAt(0);
			System.out.println("請重新輸入一個字元!!");
			inChar = '\0';
		} while (true);
	}

	// (比較練習) f1
	public static void f1() {
		Scanner input = new Scanner(System.in);
		double a = 0, b = 0, c = 0, sum = 0;

		System.out.println("輸入三個數字 a, b, c");
		System.out.print("a = ");
		if (input.hasNext())
			a = input.nextDouble();

		max = a > max ? a : max;
		min = a < min ? a : min;

		System.out.print("b = ");
		if (input.hasNext())
			b = input.nextDouble();

		max = b > max ? b : max;
		min = b < min ? b : min;

		System.out.print("c = ");
		if (input.hasNext())
			c = input.nextDouble();

		max = c > max ? c : max;
		min = c < min ? c : min;

		sum = a + b + c;

		System.out.println("和 = " + sum);
		System.out.println("平均 = " + (sum / 3));
		System.out.println("積 = " + (a * b * c));
		System.out.println("最大值 = " + max);
		System.out.println("最小值 = " + min);
	}

	// (比較練習) f2
	public static void f2() {
		Scanner input = new Scanner(System.in);
		double a = 0, b = 0;

		System.out.println("輸入兩數字 a, b");
		System.out.print("a = ");
		if (input.hasNext())
			a = input.nextDouble();

		System.out.print("b = ");
		if (input.hasNext())
			b = input.nextDouble();

		if (a > b)
			System.out.println(a + " > " + b);
		else if (a == b)
			System.out.println(a + " = " + b);
		else if (a < b)
			System.out.println(a + " < " + b);
	}

	// (比較練習) f3
	public static void f3() {
		Scanner input = new Scanner(System.in);
		double[] num = new double[5];

		System.out.println("輸入五個數字");
		for (int i = 0; i < 5; i++) {
			System.out.printf("number %d > ", i + 1);
			if (input.hasNext())
				num[i] = input.nextDouble();
			max = num[i] > max ? num[i] : max;
			min = num[i] < min ? num[i] : min;
		}

		System.out.println("最大值 = " + max);
		System.out.println("最小值 = " + min);
	}

	// (比較練習) f4
	public static void f4() {
		Scanner input = new Scanner(System.in);
		double a = 0, b = 0;

		System.out.println("輸入兩數字 a, b");
		System.out.print("a = ");
		if (input.hasNext())
			a = input.nextDouble();

		System.out.print("b = ");
		if (input.hasNext())
			b = input.nextDouble();

		if (a % b == 0)
			System.out.printf("%.0f 為 %.0f 的倍數！\n", a, b);
	}

	// (比較練習) f5
	public static void f5() {
		Scanner input = new Scanner(System.in);
		double[] num = new double[5];
		int positive = 0, zero = 0, negative = 0;

		System.out.println("輸入五個數字");
		for (int i = 0; i < 5; i++) {
			System.out.printf("number %d > ", i + 1);
			if (input.hasNext())
				num[i] = input.nextDouble();

			positive = num[i] > 0 ? positive + 1 : positive;
			zero = num[i] == 0 ? zero + 1 : zero;
			negative = num[i] < 0 ? negative + 1 : negative;
		}

		System.out.println("正數：" + positive);
		System.out.println("零：" + zero);
		System.out.println("負數：" + negative);
	}

	// (簡單物件)(成績簿) s1
	public static void s1() {
		Scanner input = new Scanner(System.in);
		FlowExGradeBook newBook = new FlowExGradeBook();

		System.out.print("科目名稱：");
		if (input.hasNext())
			newBook.setCourseName(input.nextLine());

		System.out.printf("科目名稱：%s\n", newBook.getCourseName());
		newBook.displayMessage();
	}

	// (簡單物件)(成績簿) s2
	public static void s2() {
		FlowExGradeBook newBookST = new FlowExGradeBook("軟體技術");
		FlowExGradeBook newBookML = new FlowExGradeBook("機器學習");

		System.out.printf("科目名稱：%s\n", newBookST.getCourseName());
		System.out.printf("科目名稱：%s\n", newBookML.getCourseName());
	}

	// (簡單物件)(成績簿) s3
	public static void s3() {
		FlowExGradeBook newBookST = new FlowExGradeBook("軟體技術", "魏世杰");

		newBookST.displayMessage();
	}

	// (簡單物件)(戶頭) s4
	public static void s4() {
		FlowExAccount newAccount = new FlowExAccount(50);
		System.out.printf("餘額：%f\n", newAccount.getBalance());

		System.out.println("存入 25");
		newAccount.credit(25);
		System.out.printf("餘額：%f\n", newAccount.getBalance());
	}

	// (簡單物件)(戶頭) s5
	public static void s5() {
		FlowExAccount newAccount = new FlowExAccount(50);
		System.out.printf("餘額：%f\n", newAccount.getBalance());

		System.out.println("提領：" + newAccount.debit(25));
		System.out.printf("餘額：%f\n", newAccount.getBalance());

		System.out.println("提領：" + newAccount.debit(35));
		System.out.printf("餘額：%f\n", newAccount.getBalance());
	}

	// (簡單物件)(員工) s6
	public static void s6() {
		FlowExEmployee empA = new FlowExEmployee("蟹", "老闆", 100000);
		FlowExEmployee empB = new FlowExEmployee("派", "大星", 80000);

		System.out.println(empA.getLastName() + empA.getFirstName() + "的年薪："
				+ (empA.getSalary() * 12));
		System.out.println(empB.getLastName() + empB.getFirstName() + "的年薪："
				+ (empB.getSalary() * 12));

		System.out.println("### 調薪後 ###");

		empA.setSalary(empA.getSalary() * 1.1);
		empB.setSalary(empB.getSalary() * 1.1);

		System.out.println(empA.getLastName() + empA.getFirstName() + "的年薪："
				+ (empA.getSalary() * 12));
		System.out.println(empB.getLastName() + empB.getFirstName() + "的年薪："
				+ (empB.getSalary() * 12));

	}

	// (簡單物件)(BMI) s7
	public static void s7() {
		FlowExBMI bmiA = new FlowExBMI("蟹老闆", 60, 1.7);

		System.out.println(bmiA.getName() + "的BMI：" + bmiA.calcBMI());
	}

	// (簡單物件)(BMI) s8
	public static void s8() {
		FlowExBMI bmiA = new FlowExBMI("蟹老闆", 60, 1.7);

		bmiA.displayMessage();
	}

	// (簡單物件)(BMI) s9
	public static void s9() {
		FlowExBMI bmiA = new FlowExBMI("蟹老闆", 60, 1.7);

		bmiA.displayMessage();
	}

	// (簡單物件)(發票) s10
	public static void s10() {
		FlowExInvoice newInvoice = new FlowExInvoice("0001", "美味蟹堡", 2, 10);
		System.out.println("發票金額：" + newInvoice.getInvoiceAmount());
	}

	// (簡單物件)(日期) s11
	public static void s11() {
		FlowExDate newDate = new FlowExDate(2013, 11, 1);
		newDate.displayDate();
	}

	// (簡單物件)(目標心跳率) s12
	public static void s12() {
		FlowExHeartRates newPatient = new FlowExHeartRates("派", "大星", 1988, 6,
				5);

		System.out.println("年齡：" + newPatient.calcAge());
		newPatient.calcTargetHeartRate();
	}

	// (簡單物件)(健康記錄) s13
	public static void s13() {
		FlowExHealthProfile newPatient = new FlowExHealthProfile("派", "大星",
				1988, 6, 5, 170, 60);

		System.out.println("年齡：" + newPatient.calcAge());
		newPatient.calcTargetHeartRate();
		newPatient.printBMI();
	}

	// (公式練習) i1
	public static void funcI1() {
		Scanner input = new Scanner(System.in);
		int intNum = 0;

		System.out.print("請輸入一個整數 > ");
		if (input.hasNext())
			intNum = input.nextInt();

		System.out.printf("%d 為%s\n", intNum, intNum % 2 == 0 ? "偶數" : "奇數");
	}

	// (公式練習) i2
	public static void funcI2() {
		Scanner input = new Scanner(System.in);
		int intScore = 0;
		String level = new String();

		do {
			System.out.print("請輸入一個整數 > ");
			if (input.hasNext())
				intScore = input.nextInt();

			if (intScore >= 0 && intScore <= 100)
				break;
		} while (true);

		if (intScore >= 90 && intScore <= 100)
			level = "A";
		else if (intScore >= 80 && intScore < 90)
			level = "B";
		else if (intScore >= 70 && intScore < 80)
			level = "C";
		else if (intScore >= 60 && intScore < 70)
			level = "D";
		else
			level = "F";

		System.out.println("等級：" + level);

	}

	// (公式練習) i3
	public static void funcI3() {
		Scanner input = new Scanner(System.in);
		int x = 0;
		double y = 0;

		System.out.print("x = ");
		x = input.hasNext() ? input.nextInt() : 0;

		if (x < -1)
			y = 3 * Math.pow(x, 2);
		else if (x >= -1 && x <= 1)
			y = Math.pow(x, 3) + 3 * x - 3;
		else if (x > 1)
			y = 2 * x + 3;

		System.out.println("y = " + y);
	}

	// (公式練習) i4
	public static void funcI4() {
		Scanner input = new Scanner(System.in);
		int a = 0, b = 0, c = 0;
		double x1 = 0, x2 = 0;

		System.out.println("求解 a * x ^ 2 + b * x + c = 0 的根 x = ?");

		System.out.print("a = ");
		a = input.hasNext() ? input.nextInt() : 0;
		System.out.print("b = ");
		b = input.hasNext() ? input.nextInt() : 0;
		System.out.print("c = ");
		c = input.hasNext() ? input.nextInt() : 0;

		if (b * b == 4 * a * c) {
			x1 = x2 = -(b / 2 * a);
			System.out.println("有重根 x = " + x1);
		} else if (b * b > 4 * a * c) {
			x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
			x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);

			System.out.println("x 為 " + x1 + " 及 " + x2);
		} else
			System.out.println("沒有實根，no real root");
	}

	// (公式練習) i5
	public static void funcI5() {
		Scanner input = new Scanner(System.in);
		int a = 0, b = 0, c = 0;
		int aa = 0, bb = 0, cc = 0;
		int swap = 0;

		System.out.println("輸入三角形的三邊長a, b, c");

		System.out.print("a = ");
		a = input.hasNext() ? input.nextInt() : 0;
		System.out.print("b = ");
		b = input.hasNext() ? input.nextInt() : 0;
		System.out.print("c = ");
		c = input.hasNext() ? input.nextInt() : 0;

		if (a > c) {
			swap = c;
			c = a;
			a = swap;
		} else if (b > c) {
			swap = c;
			c = a;
			a = swap;
		}

		aa = a * a;
		bb = b * b;
		cc = c * c;
		if (c < a + b) {
			if (cc == aa + bb)
				System.out.println("此為直角三角形");
			else if (cc > aa + bb)
				System.out.println("此為鈍角三角形");
			else if (cc < aa + bb)
				System.out.println("此為銳角三角形");
		} else
			System.out.println("這不是三角形");
	}

	// (統計練習) s1 同上 f3
	// (統計練習) s2 同上 f5
	public static void statS1() {
		Scanner input = new Scanner(System.in);
		double a = 0, b = 0, c = 0;
		double max = Double.MIN_VALUE, min = Double.MAX_VALUE;

		System.out.println("輸入三個實數 a, b, c");
		System.out.print("a > ");
		a = input.hasNext() ? input.nextDouble() : 0;
		System.out.print("b > ");
		b = input.hasNext() ? input.nextDouble() : 0;
		System.out.print("c > ");
		c = input.hasNext() ? input.nextDouble() : 0;

		max = a > b ? a > c ? a : c : b > c ? b : c;
		min = a < b ? a < c ? a : c : b < c ? b : c;

		System.out.println("max = " + max);
		System.out.println("min = " + min);
	}

	// (數字拆解) d1
	public static void d1() {
		Scanner input = new Scanner(System.in);
		int intNum = 0, isSeven = 0;
		Integer num = new Integer(0);

		do {
			System.out.print("請輸入一個五位數的整數 > ");
			intNum = input.hasNext() ? input.nextInt() : 0;
			if (intNum > 9999 && intNum <= 99999)
				break;
		} while (true);

		num = intNum;
		for(int i =0; i < 5; i++){
			if(num.toString().charAt(i) == '7')
				isSeven ++;
		}
		
		System.out.println("數字7有" + isSeven + "個");
	}

	// (遞迴練習) r7
	public static void r7() {
		Scanner input = new Scanner(System.in);
		int[] inputData = new int[100];
		int index = 0;

		do {
			if (input.hasNextInt()) {
				inputData[index] = input.nextInt();
				if (inputData[index] == -1)
					break;
				index++;
			}
		} while (true);

		r7Method(inputData, 0);
	}

	public static boolean r7Method(int[] data, int index) {
		if (data[index] == -1)
			return true;

		if (r7Method(data, index + 1))
			System.out.print(data[index] + " ");

		return true;
	}
}

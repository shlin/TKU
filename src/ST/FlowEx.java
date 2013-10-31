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
}

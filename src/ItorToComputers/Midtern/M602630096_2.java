package ItorToComputers.Midtern;

import java.util.*;

public class M602630096_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int number = 0;
		int numA = 0, numB = 0, numC = 0;
		int sum = 0, max = 0;

		// 輸入
		while (true) {
			System.out.print("請輸入一個三位數：");
			if (input.hasNextInt())
				number = input.nextInt();

			if (number >= 100 && number <= 999)
				break;
		}

		// 分離數字
		// 個位數
		numC = number % 10;
		number = number / 10;
		// 十位數
		numB = number % 10;
		number = number / 10;
		// 百位數
		numA = number;
		

		// 算總和
		sum = numA + numB + numC;

		// 求最大值
		max = numA;
		if (numB > max)
			max = numB;
		if (numC > max)
			max = numC;

		System.out.printf("總和：%d\n", sum);
		System.out.printf("最大：%d\n", max);
	}

}

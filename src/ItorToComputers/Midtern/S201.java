/*
  請修改檔名為你學號.
  此處請貼上你的輸出結果供評分參考

1.(100%)排列組合
    請實作如下3數學方法
	public static double factorial(double n)
	回傳 n! = n x (n-1) x (n-2) x ... x 1

	public static double combination(double n, double m)
	回傳 C_n_m = n! / m! / (n-m)!
	提示: 呼叫 factorial() 完成

	public static double permutation(double n, double m)
	回傳 P_n_m = n! / (n-m)!
	提示: 呼叫 factorial() 完成

(Sample Output)
factorial(4) = 24.0
factorial(3) = 6.0
factorial(2) = 2.0
factorial(1) = 1.0
factorial(0) = 1.0
combination(4,4) = 1.0
combination(4,3) = 4.0
combination(4,2) = 6.0
combination(4,1) = 4.0
combination(4,0) = 1.0
permutation(4,4) = 24.0
permutation(4,3) = 24.0
permutation(4,2) = 12.0
permutation(4,1) = 4.0
permutation(4,0) = 1.0


 */
package ItorToComputers.Midtern;

/**
 * @author PStar
 * 
 */
public class S201 {
	// 回傳 n! = n x (n-1) x (n-2) x ... x 1
	public static double factorial(double n) {
		// 此處寫上你的程式碼
		if (n <= 1)
			return 1;
		return n * factorial(n - 1);
	}

	// 回傳 C_n_m = n! / m! / (n-m)!
	public static double combination(double n, double m) {
		// 此處寫上你的程式碼
		return factorial(n) / factorial(m) / factorial(n - m);
	}

	// 回傳 P_n_m = n! / (n-m)!
	public static double permutation(double n, double m) {
		// 此處寫上你的程式碼
		return factorial(n) / factorial(n - m);
	}

	public static void main(String args[]) {
		System.out.println("factorial(4) = " + factorial(4));
		System.out.println("factorial(3) = " + factorial(3));
		System.out.println("factorial(2) = " + factorial(2));
		System.out.println("factorial(1) = " + factorial(1));
		System.out.println("factorial(0) = " + factorial(0));

		System.out.println("combination(4,4) = " + combination(4, 4));
		System.out.println("combination(4,3) = " + combination(4, 3));
		System.out.println("combination(4,2) = " + combination(4, 2));
		System.out.println("combination(4,1) = " + combination(4, 1));
		System.out.println("combination(4,0) = " + combination(4, 0));

		System.out.println("permutation(4,4) = " + permutation(4, 4));
		System.out.println("permutation(4,3) = " + permutation(4, 3));
		System.out.println("permutation(4,2) = " + permutation(4, 2));
		System.out.println("permutation(4,1) = " + permutation(4, 1));
		System.out.println("permutation(4,0) = " + permutation(4, 0));
	}

}

/*
  請修改檔名為你學號.
  此處請貼上你的輸出結果供評分參考

3.(100%)遞迴求解
 以遞迴寫出如下3方法
 (a) 求數字為幾位數方法
       public static int digitsNo(long n)
       接收正整數n,回傳n為幾位數.
     提示: digitsNo(n) = digitsNo(n/10) + 1 for n > 0
           digitsNo(n) = 0 for n=0

 (b) 求某數反轉值
       public static long reverse(long n)
       接收正整數n,計算n數字反轉值.
     提示: reverse(n) = n for n<10
           reverse(n) = n除以10的餘數 x 10^digitsNo(n除以10的商)
                        + reverse(n除以10的商) for otherwise
           其中,^表示次方,可利用Math.pow(10,y)計算10的y次方
           回傳型別可利用(long)指令轉型為長整數.

 (c) 求C(n,m)組合值
       public static int combination(int n, int m)
       接收正整數n,m,回傳C(n,m).
     提示: C(n,m) = 1 for n=m or m=0
           C(n,m) = n for m=1
           C(n,m) = C(n-1,m) + C(n-1,m-1) for otherwise

(Sample Output)
digitsNo(67890) = 5
digitsNo(6789) = 4
digitsNo(678) = 3
digitsNo(67) = 2
digitsNo(6) = 1
reverse(50321) = 12305
reverse(5032) = 2305
reverse(503) = 305
reverse(50) = 5
reverse(5) = 5
combination(5,5) = 1
combination(5,4) = 5
combination(5,3) = 10
combination(5,2) = 10
combination(5,1) = 5
combination(5,0) = 1


 */
package ItorToComputers.Midtern;

/**
 * @author PStar
 * 
 */
public class S203 {
	/*
	 * 接收正整數n,回傳n為幾位數. 提示: digitsNo(n) = digitsNo(n/10) + 1 for n > 0
	 * digitsNo(n) = 0 for n=0
	 */
	public static int digitsNo(long n) {
		// 此處寫上你的程式碼
		if (n == 0)
			return 0;
		return digitsNo(n / 10) + 1;
	}

	/*
	 * 接收正整數n,計算n數字反轉值. 提示: reverse(n) = n for n<10 reverse(n) = n除以10的餘數 x
	 * 10^digitsNo(n除以10的商) + reverse(n除以10的商) for otherwise
	 * 其中,^表示次方,可利用Math.pow(10,y)計算10的y次方 回傳型別可利用(long)指令轉型為長整數.
	 */
	public static long reverse(long n) {
		// 此處寫上你的程式碼
		if (n < 10)
			return n;
		return (n % 10) * (long) Math.pow(10, digitsNo(n / 10))
				+ reverse(n / 10);
	}

	/*
	 * 接收正整數n,m,回傳C(n,m). 提示: C(n,m) = 1 for n=m or m=0 C(n,m) = n for m=1
	 * C(n,m) = C(n-1,m) + C(n-1,m-1) for otherwise
	 */
	public static int combination(int n, int m) {
		// 此處寫上你的程式碼
		if (n == m || m == 0)
			return 1;
		else if (m == 1)
			return n;
		return combination(n - 1, m) + combination(n - 1, m - 1);
	}

	public static void main(String args[]) {
		System.out.println("digitsNo(67890) = " + digitsNo(67890));
		System.out.println("digitsNo(6789) = " + digitsNo(6789));
		System.out.println("digitsNo(678) = " + digitsNo(678));
		System.out.println("digitsNo(67) = " + digitsNo(67));
		System.out.println("digitsNo(6) = " + digitsNo(6));

		System.out.println("reverse(50321) = " + reverse(50321));
		System.out.println("reverse(5032) = " + reverse(5032));
		System.out.println("reverse(503) = " + reverse(503));
		System.out.println("reverse(50) = " + reverse(50));
		System.out.println("reverse(5) = " + reverse(5));

		System.out.println("combination(5,5) = " + combination(5, 5));
		System.out.println("combination(5,4) = " + combination(5, 4));
		System.out.println("combination(5,3) = " + combination(5, 3));
		System.out.println("combination(5,2) = " + combination(5, 2));
		System.out.println("combination(5,1) = " + combination(5, 1));
		System.out.println("combination(5,0) = " + combination(5, 0));
	}
}

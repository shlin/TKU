/**
以遞迴寫出如下2方法

 (a) 求數字為幾位數方法

       public static int numberOfDigits(long n)

       接收正整數n,回傳n為幾位數.



 (b) 求兩數最大公因數方法

       public static int gcd(int m, int n)

       接收正整數m,n,回傳兩數最大公因數.

     提示:以輾轉相除法,兩數相除後,再以其除數除以餘數,直到餘數為零.

          gcd(x,y) = gcd(y, x%y); gcd(x,0) = x



(Sample Output)

numberOfDigits(4395) = 4

numberOfDigits(395) = 3

numberOfDigits(95) = 2

numberOfDigits(5) = 1

gcd(20,1) = 1

gcd(20,2) = 2

gcd(20,4) = 4

gcd(20,8) = 4

gcd(8,20) = 4


 */
package ItorToComputers;

/**
 * @author PStar
 * 
 */
public class S2HW03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// (a)求數字為幾位數方法
		System.out.printf("numberOfDigits(%d) = %d\n", 4395,
				numberOfDigits(4395));
		System.out
				.printf("numberOfDigits(%d) = %d\n", 395, numberOfDigits(395));
		System.out.printf("numberOfDigits(%d) = %d\n", 95, numberOfDigits(95));
		System.out.printf("numberOfDigits(%d) = %d\n", 5, numberOfDigits(5));

		// (b) 求兩數最大公因數方法
		System.out.printf("gcd(%d,%d) = %d\n", 20, 1, gcd(20, 1));
		System.out.printf("gcd(%d,%d) = %d\n", 20, 2, gcd(20, 2));
		System.out.printf("gcd(%d,%d) = %d\n", 20, 4, gcd(20, 4));
		System.out.printf("gcd(%d,%d) = %d\n", 20, 8, gcd(20, 8));
		System.out.printf("gcd(%d,%d) = %d\n", 8, 20, gcd(8, 20));
	}

	public static int numberOfDigits(long n) {
		return n >= 0 && n < 10 ? 1 : numberOfDigits(n / 10) + 1;
	}
	
	public static int gcd(int m, int n){
		return n == 0 ? m : gcd(n , m %n);
	}

}

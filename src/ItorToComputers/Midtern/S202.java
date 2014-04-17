/*
  請修改檔名為你學號.
  此處請貼上你的輸出結果供評分參考

2.(100%)亂數產生器
    請實作如下兩亂數產生方法
	public static int randomIntegerFromInterval(int lower, int upper)
	回傳範圍介於[lower,upper]區間內的一個均勻隨機整數.
	提示: 利用Math.random()產生一個介於[0,1)區間之隨機實數x,
	      再用如下公式,將rand範圍放大調整到[a,b]區間,
	      	    int rand = a + (int) (x * (b-a+1));

	public static char randomGender(int menWeight, int womenWeight)
	回傳一個隨機男(M)或女(F)性別表示字元,其男女人數權重比為menWeight : womenWeight
	提示: 利用randomIntegerFromInterval(1, menWeight+womenWeight)
	      產生一個[1,menWeight+womenWeight]隨機整數y,
	      若y位於[1,menWeight]區間,回傳男(M)字元;
	      若y位於[menWeight+1,menWeight+womenWeight]區間,回傳女(F)字元;

(Sample Output)
600 numbers from interval [-3,2] are -2, 0, -1, 2, -3, 1, ...
    frequency of -3 is ?
    frequency of -2 is ?
    ...

500 genders with weight (men,women)=(4,1) are M, M, F, M, ...
    frequency of M is ?
    frequency of W is ?
    ...


 */
package ItorToComputers.Midtern;

/**
 * @author PStar
 * 
 */
public class S202 {
	/*
	 * 回傳範圍介於[lower,upper]區間內的一個均勻隨機整數. 提示: 利用Math.random()產生一個介於[0,1)區間之隨機實數x,
	 * 再用如下公式,將rand範圍放大調整到[a,b]區間, int rand = a + (int) (x * (b-a+1));
	 */
	public static int randomIntegerFromInterval(int lower, int upper) {
		// 此處寫上你的程式碼
		double x = Math.random();
		int rand = lower + (int) (x * (upper - lower + 1));

		return rand;
	}

	/*
	 * 回傳一個隨機男(M)或女(F)性別表示字元,其男女人數權重比為menWeight : womenWeight 提示:
	 * 利用randomIntegerFromInterval(1, menWeight+womenWeight)
	 * 產生一個[1,menWeight+womenWeight]隨機整數y, 若y位於[1,menWeight]區間,回傳男(M)字元;
	 * 若y位於[menWeight+1,menWeight+womenWeight]區間,回傳女(F)字元
	 */
	public static char randomGender(int menWeight, int womenWeight) {
		// 此處寫上你的程式碼
		int y = randomIntegerFromInterval(1, menWeight + womenWeight);
		
		if(y >= 1 && y <= menWeight)
			return 'M';
		else if(y >= menWeight+1 && y <= menWeight + womenWeight)
			return 'F';
		
		return '?';
	}

	public static void main(String args[]) {
		System.out.print("600 numbers from interval [-3,2] are ");
		int count_m3 = 0;
		int count_m2 = 0;
		int count_m1 = 0;
		int count_0 = 0;
		int count_1 = 0;
		int count_2 = 0;
		for (int i = 1; i <= 600; i++) {
			int n = randomIntegerFromInterval(-3, 2);
			System.out.print(n + ",");

			if (n == -3)
				count_m3++;
			else if (n == -2)
				count_m2++;
			else if (n == -1)
				count_m1++;
			else if (n == 0)
				count_0++;
			else if (n == 1)
				count_1++;
			else if (n == 2)
				count_2++;
		}
		System.out.println();
		System.out.println("\tfrequency of -3 is " + count_m3);
		System.out.println("\tfrequency of -2 is " + count_m2);
		System.out.println("\tfrequency of -1 is " + count_m1);
		System.out.println("\tfrequency of 0  is " + count_0);
		System.out.println("\tfrequency of 1  is " + count_1);
		System.out.println("\tfrequency of 2  is " + count_2);

		System.out.print("500 genders with weight (men,women)=(4,1) are ");
		int count_m = 0;
		int count_f = 0;
		for (int i = 1; i <= 500; i++) {
			char g = randomGender(4, 1);
			System.out.print(g + ",");

			if (g == 'M')
				count_m++;
			else if (g == 'F')
				count_f++;
		}
		System.out.println();
		System.out.println("\tfrequency of M is " + count_m);
		System.out.println("\tfrequency of F is " + count_f);
	}
}
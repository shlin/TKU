/*
2.方法包裝
 寫出如下2個有關長短針鐘面時間的計算方法
 (a) 時分秒轉換成秒方法
       public static int timeToSeconds(int hour, int min, int sec)
       接收時分秒時間(hour:min:sec),回傳其相對於0時0分0秒經過的秒數.
       三參數需檢查hour介於0~11, min介於0~59, sec介於0~59,
       若任一參數範圍不對,回傳-1.

 (b) 時間秒差計算方法
       public static int timeDifferenceInSeconds(
         int h1, int m1, int s1, int h2, int m2, int s2)
       接收兩組時分秒時間1(h1:m1:s1)及時間2(h2:m2:s2),
       回傳鐘面時間2要走到鐘面時間1所需經過的秒數,
       此秒數恆為正數或0,值介於0~43199.

(Sample Output)
timeToSeconds(5,4,0) = 18240
timeToSeconds(3,5,0) = 11100
timeToSeconds(13,69,70) = -1
timeDifferenceInSeconds(5,4,0,3,5,0) = 7140
timeDifferenceInSeconds(3,5,0,5,4,0) = 36060
 
 */

package ItorToComputers.Midtern;

/**
 * @author PStar
 * 
 */
public class S202 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// (a)
		System.out.printf("timeToSeconds(%d,%d,%d) = %d\n", 5, 4, 0,
				timeToSeconds(5, 4, 0));
		System.out.printf("timeToSeconds(%d,%d,%d) = %d\n", 3, 5, 0,
				timeToSeconds(3, 5, 0));
		System.out.printf("timeToSeconds(%d,%d,%d) = %d\n", 13, 69, 70,
				timeToSeconds(13, 69, 70));

		// (b)
		System.out.printf("timeDifferenceInSeconds(%d,%d,%d,%d,%d,%d) = %d\n",
				5, 4, 0, 3, 5, 0, timeDifferenceInSeconds(5, 4, 0, 3, 5, 0));
		System.out.printf("timeDifferenceInSeconds(%d,%d,%d,%d,%d,%d) = %d\n",
				3, 5, 0, 5, 4, 0, timeDifferenceInSeconds(3, 5, 0, 5, 4, 0));
	}

	public static int timeToSeconds(int hour, int min, int sec) {
		int secSum = 0;

		if (sec >= 0 && sec <= 59)
			secSum += sec;
		else
			return -1;

		if (min >= 0 && min <= 59)
			secSum += min * 60;
		else
			return -1;

		if (hour >= 0 && hour <= 11)
			secSum += hour * 3600;
		else
			return -1;

		return secSum;
	}

	public static int timeDifferenceInSeconds(int h1, int m1, int s1, int h2,
			int m2, int s2) {
		int secDiff = 0;
		int time1, time2;

		time1 = timeToSeconds(h1, m1, s1);
		time2 = timeToSeconds(h2, m2, s2);

		secDiff = time1 - time2;

		return secDiff >= 0 ? secDiff : 43200 + secDiff;
	}

}

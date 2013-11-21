package ST.Midtern;

import java.io.*;
import java.util.*;
import java.math.*;

public class MidAns {
	public static void M1() {
		Random r = new Random(1);
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		int sum = 0;
		double average = 0;

		for (int i = 0; i < 10001; i++)
			numbers.add(r.nextInt());

		// Display
		System.out.println("(1) 平均值 = " + mAverage(numbers));
		System.out.println("(2) 標準差 = " + mStdDeviation(numbers));
		System.out.println("(3) 中位數 = " + mMedian(numbers));
	}

	public static double mSum(ArrayList<Integer> numbers) {
		double sum = 0;
		Iterator<Integer> iter = numbers.iterator();
		while (iter.hasNext())
			sum += iter.next();
		return sum;
	}

	public static double mAverage(ArrayList<Integer> numbers) {
		return (double) mSum(numbers) / numbers.size();
	}

	public static double mStdDeviation(ArrayList<Integer> numbers) {
		double average = mAverage(numbers);
		double tmpSum = 0, result = 0;

		Iterator<Integer> iter = numbers.iterator();
		while (iter.hasNext())
			tmpSum += Math.pow((double) iter.next() - average, 2);
		result = Math.sqrt(tmpSum / numbers.size());

		return result;
	}

	public static int mMedian(ArrayList<Integer> numbers) {
		int[] tmpArray = new int[numbers.size()];

		for (int i = 0; i < numbers.size(); i++)
			tmpArray[i] = numbers.get(i);
		Arrays.sort(tmpArray);

		return numbers.size() % 2 == 0 ? (tmpArray[numbers.size() / 2 - 1] + tmpArray[(numbers
				.size() / 2)]) / 2 : tmpArray[(numbers.size() + 1) / 2 - 1];
	}

	public static void M2() {
		ArrayList<BigInteger> seqFibonacci = FibonacciLoop(80);

		System.out.println("(1) F(70) 最小3位數為 "
				+ seqFibonacci.get(70).mod(BigInteger.valueOf(1000)));
		System.out.println("(2) F(80) => "
				+ seqFibonacci.get(80).toString().length() + " 位數");
	}

	public static ArrayList<BigInteger> FibonacciLoop(int n) {
		ArrayList<BigInteger> numbers = new ArrayList<BigInteger>();
		numbers.add(0, BigInteger.ZERO);
		numbers.add(1, BigInteger.ONE);
		for (int i = 2; i <= n; i++)
			numbers.add(numbers.get(i - 2).add(numbers.get(i - 1)));
		return numbers;
	}

	public static void M4() throws IOException {
		FileInputStream file = new FileInputStream("exInputFile/Mid4Input.txt");
		Scanner input = new Scanner(file, "UTF-8");
		TreeMap<String, Integer> wordMap = new TreeMap<String, Integer>();
		String srcLine = new String();
		String chineseStr = new String();

		while (input.hasNext())
			srcLine += input.next();

		chineseStr = srcLine.replaceAll("[\\w\\s\\p{Punct}]", "").replaceAll(
				"\\p{P}", "");
		System.out.println("(1) 中文字數量：" + chineseStr.length());

		for (int i = 0; i < chineseStr.length(); i++) {
			String current = Character.toString(chineseStr.charAt(i));
			wordMap.put(current,
					wordMap.containsKey(current) ? wordMap.get(current) + 1 : 1);
		}

		System.out.println("(2) 中文字種類：" + wordMap.size());

		Set<String> maxSet = maxTimes(wordMap);
		Iterator<String> iter = maxSet.iterator();

		System.out.println("(3) 出現最多中文字為：");
		while (iter.hasNext())
			System.out.println(iter.next());
	}

	// 最常見的單字
	public static Set<String> maxTimes(TreeMap<String, Integer> wordMap) {
		int maxTimes = Integer.MIN_VALUE;
		Set<String> resultSet = new TreeSet<String>();

		Iterator<String> iterStr = wordMap.keySet().iterator();
		String current = new String();

		while (iterStr.hasNext()) {
			current = iterStr.next();
			maxTimes = wordMap.get(current) > maxTimes ? wordMap.get(current)
					: maxTimes;
		}

		if (maxTimes > 1) {
			iterStr = wordMap.keySet().iterator();
			while (iterStr.hasNext()) {
				current = iterStr.next();
				if (wordMap.get(current) == maxTimes)
					resultSet.add(current);
			}
		}

		return resultSet;
	}

	public static void M5() {
		ArrayList<BigInteger> result = new ArrayList<BigInteger>();
		BigInteger resultRecursive = BigInteger.ZERO;
		long start_time = System.currentTimeMillis();

		long end_time = System.currentTimeMillis();
		long diff_time = end_time - start_time;

		long[] loop_time = new long[5];
		long[] recursive_time = new long[5];

		for (int i = 1; i <= 5; i++) {
			start_time = System.currentTimeMillis();
			result = FibonacciLoop(i * 10);
			end_time = System.currentTimeMillis();
			loop_time[i - 1] = end_time - start_time;
			System.out.println("F(" + i * 10 + ") = " + result.get(i * 10)
					+ " : " + loop_time[i - 1] + "毫秒");
		}

		for (int i = 1; i <= 5; i++) {
			start_time = System.currentTimeMillis();
			resultRecursive = FibonacciRecursive(i * 10);
			end_time = System.currentTimeMillis();
			recursive_time[i - 1] = end_time - start_time;
			System.out.println("F(" + i * 10 + ") = " + resultRecursive + " : "
					+ recursive_time[i - 1] + "毫秒");
		}
	}

	public static BigInteger FibonacciRecursive(int n) {
		return n == 0 ? BigInteger.ZERO : n == 1 || n == 2 ? BigInteger.ONE
				: FibonacciRecursive(n - 1).add(FibonacciRecursive(n - 2));
	}

}

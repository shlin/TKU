/**
 * 為方便下週二期中考進行,請事先熟悉如下基礎程式寫法.
 * 又為評分方便,一律先看運算結果對,才看程式碼.
 * 
 * 1.迴圈和遞迴兩種寫法基本上可以互換,
 * 請就數字和,次方,階層,排列,組合,費氏數列等簡單數學公式,展示其兩種寫法.
 * 
 * 2.亂數產生器(java.util.Random)可依種子產生固定亂數序列,
 * 請就某種子數列前n數,計算其基本統計量,例如:平均,標準差,最大,最小,中位數,眾數等
 * 
 * 3.當有效位數超過18位,傳統long/double型別就派不上用場,
 * 請熟悉題庫HugeInteger或java.math.BigInteger/BigDecimal類別如何作四則運算.
 * 
 * 4.二元樹每個節點最多可有左,右兩節點,其前,中,後序走訪可輔助運算式的複製,列印,及求值等運算;
 * 加上左小右大元素擺放限制的二元搜索樹,更常用於樹集合,樹映射等有序容器製作,提供快速查詢,增刪等功能.
 * 請熟悉課本如下二元搜索樹範例
 * ftp://mail.im.tku.edu.tw/seke/jhtp9/examples/ch22/fig22_17_18/
 * 理解不同的加入(insertNode)順序,如何影響樹長相及其前,中,後序走訪結果.
 * 又可否自己手動串接樹節點(TreeNode),建立任意一顆二元樹.
 * 例如:某二元樹的前序走訪為ABDCEGFH，中序走訪為BDAGECFH，則其後訪走訪結果為何.
 * 
 * 5.一篇文章通常有如下基本統計量,例如:總字形數,各字出現次數,總字數,最常見/罕見字,標點符號數,段落數,行數等
 * 請熟悉Java如何讀取文字檔,斷字,及文字統計方法.
 * 
 * 註:英文斷字可用java.util.StringTokenizer
 * 中文斷字可用 mmseg4j.jar 套件, 如下,
 * http://mail.im.tku.edu.tw/~seke/mmseg/
 * 參考其中com.chenlb.mmseg4j.example.Simple類別用例.
 *
 */
package ST;

import java.util.*;
import java.io.*;
import java.math.*;

import com.chenlb.mmseg4j.*;
import com.chenlb.mmseg4j.Dictionary;
import com.chenlb.mmseg4j.example.*;

/**
 * @author PStar 期中考公告後練習題
 * 
 */
public class MidEx {
	// 第一大題 各寫出迴圈、遞迴兩種寫法
	// 數字和 1 + 2 + 3 + ... + n
	public static void m1Sum() {
		Scanner input = new Scanner(System.in);
		int n = 0;

		System.out.println("數字和：1 + 2 + ... + n = ?");
		System.out.print("n = ");
		n = input.hasNextInt() ? input.nextInt() : 0;

		System.out.printf("Loop: 1 + 2 + ... + %d = %d\n", n, m1SumLoop(n));
		System.out.printf("Recursive: 1 + 2 + ... + %d = %d\n", n,
				m1SumRecursive(n));
	}

	// 數字和 Loop
	public static int m1SumLoop(int n) {
		int result = 0;

		for (int i = 1; i <= n; i++)
			result += i;

		return result;
	}

	// 數字和 Recursive
	public static int m1SumRecursive(int n) {
		return n == 1 ? 1 : n + m1SumRecursive(n - 1);
	}

	// 次方 n ^ k
	public static void m1Power() {
		Scanner input = new Scanner(System.in);
		int n = 0, k = 0;

		System.out.println("次方：n ^ k = ? (N >= 0 , K >= 0)");
		System.out.print("n = ");
		n = input.hasNextInt() ? input.nextInt() : 0;
		System.out.print("k = ");
		k = input.hasNextInt() ? input.nextInt() : 0;

		System.out.printf("Loop: %d ^ %d = %d\n", n, k, m1PowerLoop(n, k));
		System.out.printf("Recursive: %d ^ %d = %d\n", n, k,
				m1PowerRecursive(n, k));
	}

	// 次方 Loop
	public static int m1PowerLoop(int base, int exp) {
		int result = base;

		if (exp == 0)
			return 1;

		for (int i = 1; i < exp; i++)
			result *= base;

		return result;
	}

	// 次方 Recursive
	public static int m1PowerRecursive(int base, int exp) {
		return exp == 0 ? 1 : base * m1PowerRecursive(base, exp - 1);
	}

	// 階層 n!
	public static void m1Factorial() {
		Scanner input = new Scanner(System.in);
		double n = 0;

		System.out.println("階層：n! = ? (N >= 0)");
		System.out.print("n = ");
		n = input.hasNextDouble() ? input.nextDouble() : 0;

		System.out.printf("Loop: %.2f! = %.2f\n", n, m1FactorialLoop(n));
		System.out.printf("Recursive: %.2f! = %.2f\n", n,
				m1FactorialRecursive(n));
	}

	// 階層 Loop
	public static double m1FactorialLoop(double n) {
		double result = 1;

		for (int i = 1; i <= n; i++)
			result *= i;

		return result;
	}

	// 階層 Recursive
	public static double m1FactorialRecursive(double n) {
		return n <= 1 ? 1 : n * m1FactorialRecursive(n - 1);
	}

	// 排列 P_n_m = n! / (n - m)!
	public static void m1Perm() {
		Scanner input = new Scanner(System.in);
		double n = 0, m = 0;

		System.out.println("排列：Pn取m = ? (n, m > 0)");
		System.out.print("n = ");
		n = input.hasNextDouble() ? input.nextDouble() : 0;
		System.out.print("m = ");
		m = input.hasNextDouble() ? input.nextDouble() : 0;

		System.out.printf("Loop: P_n_m(%.0f, %.0f) = %.0f\n", n, m,
				m1PermLoop(n, m));
		System.out.printf("Recursive: P_n_m(%.0f, %.0f) = %.0f\n", n, m,
				m1PermRecursive(n, m));
	}

	// 排列 Loop
	public static double m1PermLoop(double n, double m) {
		double result = 1;

		for (double i = n - m + 1; i <= n; i++)
			result *= i;

		return Math.abs(result);
	}

	// 排列 Recursive N取M
	public static double m1PermRecursive(double n, double m) {
		return m1PermRecursive(n) / m1PermRecursive(n - m);
	}

	// 排列 Recursive N取N
	public static double m1PermRecursive(double n) {
		return n <= 1 ? 1 : n * m1PermRecursive(n - 1);
	}

	// 組合
	public static void m1Comb() {
		Scanner input = new Scanner(System.in);
		double n = 0, m = 0;

		System.out.println("排列：Cn取m = ? (n, m > 0)");
		System.out.print("n = ");
		n = input.hasNextDouble() ? input.nextDouble() : 0;
		System.out.print("m = ");
		m = input.hasNextDouble() ? input.nextDouble() : 0;

		System.out.printf("Loop: C_n_m(%.0f, %.0f) = %.0f\n", n, m,
				m1CombLoop(n, m));
		System.out.printf("Recursive: C_n_m(%.0f, %.0f) = %.0f\n", n, m,
				m1CombRecursive(n, m));
	}

	// 組合 Loop
	public static double m1CombLoop(double n, double m) {
		double result = 1;

		for (double i = n - m + 1; i <= n; i++)
			result *= i;
		for (double i = 1; i <= m; i++)
			result /= i;

		return result;
	}

	// 組合 Recursive
	public static double m1CombRecursive(double n, double m) {
		return m == 0 ? 1 : n < m ? 0 : m1CombRecursive(n - 1, m)
				+ m1CombRecursive(n - 1, m - 1);
	}

	/*
	 * 費氏數列 Fibonacci: 0, 1, 1, 2, 3, 5, 8, 13, 21 ...
	 */
	public static void m1Fibonacci() {
		Scanner input = new Scanner(System.in);
		int n = 0;
		ArrayList<Double> forLoop = new ArrayList<Double>();
		ArrayList<Double> forRecursive = new ArrayList<Double>();

		System.out.println("Fibonacci Number 求第 n 項");
		System.out.print("n = ");
		n = input.hasNextInt() ? input.nextInt() : 0;

		forLoop = m1FibonacciLoop(n);
		System.out.println("Loop: " + forLoop.get(n));
		System.out.println("Recursive: " + m1FibonacciRecursive(n));
	}

	// 費氏數列 Loop
	public static ArrayList<Double> m1FibonacciLoop(int n) {
		ArrayList<Double> numbers = new ArrayList<Double>();
		numbers.add(0, 0.0);
		numbers.add(1, 1.0);
		for (int i = 2; i <= n; i++)
			numbers.add(numbers.get(i - 2) + numbers.get(i - 1));
		return numbers;
	}

	/*
	 * 費氏數列 Recursive 此 Method 為求數列前 n 項的number
	 */
	public static void m1FibonacciRecursive(ArrayList<Double> numbers, int n) {
		for (int i = 0; i <= n; i++)
			numbers.add(m1FibonacciRecursive(i));
	}

	/*
	 * 費氏數列 Recursive 此 Method 求數列第 n 項的number，建議測試 n 不要大於 45
	 */
	public static double m1FibonacciRecursive(int n) {
		return n == 0 ? 0 : n == 1 ? 1 : m1FibonacciRecursive(n - 1)
				+ m1FibonacciRecursive(n - 2);
	}

	/*
	 * 第二大題 亂數產生一數列 n 項 求平均,標準差,最大,最小,中位數,眾數等基本統計量
	 */
	public static void m2() {
		Scanner input = new Scanner(System.in);
		Random rand = new Random(100);
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int n = 0;

		System.out.println("產生一個 n 項亂數數列，求其基本的統計量。");
		System.out.print("n = ");
		n = input.hasNextInt() ? input.nextInt() : 0;

		// 產生n項的亂數數列，暫定Range為1 ~ 100
		for (int i = 0; i < n; i++) {
			numbers.add(rand.nextInt(100) + 1);
			// System.out.printf("%d\t: %d\n", i, numbers.get(i));
		}

		System.out.println("總和：" + m2Sum(numbers));
		System.out.println("平均：" + m2Average(numbers));
		System.out.println("標準差：" + m2StdDeviation(numbers));
		System.out.println("最大值：" + m2Max(numbers));
		System.out.println("最小值：" + m2Min(numbers));
		System.out.println("中位數：" + m2Median(numbers));
		System.out.println("眾數：" + m2Mode(numbers));
	}

	// 總和
	public static int m2Sum(ArrayList<Integer> numbers) {
		int sum = 0;
		Iterator<Integer> iter = numbers.iterator();
		while (iter.hasNext())
			sum += iter.next();
		return sum;
	}

	// 平均
	public static double m2Average(ArrayList<Integer> numbers) {
		return (double) m2Sum(numbers) / numbers.size();
	}

	// 標準差
	public static double m2StdDeviation(ArrayList<Integer> numbers) {
		double average = m2Average(numbers);
		double tmpSum = 0, result = 0;

		Iterator<Integer> iter = numbers.iterator();
		while (iter.hasNext())
			tmpSum = Math.pow((double) iter.next() - average, 2);
		result = Math.sqrt(tmpSum / numbers.size());

		return result;
	}

	// 最大值
	public static int m2Max(ArrayList<Integer> numbers) {
		int max = Integer.MIN_VALUE;
		int current = 0;
		Iterator<Integer> iter = numbers.iterator();
		while (iter.hasNext()) {
			current = iter.next();
			max = max < current ? current : max;
		}
		return max;
	}

	// 最小值
	public static int m2Min(ArrayList<Integer> numbers) {
		int min = Integer.MAX_VALUE;
		int current = 0;
		Iterator<Integer> iter = numbers.iterator();
		while (iter.hasNext()) {
			current = iter.next();
			min = min > current ? current : min;
		}
		return min;
	}

	// 中位數
	public static int m2Median(ArrayList<Integer> numbers) {
		int[] tmpArray = new int[numbers.size()];

		for (int i = 0; i < numbers.size(); i++)
			tmpArray[i] = numbers.get(i);
		Arrays.sort(tmpArray);

		return numbers.size() % 2 == 0 ? (tmpArray[numbers.size() / 2 - 1] + tmpArray[(numbers
				.size() / 2)]) / 2 : tmpArray[(numbers.size() + 1) / 2 - 1];
	}

	// 眾數 如果有多個眾數存在時，目前暫時只有一個
	public static int m2Mode(ArrayList<Integer> numbers) {
		int current = 0, result = 0;
		Map<Integer, Integer> tmpMap = new TreeMap<Integer, Integer>();
		Iterator<Integer> iter = numbers.iterator();

		while (iter.hasNext()) {
			current = iter.next();
			tmpMap.put(current,
					tmpMap.containsKey(current) ? tmpMap.get(current) + 1 : 1);
		}

		iter = tmpMap.keySet().iterator();
		result = tmpMap.keySet().iterator().next();
		while (iter.hasNext()) {
			current = iter.next();
			result = tmpMap.get(current) > tmpMap.get(result) ? current
					: result;
		}

		return result;
	}

	/*
	 * 3.當有效位數超過18位,傳統long/double型別就派不上用場,
	 * 請熟悉題庫HugeInteger或java.math.BigInteger/BigDecimal類別如何作四則運算.
	 */
	// 大數運算使用 BigInteger / BigDecimal 進行四則運算
	public static void m3() {
		Scanner input = new Scanner(System.in);
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ZERO;

		System.out.println("大數四則運算 a + b, a - b, a * b, a / b");
		System.out.print("a = ");
		a = input.hasNextBigInteger() ? input.nextBigInteger()
				: BigInteger.ZERO;
		System.out.print("b = ");
		b = input.hasNextBigInteger() ? input.nextBigInteger()
				: BigInteger.ZERO;

		System.out.printf("%s + %s = %s\n", a, b, a.add(b));
		System.out.printf("%s - %s = %s\n", a, b, a.add(b.negate()));
		System.out.printf("%s * %s = %s\n", a, b, a.multiply(b));
		System.out.printf("%s / %s = %s\n", a, b, a.divide(b));
		System.out.printf("%s mod %s = %s\n", a, b, a.mod(b));
	}

	/*
	 * 4.二元樹每個節點最多可有左,右兩節點,其前,中,後序走訪可輔助運算式的複製,列印,及求值等運算;
	 * 加上左小右大元素擺放限制的二元搜索樹,更常用於樹集合,樹映射等有序容器製作,提供快速查詢,增刪等功能. 請熟悉課本如下二元搜索樹範例
	 * ftp://mail.im.tku.edu.tw/seke/jhtp9/examples/ch22/fig22_17_18/
	 * 理解不同的加入(insertNode)順序,如何影響樹長相及其前,中,後序走訪結果.
	 * 又可否自己手動串接樹節點(TreeNode),建立任意一顆二元樹.
	 * 例如:某二元樹的前序走訪為ABDCEGFH，中序走訪為BDAGECFH，則其後訪走訪結果為何.
	 */
	// Binary Tree
	public static void m4() {
		Scanner input = new Scanner(System.in);

	}

	/*
	 * 5.一篇文章通常有如下基本統計量,例如:總字形數,各字出現次數,總字數,最常見/罕見字,標點符號數,段落數,行數等
	 * 請熟悉Java如何讀取文字檔,斷字,及文字統計方法.
	 * 
	 * 註:英文斷字可用java.util.StringTokenizer 中文斷字可用 mmseg4j.jar 套件, 如下,
	 * http://mail.im.tku.edu.tw/~seke/mmseg/
	 * 參考其中com.chenlb.mmseg4j.example.Simple類別用例.
	 */
	public static void m5() throws IOException {
		FileInputStream fchtInput = new FileInputStream("exInputFile/cht.txt");
		FileInputStream fenInput = new FileInputStream("exInputFile/en.txt");
		Scanner input = null;
		String textStr = null;
		String current = null;

		// 英文解析
		textStr = new String();
		input = new Scanner(fenInput, "UTF-8");
		while (input.hasNext()) {
			current = input.nextLine();
			textStr += current.isEmpty() ? "\r\n" : current + "\n";
		}
		// m5EnWords(textStr);

		// 中文解析
		textStr = new String();
		input = new Scanner(fchtInput, "UTF-8");
		while (input.hasNext()) {
			current = input.nextLine();
			textStr += current.isEmpty() ? "\r\n" : current + "\n";
		}
		m5ChtWords(textStr);
	}

	// 英文解析
	public static void m5EnWords(String str) {
		TreeMap<String, Integer> wordMap = new TreeMap<String, Integer>();
		TreeMap<String, Integer> helfWordMap = new TreeMap<String, Integer>();
		TreeMap<String, Integer> fullWordMap = new TreeMap<String, Integer>();

		// 純文字
		String pureWords = str.replaceAll("[()\\.,\\\"]", "");

		// 標點符號
		String symbols = str.replaceAll("[^\\p{Punct}]", "");

		// 全形字
		String fullStr = str.replaceAll("[\\u0020-\\u007E]", "");

		// 半形字
		String helfStr = str.replaceAll("[^\\u0000-\\u007E]", "");

		int totalWords = 0, fullWords = 0, helfWords = 0, rowCount = 0, paraCount = 0;

		Iterator<String> iterStr = null;
		String current = new String();

		// 初始化 wordMap
		m5EnWordsTimes(wordMap, new StringTokenizer(pureWords));
		m5EnWordsTimes(fullWordMap, new StringTokenizer(fullStr));
		m5EnWordsTimes(helfWordMap, new StringTokenizer(helfStr));
		totalWords = m5EnWordsTotal(new StringTokenizer(pureWords));
		fullWords = m5EnWordsTotal(new StringTokenizer(fullStr));
		helfWords = m5EnWordsTotal(new StringTokenizer(helfStr));
		rowCount = m5EnWordsTotal(new StringTokenizer(str, "\n"));
		paraCount = m5EnWordsTotal(new StringTokenizer(str, "\r"));
		Set<String> maxSet = m5WordsMaxTimes(wordMap);
		Set<String> minSet = m5WordsMinTimes(wordMap);

		System.out.println("全形：" + fullWords);
		System.out.println("半形：" + helfWords);
		System.out.println("總字數：" + totalWords);
		System.out.println("標點符號數：" + symbols.length());
		System.out.println("行數：" + rowCount);
		System.out.println("段落數：" + paraCount);

		System.out.println("=== 每個單字出現次數 ===");
		iterStr = wordMap.keySet().iterator();
		while (iterStr.hasNext()) {
			current = iterStr.next();
			System.out.printf("%s: %d\n", current, wordMap.get(current));
		}

		System.out.println("=== 最常見的單字 ===");
		if (maxSet.isEmpty())
			System.out.println("沒有最常見的單字");
		else {
			iterStr = maxSet.iterator();
			while (iterStr.hasNext())
				System.out.println(iterStr.next());
		}

		System.out.println("=== 最罕見的單字 ===");
		if (minSet.isEmpty())
			System.out.println("沒有最罕見的單字");
		else {
			iterStr = minSet.iterator();
			while (iterStr.hasNext())
				System.out.println(iterStr.next());
		}
	}

	// 英文解析：總字數
	public static int m5EnWordsTotal(StringTokenizer token) {
		return token.countTokens();
	}

	// 英文解析：各字出現次數
	public static void m5EnWordsTimes(TreeMap<String, Integer> wordMap,
			StringTokenizer token) {
		String current = new String();

		while (token.hasMoreTokens()) {
			current = token.nextToken();
			wordMap.put(current,
					wordMap.containsKey(current) ? wordMap.get(current) + 1 : 1);
		}
	}

	// 最常見的單字
	public static Set<String> m5WordsMaxTimes(TreeMap<String, Integer> wordMap) {
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

	// 最罕見的單字
	public static Set<String> m5WordsMinTimes(TreeMap<String, Integer> wordMap) {
		int minTimes = Integer.MAX_VALUE;
		Set<String> resultSet = new TreeSet<String>();

		Iterator<String> iterStr = wordMap.keySet().iterator();
		String current = new String();

		while (iterStr.hasNext()) {
			current = iterStr.next();
			minTimes = wordMap.get(current) < minTimes ? wordMap.get(current)
					: minTimes;
		}

		if (minTimes <= 1) {
			iterStr = wordMap.keySet().iterator();
			while (iterStr.hasNext()) {
				current = iterStr.next();
				if (wordMap.get(current) == minTimes)
					resultSet.add(current);
			}
		}

		return resultSet;
	}

	// 中文解析
	// Dictionary -> com.chenlb.mmseg4j.Dictionary
	// 總字形數,各字出現次數,總字數,最常見/罕見字,標點符號數,段落數,行數等
	public static void m5ChtWords(String str) throws IOException {
		TreeMap<String, Integer> wordMap = new TreeMap<String, Integer>();
		Simple simple = new Simple();
		String fullPunctSet = "[[。、，：；『』「」（）《》〈〉—？！……﹏＿・～][\\s]]";
		String strSource = str.replaceAll("[\\s]+", ".");
		strSource = strSource.replaceAll(fullPunctSet, "").trim();
		strSource = strSource.replaceAll("\\p{Punct}", " ");
		String strResult = simple.segWords(strSource, " ");
		String[] strArray = strResult.replaceAll("\\s{2,}", " ").split("\\s");

		int fullWords = 0, helfWords = 0, totalWords = 0, totalSen = 0;
		int rowCount = 0, paraCount = 0, totalPuncts = 0;

		String current = new String();
		Iterator<String> iter = null;

		// 全形字
		String fullStr = str.replaceAll("[[\\u0020-\\u007E][\\n]]", "");

		// 半形字
		String helfStr = str.replaceAll("[[^\\u0000-\\u007E][\\n]]", " ")
				.replaceAll("\\s+", " ").trim();

		// 全形標點符號
		String onlyFullPunctStr = fullStr.replaceAll(
				"[^。、，：；『』「」（）《》〈〉—？！……﹏＿・～]", "").trim();

		// 半形標點符號
		String onlyHelfPunctStr = str.replaceAll("[^\\p{Punct}]", "");

		// 初始化
		m5ChtWordsTotal(wordMap, strArray);
		fullWords = fullStr.length();
		helfWords = helfStr.split("\\s").length;
		totalWords = fullWords + helfWords;
		totalSen = wordMap.size();
		rowCount = str.split("[\\n]").length;
		paraCount = str.split("[\\r]").length;
		totalPuncts = onlyFullPunctStr.length() + onlyHelfPunctStr.length();
		Set<String> maxSet = m5WordsMaxTimes(wordMap);
		Set<String> minSet = m5WordsMinTimes(wordMap);

		// 顯示統計量
		System.out.println("全形字：" + fullWords);
		System.out.println("半形字：" + helfWords);
		System.out.println("總字數：" + totalWords);
		System.out.println("總字詞數：" + totalSen);
		System.out.println("行數：" + rowCount);
		System.out.println("段落數：" + paraCount);
		System.out.println("標點符號數：" + totalPuncts);

		// 各單詞出現次數
		iter = wordMap.keySet().iterator();
		System.out.println("=== 各單詞出現次數 ===");
		while (iter.hasNext()) {
			current = iter.next();
			System.out.printf("%s: %d\n", current, wordMap.get(current));
		}

		System.out.println("=== 最常見的單詞 ===");
		if (maxSet.isEmpty())
			System.out.println("沒有最常見的單字");
		else {
			iter = maxSet.iterator();
			while (iter.hasNext())
				System.out.println(iter.next());
		}

		System.out.println("=== 最罕見的單詞 ===");
		if (minSet.isEmpty())
			System.out.println("沒有最罕見的單詞");
		else {
			iter = minSet.iterator();
			while (iter.hasNext())
				System.out.println(iter.next());
		}

	}

	// 各單詞量統計
	public static void m5ChtWordsTotal(TreeMap<String, Integer> wordMap,
			String[] strArray) {
		for (int i = 0; i < strArray.length; i++)
			wordMap.put(
					strArray[i],
					wordMap.containsKey(strArray[i]) ? wordMap.get(strArray[i]) + 1
							: 1);
	}
}

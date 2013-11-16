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
		System.out.printf("Recursive: 1 + 2 + ... + %d = %d\n", n, m1SumRecursive(n));
	}

	// 數字和 Loop
	public static int m1SumLoop(int n) {
		int result = 0;
		
		for (int i = 1; i <= n; i++)
			result += i;
		
		return result;
	}
	
	// 數字和 Recursive
	public static int m1SumRecursive(int n){
		return n == 1 ? 1 : n + m1SumRecursive(n - 1);
	}

}

/**
 *  
 請以亂數,分別自下面數列中,抽取50個數字,數字可重複抽取,

 統計每一個數是否大約出現10次.

 (a)  5, 6, 7, 8, 9

 (b) -1, 0, 2, 5, 9



(Sample Output)

(a) 50 numbers are 5, 8, 6, 7,...

    frequency of 5 is ?

    frequency of 6 is ?

    ...

(b) 50 numbers are 2, 9, -1, 0,...

    frequency of -1 is ?

    frequency of  0 is ?

    ...

 

 */
package ItorToComputers;
import java.util.*;

/**
 * @author PStar
 *
 */
public class S2HW01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random(1);
		
		
		
		for(int i = 0; i < 50; i++){
			System.out.printf("%d ", rand.nextInt(5) + 5);
		}
	}

}

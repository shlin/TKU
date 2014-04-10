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
		
//		(a) 50 numbers are 5, 8, 6, 7,...
//
//	    frequency of 5 is ?
//
//	    frequency of 6 is ?
//		...		
		randA();
		
//		(b) 50 numbers are 2, 9, -1, 0,...
//
//	    frequency of -1 is ?
//
//	    frequency of  0 is ?
//
//	    ...
		randB();
	}
	
	public static void randA(){
		Random rand = new Random();
		
		int numA = 0;
		int freq5 = 0;
		int freq6 = 0;
		int freq7 = 0;
		int freq8 = 0;
		int freq9 = 0;
		
		System.out.print("(a) 50 numbers are:");
		for(int i = 0; i < 50; i++){
			numA = rand.nextInt(5) + 5;
			
			switch(numA){
			case 5: freq5 ++; break;
			case 6: freq6 ++; break;
			case 7: freq7 ++; break;
			case 8: freq8 ++; break;
			case 9: freq9 ++; break;
			default: break;
			}
			
			System.out.printf(" %d%s", numA, i == 49 ? "\n" : ",");
		}
		
		System.out.printf("\tfrequency of  5 is %d\n", freq5);
		System.out.printf("\tfrequency of  6 is %d\n", freq6);
		System.out.printf("\tfrequency of  7 is %d\n", freq7);
		System.out.printf("\tfrequency of  8 is %d\n", freq8);
		System.out.printf("\tfrequency of  9 is %d\n", freq9);
	}

	public static void randB(){
		Random rand = new Random();
		
		int numB = 0;
		int freq_1 = 0;
		int freq0 = 0;
		int freq2 = 0;
		int freq5 = 0;
		int freq9 = 0;
		
		System.out.print("(b) 50 numbers are:");
		for(int i = 0; i < 50; i++){
			numB = rand.nextInt(5);
			
			switch(numB){
			case 0: numB = -1; freq_1 ++; break;
			case 1: numB = 0; freq0 ++; break;
			case 2: numB = 2; freq2 ++; break;
			case 3: numB = 5; freq5 ++; break;
			case 4: numB = 9; freq9 ++; break;
			default: break;
			}
			
			System.out.printf(" %d%s", numB, i == 49 ? "\n" : ",");
		}
		
		System.out.printf("\tfrequency of -1 is %d\n", freq_1);
		System.out.printf("\tfrequency of  0 is %d\n", freq0);
		System.out.printf("\tfrequency of  2 is %d\n", freq2);
		System.out.printf("\tfrequency of  5 is %d\n", freq5);
		System.out.printf("\tfrequency of  9 is %d\n", freq9);
	}
}

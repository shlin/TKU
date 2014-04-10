/**
 
請設計一程式檢查輸入的身份證代號是否正確.



提示:

1.public static boolean checkId(String id) // 正確回傳真,不正確回傳假

2.身份證代號共10碼(XS1234567C),檢查規則如下:

	X: 地區碼,範圍A-Z,所代表縣市,和其編碼數字如下:

		A 台北市 10	J 新竹縣 18	S 高雄縣 26	I 嘉義市 34

		B 台中市 11	K 苗栗縣 19	T 屏東縣 27	O 新竹市 35

		C 基隆市 12	L 台中縣 20	U 花蓮縣 28

		D 台南市 13	M 南投縣 21	V 台東縣 29

		E 高雄市 14	N 彰化縣 22	X 澎湖縣 30

		F 台北縣 15	P 雲林縣 23	Y 陽明山 31

		G 宜蘭縣 16	Q 嘉義縣 24	W 金門 32

		H 桃園縣 17	R 台南縣 25	Z 馬祖 33

	S: 性別碼,1表男性,2表女性

	1234567: 流水編號7碼

	C: 檢查碼,欄位1-9乘上加權數之總和,除以10之餘數,以10減之,即檢查碼.

   例如:

		   D  2  1  2  3  4  5  6  7  原代號

		1  3  2  1  2  3  4  5  6  7  編碼數字

		1  9  8  7  6  5  4  3  2  1  x 固定權數

		--------------------------------------

		1+27+16+ 7+12+15+16+15+12+ 7  =128

		其和為128,取個位數8,以10減之,為2,即檢查碼為2.

		故完整身份證代號應該為 D212345672.



3.由id字串拆解10代碼寫法:

   		//String id = scanner.next();

   		char id0 = id.charAt(0);

		int  id1 = id.charAt(1) - '0';

		int  id2 = id.charAt(2) - '0';

		.....

		int  id8 = id.charAt(8) - '0';

 */
package ItorToComputers;
import java.util.*;

/**
 * @author PStar
 *
 */
public class S2HW02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String id = new String();
		
		System.out.print("身分證字號：");
		while(input.hasNext("\\w\\d{9}")){
			id = input.next();
			
			System.out.printf("%s %s是正確的身分證字號\n\n", id, checkId(id) ? "" : "不");
			
			System.out.print("身分證字號：");
		}
	}
	
	public static boolean checkId(String id){
		int idArea = 0;
		int checkSum = 0;
		
		switch(id.charAt(0)){
		case 'A': idArea = 10; break;
		case 'B': idArea = 11; break;
		case 'C': idArea = 12; break;
		case 'D': idArea = 13; break;
		case 'E': idArea = 14; break;
		case 'F': idArea = 15; break;
		case 'G': idArea = 16; break;
		case 'H': idArea = 17; break;
		case 'J': idArea = 18; break;
		case 'K': idArea = 19; break;
		case 'L': idArea = 20; break;
		case 'M': idArea = 21; break;
		case 'N': idArea = 22; break;
		case 'P': idArea = 23; break;
		case 'Q': idArea = 24; break;
		case 'R': idArea = 25; break;
		case 'S': idArea = 26; break;
		case 'T': idArea = 27; break;
		case 'U': idArea = 28; break;
		case 'V': idArea = 29; break;
		case 'W': idArea = 30; break;
		case 'X': idArea = 31; break;
		case 'Y': idArea = 32; break;
		case 'Z': idArea = 33; break;
		case 'I': idArea = 34; break;
		case 'O': idArea = 35; break;
		default : break;
		}
		
		checkSum += idArea / 10 + idArea % 10 * 9;
		checkSum += (id.charAt(1) - '0' ) * 8;
		checkSum += (id.charAt(2) - '0' ) * 7;
		checkSum += (id.charAt(3) - '0' ) * 6;
		checkSum += (id.charAt(4) - '0' ) * 5;
		checkSum += (id.charAt(5) - '0' ) * 4;
		checkSum += (id.charAt(6) - '0' ) * 3;
		checkSum += (id.charAt(7) - '0' ) * 2;
		checkSum += (id.charAt(8) - '0' ) * 1;
		
		if(10 - checkSum % 10 == id.charAt(9) - '0' )
			return true;
		
		return false;
	}

}

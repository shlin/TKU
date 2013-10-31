package ST;

public class FlowEx {

	// (輸出練習) o1
	public static void o1() {
		System.out.println("1 2 3 4");
		System.out.print("1 2 3 4\n");
		System.out.printf("1 2 3 4\n");
		System.out.print("1 ");
		System.out.print("2 ");
		System.out.print("3 ");
		System.out.print("4\n");
	}

	// (輸出練習) o2
	public static void o2() {
		System.out.println("\t*******         ***           *           *");
		System.out.println("\t*     *       *     *        ***         * *");
		System.out.println("\t*     *      *       *      *****       *   *");
		System.out.println("\t*     *      *       *        *        *     *");
		System.out.println("\t*     *      *       *        *         *   *");
		System.out.println("\t*     *       *     *         *          * *");
		System.out.println("\t*******         ***           *           *");
	}

	// (輸出練習) o3
	public static void o3() {
		System.out.println("\t* * * * * * * *");
		System.out.println("\t * * * * * * * *");
		System.out.println("\t* * * * * * * *");
		System.out.println("\t * * * * * * * *");
		System.out.println("\t* * * * * * * *");
		System.out.println("\t * * * * * * * *");
		System.out.println("\t* * * * * * * *");
	}

	// (輸出練習) o4
	public static void o4() {
		System.out.println("數字\t平方\t立方");

		for (int i = 0; i <= 10; i++)
			System.out.println(i + "\t" + i * i + "\t" + i * i * i);
	}
}

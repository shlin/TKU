package ST;

public class DataEx {
	public static void d1List() {
		// New A Empty List
		DataExList newList = new DataExList();

		System.out.println("###### List ######");
		// Add
		System.out.println("###### 新增物件 ######");
		System.out.println("###### 原始List ######");
		newList.showList();

		newList.addLast(true);
		newList.addLast('A');
		newList.addLast(1000);
		newList.addLast("TEST");

		System.out.println("###### 結果List ######");
		newList.showList();

		// Remove First
		System.out.println("###### 由前刪除兩物件 ######");
		System.out.println("###### 原始List ######");
		newList.showList();

		System.out.println(">> 刪除: " + newList.removeFirst());
		System.out.println(">> 刪除: " + newList.removeFirst());

		System.out.println("###### 結果List ######");
		newList.showList();

		// Remove Last
		System.out.println("###### 由後刪除兩物件 ######");
		System.out.println("###### 原始List ######");
		newList.showList();

		System.out.println(">> 刪除: " + newList.removeLast());
		System.out.println(">> 刪除: " + newList.removeLast());

		System.out.println("###### 結果List ######");
		newList.showList();
	}

	public static void d2Stack() {
		DataExStack newStack = new DataExStack();

		System.out.println("###### Stack ######");
		// Push
		System.out.println("###### Push ######");
		System.out.println("###### 原始Stack ######");
		newStack.showStack();

		System.out.println(">> Push: " + newStack.push(true));
		System.out.println(">> Push: " + newStack.push('A'));
		System.out.println(">> Push: " + newStack.push(1000));
		System.out.println(">> Push: " + newStack.push("TEST"));

		System.out.println("###### 結果Stack ######");
		newStack.showStack();

		// Pop
		System.out.println("###### Pop ######");
		System.out.println("###### 原始Stack ######");
		newStack.showStack();

		System.out.println(">> Pop: " + newStack.pop());
		System.out.println("###### 結果Stack ######");
		newStack.showStack();

		System.out.println(">> Pop: " + newStack.pop());
		System.out.println("###### 結果Stack ######");
		newStack.showStack();
	}
}

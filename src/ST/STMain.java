package ST;

public class STMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void dataStructuresD1() {
		// New A Empty List
		List newList = new List();

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

}

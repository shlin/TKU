package ST;

/**
 * @author PStar
 * 
 *         Stack
 */
public class DataExStack {

	private int size = 0;
	private DataExNode head = null;

	public DataExStack() {
		size = 0;
	}

	public Object push(Object data) {
		DataExNode newNode = new DataExNode(data);

		if (head == null)
			head = newNode;
		else {
			newNode.next = head;
			head = newNode;
		}

		size++;

		return data;
	}

	public Object pop() {
		Object data = head.getData();
		
		head = head.next;
		
		size--;

		return data;
	}

	public void showStack() {
		DataExNode itor = head;
		int index = 0;

		System.out.println("<< Stack Nodes >>");
		while (itor != null && index < size) {
			System.out.println(index + " : " + itor.getData());
			itor = itor.next;

			index++;
		}

		if (size == 0)
			System.out.println("Stack is Empty!!\n");
		else
			System.out.println("Size = " + getSize() + "\n");
	}

	public int getSize() {
		return size;
	}
}

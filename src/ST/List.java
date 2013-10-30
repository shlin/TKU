package ST;

/**
 * @author PStar
 * 
 *         Double Linked List
 * 
 */
public class List {
	private int size = 0;

	public Node first = null;
	public Node last = null;

	public List(Object data) {
		this.first = new Node(data);
		size++;
	}

	public List() {
		size = 0;
	}

	public void addFirst(Object data) {
		Node newNode = new Node(data);

		if (first == null) {
			first = newNode;
		} else {
			newNode.next = first;
			first.prev = newNode;
			first = newNode;
		}

		size++;
	}

	public void addLast(Object data) {
		Node newNode = new Node(data);

		if (last == null) {
			last = newNode;
			if (first == null)
				first = last;
			else
				last.prev = first;
		} else {
			last.next = newNode;
			newNode.prev = last;
			last = newNode;
		}

		size++;
	}

	public void add(Object data) {
		addLast(data);
	}

	public Object removeFirst() {
		Object firstData = first.getData();

		first = first.next;
		if (first.prev == null)
			first.prev = null;

		size--;

		return firstData;
	}

	public Object removeLast() {
		Object lastData = last.getData();

		last = last.prev;
		if (last.next == null)
			last.next = null;

		size--;

		return lastData;
	}

	public void showList() {
		Node itor = first;
		int index = 0;

		System.out.println("<< List Nodes >>");
		while (itor != null && index < size) {
			System.out.println(index + " : " + itor.getData());
			itor = itor.next;

			index++;
		}

		if (size == 0)
			System.out.println("List is Empty!!\n");
		else
			System.out.println("Size = " + getSize() + "\n");
	}

	public int getSize() {
		return this.size;
	}

	public Node getFirst() {
		return this.first;
	}

	public Node getLast() {
		return this.last;
	}
}
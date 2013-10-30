package ST;


/**
 * @author PStar
 *
 */
public class List {
	private int size = 0;
	
	public Node first = null;
	public Node last = null;
	
	public List(Object data){
		this.first = new Node(data);
		size++;
	}
	
	public List(){
		size = 0;
	}
	
	public void addFirst(Object data){
		Node newNode = new Node(data);
		
		if(first == null){
			first = newNode;
		}else{
			newNode.next = first;
			first.prev = newNode;
			first = newNode;
		}
		
		size++;
	}
	
	public void addLast(Object data){
		Node newNode = new Node(data);
		
		if(first == null)
			addFirst(data);
		else if(last == null){
			last = newNode;
			last.prev = first;
		}else{
			last.next = newNode;
			newNode.prev = last;
			last = newNode;
		}
		
		size++;
	}
	
	public void showList(){
		Node itor = first;
		
		while(itor != null){
			System.out.println(itor.getData());
			itor = itor.next;
		}
		
		System.out.println("Size = " + getSize());
	}
	
	public int getSize(){
		return this.size;
	}
	
	public Node getFirst(){
		return this.first;
	}
	
	public Node getLast(){
		return this.last;
	}
}
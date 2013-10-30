package ST;

/**
 * @author PStar
 * List 使用的 Node
 *
 */
public class Node {
	private Object data = null;
	
	public Node next = null;
	public Node prev = null;
	
	public Node(Object o){
		setData(o);
	}
	
	public void setData(Object o){
		this.data = o;
	}
	
	public Object getData(){
		return data;
	}
}
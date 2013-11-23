package ST;

/**
 * @author PStar List 使用的 Node
 * 
 */
public class DataExNode {
	private Object data = null;

	public DataExNode next = null;
	public DataExNode prev = null;

	public DataExNode(Object o) {
		setData(o);
	}

	public void setData(Object o) {
		this.data = o;
	}

	public Object getData() {
		return data;
	}
}
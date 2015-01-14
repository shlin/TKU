package LogicGate;

import java.util.*;

public class Gate {
	private boolean boolState;
	private String method;
	private LinkedList<Integer> member;

	public Gate(boolean boolState) {
		this.boolState = boolState;
		this.method = "";
		this.member = new LinkedList<Integer>();
	}

	/**
	 * @return the boolState
	 */
	public boolean isBoolState() {
		return boolState;
	}

	/**
	 * @param boolState the boolState to set
	 */
	public void setBoolState(boolean boolState) {
		this.boolState = boolState;
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @return the member
	 */
	public LinkedList<Integer> getMember() {
		return member;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(LinkedList<Integer> member) {
		this.member = member;
	}
}

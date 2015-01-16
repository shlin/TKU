package LogicGate;

import java.util.*;

public class Gate {
	private String gateID;
	private boolean boolState;
	private boolean isInput;
	private boolean isOutput;
	private String method;
	private LinkedList<String> member;

	public Gate(String gateID, boolean boolState, boolean input, boolean output) {
		this.gateID = gateID;
		this.boolState = boolState;
		this.method = "";
		this.member = new LinkedList<String>();
		this.isInput = input;
		this.isOutput = output;
	}
	

	/**
	 * @return the gateID
	 */
	public String getGateID() {
		return gateID;
	}


	/**
	 * @return the isInput
	 */
	public boolean isInput() {
		return isInput;
	}

	/**
	 * @return the isOutput
	 */
	public boolean isOutput() {
		return isOutput;
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
	public LinkedList<String> getMember() {
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
	public void setMember(LinkedList<String> member) {
		this.member = member;
	}
}

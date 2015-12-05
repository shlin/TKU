package LogicGate;

import java.util.LinkedList;

public class Gate {
	private String gateId;
	private boolean boolStat;
	private boolean isInput;
	private boolean isOutput;
	private String stmtOperator;
	private LinkedList<String> stmtMember;

	public Gate(String id) {
		gateId = id;
		boolStat = false;
		isInput = false;
		isOutput = false;
		stmtOperator = new String();
		stmtMember = new LinkedList<String>();
	}

	/**
	 * @return the boolStat
	 */
	public boolean isBoolStat() {
		return boolStat;
	}

	/**
	 * @param boolStat the boolStat to set
	 */
	public void setBoolStat(boolean boolStat) {
		this.boolStat = boolStat;
	}

	/**
	 * @return the stmtOperator
	 */
	public String getStmtOperator() {
		return stmtOperator;
	}

	/**
	 * @param stmtOperator
	 *            the stmtOperator to set
	 */
	public void setStmtOperator(String stmtOperator) {
		this.stmtOperator = stmtOperator;
	}

	/**
	 * @return the stmtMember
	 */
	public LinkedList<String> getStmtMember() {
		return stmtMember;
	}

	public void addStmtMember(String member) {
		stmtMember.add(member);
	}

	/**
	 * @return the gateId
	 */
	public String getGateId() {
		return gateId;
	}

	/**
	 * @param gateId
	 *            the gateId to set
	 */
	public void setGateId(String gateId) {
		this.gateId = gateId;
	}

	/**
	 * @return the isInput
	 */
	public boolean isInput() {
		return isInput;
	}

	/**
	 * @param isInput
	 *            the isInput to set
	 */
	public void setInput(boolean isInput) {
		this.isInput = isInput;
	}

	/**
	 * @return the isOutput
	 */
	public boolean isOutput() {
		return isOutput;
	}

	/**
	 * @param isOutput
	 *            the isOutput to set
	 */
	public void setOutput(boolean isOutput) {
		this.isOutput = isOutput;
	}
}

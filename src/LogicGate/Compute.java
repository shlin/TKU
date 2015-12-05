package LogicGate;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Compute {
	private String inputStr;
	private LinkedHashMap<String, Gate> gatePool;

	public Compute(String inputStr, LinkedHashMap<String, Gate> gatePool) {
		this.inputStr = inputStr;
		this.gatePool = gatePool;
		this.parse();
	}

	public String doCompute() {
		// Compute
		gatePool.values().stream().filter(gate -> !gate.isInput()).forEach(gate -> gate.setBoolStat(compute(gate)));

		// Output String
		StringBuffer sb = new StringBuffer();
		gatePool.values().stream().filter(gate -> gate.isOutput())
				.forEach(gate -> sb.append(booleanToInt(gate.isBoolStat())));

		return sb.toString();
	}

	private void parse() {
		int[] index = { 0 };

		gatePool.values().parallelStream().filter(gate -> gate.isInput()).forEach(gate -> {
			gate.setBoolStat(charToBoolean(inputStr.charAt(index[0]++)));
		});
	}

	private boolean charToBoolean(char c) {
		return c == '1';
	}

	private int booleanToInt(boolean b) {
		return b ? 1 : 0;
	}

	private boolean compute(Gate gate) {
		if (gate.getStmtOperator().equals("buf")) {
			return buf(gate.getStmtMember());
		} else if (gate.getStmtOperator().equals("not")) {
			return not(gate.getStmtMember());
		} else if (gate.getStmtOperator().equals("and")) {
			return and(gate.getStmtMember());
		} else if (gate.getStmtOperator().equals("nand")) {
			return nand(gate.getStmtMember());
		} else if (gate.getStmtOperator().equals("or")) {
			return or(gate.getStmtMember());
		} else if (gate.getStmtOperator().equals("nor")) {
			return nor(gate.getStmtMember());
		} else if (gate.getStmtOperator().equals("xor")) {
			return xor(gate.getStmtMember());
		} else if (gate.getStmtOperator().equals("xnor")) {
			return xnor(gate.getStmtMember());
		}
		return false;
	}

	private boolean buf(LinkedList<String> member) {
		return gatePool.get(member.getFirst()).isBoolStat();
	}

	private boolean and(LinkedList<String> member) {
		return member.parallelStream().filter(gateId -> !gatePool.get(gateId).isBoolStat()).count() > 0 ? false : true;
	}

	private boolean or(LinkedList<String> member) {
		return member.parallelStream().filter(gateId -> gatePool.get(gateId).isBoolStat()).count() > 0 ? true : false;
	}

	private boolean xor(LinkedList<String> member) {
		boolean result = false;

		for (String gateId : member)
			result = result ^ gatePool.get(gateId).isBoolStat();

		return result;
	}

	private boolean not(LinkedList<String> member) {
		return !buf(member);
	}

	private boolean nand(LinkedList<String> member) {
		return !and(member);
	}

	private boolean nor(LinkedList<String> member) {
		return !or(member);
	}

	private boolean xnor(LinkedList<String> member) {
		return !xor(member);
	}
}

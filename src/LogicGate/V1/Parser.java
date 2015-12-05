package LogicGate.V1;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser extends Thread {
	private LinkedHashMap<String, Gate> gates = null;
	private Scanner bcInput = null;

	private Pattern pIgnor = Pattern.compile("^[^#].+");
	private Pattern pInput = Pattern.compile("INPUT\\((.+?)\\)");
	private Pattern pOutput = Pattern.compile("OUTPUT\\((.+?)\\)");
	private Pattern pStatement = Pattern.compile("(.+?)=(.+?)\\((.+?)\\)");
	private Matcher mIgnor = null;
	private Matcher mInput = null;
	private Matcher mOutput = null;
	private Matcher mStatement = null;

	private HashSet<String> outputSet = null;

	public Parser(Bench bench) throws FileNotFoundException {
		this.gates = bench.getLogicGates();
		this.bcInput = new Scanner(bench.getBenchFile());
		outputSet = new HashSet<String>();
	}

	public void run() {
		while (bcInput.hasNext()) {
			String gateID;
			mIgnor = pIgnor.matcher(bcInput.nextLine());
			if (mIgnor.find()) {
				String line = mIgnor.group().replaceAll("\\s", "");
				mInput = pInput.matcher(line);
				mOutput = pOutput.matcher(line);
				mStatement = pStatement.matcher(line);

				if (mInput.matches()) {
					gateID = mInput.group(1);
					gates.put(gateID, new Gate(gateID, false, true, false));
				} else if (mOutput.matches())
					outputSet.add(mOutput.group(1));
				else if (mStatement.matches()) {
					gateID = mStatement.group(1);
					gates.put(gateID, new Gate(gateID, false, false, outputSet.contains(gateID)));
					gates.get(gateID).setMethod(mStatement.group(2));
					gates.get(gateID).setMember(splitMember(mStatement.group(3)));
				}
			}
		}
	}

	private LinkedList<String> splitMember(String memberLine) {
		LinkedList<String> list = new LinkedList<String>();

		String[] gates = memberLine.split(",");

		for (int i = 0; i < gates.length; i++)
			list.add(gates[i]);
		return list;
	}
}

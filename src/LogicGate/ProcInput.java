package LogicGate;

import java.util.*;
import java.io.*;

public class ProcInput extends Thread {
	private Scanner input;
	private PrintStream output;
	private Bench bench;
	private LinkedList<LogicCompute> computes;
	private ComputeStore computeStore;
	private HashSet<String> needToCompute;

	public ProcInput(HashMap<String, LinkedHashMap<String, Gate>> gateLists,
			File input, File output, Bench bench) throws FileNotFoundException {
		this.input = new Scanner(input);
		this.output = new PrintStream(output);
		this.bench = bench;
		computes = new LinkedList<LogicCompute>();
		this.computeStore = new ComputeStore(gateLists);
		this.needToCompute = new HashSet<String>();
	}

	public void run() {
		int currentIndex = 1;
		LinkedHashMap<String, Gate> newGateList;
		while (input.hasNext()) {
			String inputSrcStr = input.next();
			newGateList = cloneGateList(bench.getLogicGates());
			this.computeStore.addInputString(currentIndex++, inputSrcStr);
			if (!this.computeStore.isContains(inputSrcStr)) {
				this.needToCompute.add(inputSrcStr);
				this.computeStore.addGateList(inputSrcStr,
						inputToGates(inputSrcStr, newGateList));
			}
		}

		try {
			if (!needToCompute.isEmpty()) {
				System.out.println("Compute:" + bench.getBenchID() + "\tComputes:" + needToCompute.size());
				Iterator<String> computeItor = needToCompute.iterator();
				while (computeItor.hasNext()) {
					String computeStr = computeItor.next();
					computes.add(new LogicCompute(this.computeStore
							.getGateList(computeStr)));
					computes.getLast().start();
				}
				computes.getLast().join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			for (int i = 1; i <= this.computeStore.getInputSize(); i++)
				output.println(this.computeStore.getOutputString(i));
		}
	}

	public LinkedHashMap<String, Gate> cloneGateList(
			LinkedHashMap<String, Gate> src) {
		LinkedHashMap<String, Gate> newGateList = new LinkedHashMap<String, Gate>();
		Iterator<Gate> gateItor = bench.getLogicGates().values().iterator();
		while (gateItor.hasNext()) {
			Gate current = gateItor.next();
			Gate newGate = new Gate(current.getGateID(), current.isBoolState(),
					current.isInput(), current.isOutput());
			newGate.setMember(current.getMember());
			newGate.setMethod(current.getMethod());
			newGateList.put(newGate.getGateID(), newGate);
		}
		return newGateList;
	}

	public LinkedHashMap<String, Gate> inputToGates(String inputStr,
			LinkedHashMap<String, Gate> gates) {
		int index = 0;
		Iterator<Gate> gateItor = gates.values().iterator();
		while (gateItor.hasNext()) {
			Gate current = gateItor.next();
			if (current.isInput())
				current.setBoolState(inputStr.charAt(index++) == '1' ? true
						: false);
		}
		return gates;
	}
}

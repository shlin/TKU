package LogicGate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bench {
	private int benchId;
	private File benchFile;
	private LinkedHashMap<String, Gate> gatePool;
	private HashMap<String, String> computedPool;

	public Bench(File file) {
		this.benchFile = file;
		this.benchId = initBenchId();
		this.gatePool = new LinkedHashMap<String, Gate>();
		this.computedPool = new HashMap<String, String>();
		this.parse();
	}

	private void parse() {
		// TODO Auto-generated method stub
		Matcher matcher;
		String currentLine;
		Pattern inputPattern = Pattern.compile("INPUT\\((.+?)\\)");
		Pattern outputPattern = Pattern.compile("OUTPUT\\((.+?)\\)");
		Pattern statmentPattern = Pattern.compile("(.+?)=(.+?)\\((.+?)\\)");

		try {
			Scanner input = new Scanner(this.benchFile);
			HashMap<String, Gate> tmpOutputGateMap = new HashMap<String, Gate>();

			while (input.hasNext()) {
				currentLine = input.nextLine();
				if (!currentLine.startsWith("#")) {
					currentLine = currentLine.replaceAll("\\s", "");
					if (currentLine.startsWith("INPUT")) {
						matcher = inputPattern.matcher(currentLine);
						if (matcher.find()) {
							Gate newGate = new Gate(matcher.group(1));
							newGate.setInput(true);
							gatePool.put(matcher.group(1), newGate);
						}
					} else if (currentLine.startsWith("OUTPUT")) {
						matcher = outputPattern.matcher(currentLine);
						if (matcher.find()) {
							Gate newGate = new Gate(matcher.group(1));
							newGate.setOutput(true);
							tmpOutputGateMap.put(matcher.group(1), newGate);
						}
					} else if (currentLine.startsWith("G")) {
						matcher = statmentPattern.matcher(currentLine);
						if (matcher.find()) {
							Gate newGate;
							if (tmpOutputGateMap.containsKey(matcher.group(1))) {
								newGate = tmpOutputGateMap.get(matcher.group(1));
							} else {
								newGate = new Gate(matcher.group(1));
							}
							newGate.setStmtOperator(matcher.group(2));
							for (String member : matcher.group(3).split(","))
								newGate.getStmtMember().add(member);
							gatePool.put(matcher.group(1), newGate);
						}
					}
				}
			}

			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int initBenchId() {
		Matcher m = Pattern.compile("c(\\d+?)\\.").matcher(benchFile.getName());

		if (m.find()) {
			return Integer.parseInt(m.group(1));
		}

		return 0;
	}

	public int getBenchId() {
		return this.benchId;
	}

	/**
	 * @return the gatePool
	 */
	public LinkedHashMap<String, Gate> getGatePool() {
		return gatePool;
	}

	/**
	 * @return the computedPool
	 */
	public HashMap<String, String> getComputedPool() {
		return computedPool;
	}
}

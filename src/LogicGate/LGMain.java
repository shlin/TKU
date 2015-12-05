package LogicGate;

import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LGMain {
	private static File dirBench = new File("exInputFile/LogicGate/Bench");
	private static File dirInput = new File("exInputFile/LogicGate/Input");
	private static File dirOutput = new File("exInputFile/LogicGate/Output");

	private static HashMap<Integer, Bench> benchs = new HashMap<Integer, Bench>();
	private static HashMap<Integer, LinkedList<Input>> inputs = new HashMap<Integer, LinkedList<Input>>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// long start = System.currentTimeMillis();
		// Read bench files
		Arrays.asList(dirBench.listFiles()).parallelStream()
				.filter(benchFile -> benchFile.getName().endsWith(".bench.txt")).forEach(benchFile -> {
					Bench currentBench = new Bench(benchFile);
					benchs.put(currentBench.getBenchId(), currentBench);
				});

		// Read input files
		Arrays.asList(dirInput.listFiles()).parallelStream().filter(inputFile -> inputFile.getName().endsWith(".ip"))
				.forEach(inputFile -> {
					Input currentInput = new Input(inputFile);
					if (!inputs.containsKey(currentInput.getBenchId())) {
						LinkedList<Input> newInputList = new LinkedList<Input>();
						inputs.put(currentInput.getBenchId(), newInputList);
					}
					inputs.get(currentInput.getBenchId()).add(currentInput);
				});

		// System.out.println(System.currentTimeMillis() - start);
		// Compute
		inputs.forEach((benchId, inputList) -> {
			inputList.forEach(input -> {
				try {
					PrintStream output = new PrintStream(new File(
							dirOutput.getAbsolutePath() + "/" + input.getInputFile().getName().replace("ip", "out")));
					StringBuffer sb = new StringBuffer();

					input.getInputList().parallelStream().forEach(inputStr -> {
						if (!benchs.get(benchId).getComputedPool().containsKey(inputStr)) {
							Compute compute = new Compute(inputStr, cloneGatePool(benchs.get(benchId).getGatePool()));
							benchs.get(benchId).getComputedPool().put(inputStr, compute.doCompute());
						}
						sb.append(String.format("%s\t%s\n", inputStr,
								benchs.get(benchId).getComputedPool().get(inputStr)));
					});

					output.print(sb.toString());
					output.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					System.out.println(input.getInputFile().getName() + " : done!");
				}
			});
			benchs.get(benchId).getComputedPool().clear();
		});
	}

	public static LinkedHashMap<String, Gate> cloneGatePool(LinkedHashMap<String, Gate> gatePool) {
		LinkedHashMap<String, Gate> newPool = new LinkedHashMap<String, Gate>();

		gatePool.values().forEach(currentGate -> {
			Gate newGate = new Gate(currentGate.getGateId());
			newGate.setBoolStat(currentGate.isBoolStat());
			newGate.setInput(currentGate.isInput());
			newGate.setOutput(currentGate.isOutput());
			newGate.setStmtOperator(currentGate.getStmtOperator());
			currentGate.getStmtMember().forEach(member -> {
				newGate.addStmtMember(member);
			});
			newPool.put(newGate.getGateId(), newGate);
		});

		return newPool;
	}

}

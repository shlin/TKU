package LogicGate;

import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LGMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String outputDir = "exInputFile/LogicGate/Output";
		HashMap<Integer, Bench> benchs = new HashMap<Integer, Bench>();
		HashMap<Integer, LinkedList<Input>> inputs = new HashMap<Integer, LinkedList<Input>>();

		// Read bench files
		Arrays.asList(new File("exInputFile/LogicGate/Bench").listFiles()).parallelStream()
				.filter(benchFile -> benchFile.getName().endsWith(".bench.txt")).forEach(benchFile -> {
					Bench currentBench = new Bench(benchFile);
					benchs.put(currentBench.getBenchId(), currentBench);
					currentBench = null;
				});

		// Read input files
		Arrays.asList(new File("exInputFile/LogicGate/Input").listFiles()).parallelStream()
				.filter(inputFile -> inputFile.getName().endsWith(".ip")).forEach(inputFile -> {
					Input currentInput = new Input(inputFile);
					if (!inputs.containsKey(currentInput.getBenchId())) {
						LinkedList<Input> newInputList = new LinkedList<Input>();
						inputs.put(currentInput.getBenchId(), newInputList);
					}
					inputs.get(currentInput.getBenchId()).add(currentInput);
					currentInput = null;
				});

		// Compute
		inputs.forEach((benchId, inputFiles) -> {
			Bench bench = benchs.get(benchId);

			inputFiles.forEach(input -> {
				try {
					PrintStream ps = new PrintStream(
							outputDir + "/" + input.getInputFile().getName().replace("ip", "out"));

					input.getInputList().parallelStream()
							.filter(inputStr -> !bench.getComputedPool().containsKey(inputStr)).forEach(inputStr -> {
						bench.getComputedPool().put(inputStr,
								new Compute(inputStr, cloneGatePool(bench.getGatePool())).doCompute());
					});
					
					input.getInputList().forEach(inputStr -> {
						ps.printf("%s\t%s\n", inputStr, bench.getComputedPool().get(inputStr));
					});
					
					ps.close();
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

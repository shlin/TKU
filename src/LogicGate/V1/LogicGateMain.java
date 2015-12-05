package LogicGate.V1;

import java.io.*;
import java.util.*;

public class LogicGateMain {
	private static TreeMap<Integer, Bench> benchFiles = new TreeMap<Integer, Bench>();
	private static TreeMap<Integer, Input> inputFiles = new TreeMap<Integer, Input>();

	private static File dirBench = new File("exInputFile/LogicGate/Bench");
	private static File dirInput = new File("exInputFile/LogicGate/Input");
	private static File dirOutput = new File("exInputFile/LogicGate/Output");

	private static LinkedList<Parser> parserList = new LinkedList<Parser>();
	private static LinkedList<ProcInput> loaderList;

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		// TODO Auto-generated method stub

		// Setting Benchs
		// Read Directory File List
		ListDir benchList = new ListDir(true, dirBench);
		benchFiles = benchList.getBenchList();
		Iterator<Bench> benchItor = benchFiles.values().iterator();

		while (benchItor.hasNext()) {
			Parser newParser = new Parser(benchItor.next());
			newParser.start();
			parserList.add(newParser);
		}

		parserList.getLast().join();

		// Load Input Files
		ListDir inputList = new ListDir(dirInput);
		inputFiles = inputList.getInputList();

		Iterator<Input> inputItor = inputFiles.values().iterator();
		while (inputItor.hasNext()) {
			HashMap<String, LinkedHashMap<String, Gate>> gateLists = new HashMap<String, LinkedHashMap<String, Gate>>();
			loaderList = new LinkedList<ProcInput>();
			Input newInput = inputItor.next();
			Iterator<File> inputFileItor = newInput.getInputMap().values().iterator();
			while (inputFileItor.hasNext()) {
				File srcFile = inputFileItor.next();
				File dstFile = new File(dirOutput.getAbsolutePath() + "/" + srcFile.getName().replace("ip", "out"));
				ProcInput loader = new ProcInput(gateLists, srcFile, dstFile, benchFiles.get(newInput.getBenchID()));
				loaderList.add(loader);
				long start = System.currentTimeMillis();
				loaderList.getLast().start();
				loaderList.getLast().join();
				long procTime = System.currentTimeMillis() - start;
				System.out.println(srcFile.getName() + " Proc. Time: " + procTime);
			}
		}
	}

}

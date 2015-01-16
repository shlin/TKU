package LogicGate;

import java.io.*;
import java.util.*;

public class LogicGateMain {
	private static TreeMap<Integer, Bench> benchFiles = new TreeMap<Integer, Bench>();

	private static File dirBench = new File("exInputFile/LogicGate/Bench");
	private static LinkedList<Parser> parserList = new LinkedList<Parser>();

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		
		// Setting Benchs
		// Read Directory File List
		ListDir list = new ListDir(dirBench);
		benchFiles = list.getFileList();
		
		Iterator<Bench> benchItor = benchFiles.values().iterator();
		
		while(benchItor.hasNext()){
			Parser newParser = new Parser(benchItor.next());
			newParser.start();
			parserList.add(newParser);
		}
		
		parserList.getLast().join();
		
	}

}

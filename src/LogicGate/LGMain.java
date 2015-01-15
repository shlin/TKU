package LogicGate;

import java.io.*;
import java.util.*;

public class LGMain {
	private static TreeMap<Integer, Gate> gates = new TreeMap<Integer, Gate>();

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String srcLine = "";
		Scanner input = new Scanner(new File("exInputFile/LogicGate/Input/c17-100k.ip"));
		PrintStream out = new PrintStream(new File("exInputFile/LogicGate/Input/c17-100k.out"));
		
		
		Iterator<Integer> itorInt;
		Iterator<Gate> itorGate;
		
		BenchParser baC17 = new BenchParser(new Scanner(new File("exInputFile/LogicGate/Bench/c17.bench.txt")), gates);
		while(input.hasNext()){
			srcLine = input.next();
			itorInt = baC17.getInputGates().iterator();
			
			int i = 0;
			while(itorInt.hasNext())
				gates.get(itorInt.next()).setBoolState(srcLine.charAt(i++) == '1' ? true : false);
			
			itorInt = gates.keySet().iterator();
			while(itorInt.hasNext()){
				int tmpID = itorInt.next();
				if(!baC17.getInputGates().contains(tmpID)){
					boolean tmpResult = false;
					LinkedList<Integer> tmpList = gates.get(tmpID).getMember();
					LinkedList<Boolean> tmpBoolList = new LinkedList<Boolean>();
					for(int listIndex = 0; listIndex < tmpList.size() - 1; listIndex++)
						tmpBoolList.add(gates.get(tmpList.get(listIndex)).isBoolState());
					
//						tmpResult = LogicCompute.NAND(listIndex == 0 ? gates.get(tmpList.get(listIndex)).isBoolState() : tmpResult, gates.get(tmpList.get(listIndex + 1)).isBoolState());
					gates.get(tmpID).setBoolState(LogicCompute.NAND(tmpBoolList));
				}
			}
			
			itorInt = baC17.getOutputGates().iterator();
			itorGate = gates.values().iterator();
			while(itorInt.hasNext())
				out.print(gates.get(itorInt.next()).isBoolState() ? "1" : "0");
			
			out.println();
		}
	}

}

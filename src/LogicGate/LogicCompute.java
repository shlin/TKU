package LogicGate;

import java.util.*;

public class LogicCompute {
	public static boolean AND(LinkedList<Boolean> input) {
		boolean result = true;

		for (int i = 0; i < input.size(); i++)
			result = Boolean.logicalAnd(result, input.get(i));
		
		return result;
	}
	
	public static boolean OR(LinkedList<Boolean> input) {
		boolean result = false;

		for (int i = 0; i < input.size(); i++)
			result = Boolean.logicalOr(result, input.get(i));
		
		return result;
	}
	
	public static boolean XOR(LinkedList<Boolean> input) {
		boolean result = false;

		for (int i = 0; i < input.size(); i++)
			result = Boolean.logicalXor(result, input.get(i));
		
		return result;
	}

	public static boolean NAND(LinkedList<Boolean> input) {
		return !AND(input);
	}
	
	public static boolean NOR(LinkedList<Boolean> input){
		return !OR(input);
	}
	
	public static boolean XNOR(LinkedList<Boolean> input){
		return !XOR(input);
	}
}

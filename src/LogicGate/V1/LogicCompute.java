package LogicGate.V1;

import java.util.*;

public class LogicCompute extends Thread {	
	private LinkedHashMap<String, Gate> gateList;
	
	public LogicCompute(LinkedHashMap<String, Gate> gateList){
		this.gateList = gateList;
	}
	
	public void run(){
		Iterator<Gate> gateItor = gateList.values().iterator();
		while(gateItor.hasNext()){
			Gate newGate = gateItor.next();
			if(!newGate.isInput()){
				LinkedList<Boolean> boolInput = new LinkedList<Boolean>();
				for(String gateID: newGate.getMember())
					boolInput.add(gateList.get(gateID).isBoolState());
				if(newGate.getMethod().matches("buf"))
					newGate.setBoolState(BUFFER(boolInput));
				else if(newGate.getMethod().matches("not"))
					newGate.setBoolState(NOT(boolInput));
				else if(newGate.getMethod().matches("nand"))
					newGate.setBoolState(NAND(boolInput));
				else if(newGate.getMethod().matches("nor"))
					newGate.setBoolState(NOR(boolInput));
				else if(newGate.getMethod().matches("xnor"))
					newGate.setBoolState(XNOR(boolInput));
				else if(newGate.getMethod().matches("xor"))
					newGate.setBoolState(XOR(boolInput));
				else if(newGate.getMethod().matches("and"))
					newGate.setBoolState(AND(boolInput));
				else if(newGate.getMethod().matches("or"))
					newGate.setBoolState(OR(boolInput));
			}
		}
	}
	
	public boolean AND(LinkedList<Boolean> input) {
		boolean result = true;

		for (int i = 0; i < input.size(); i++)
			result = result & input.get(i);
//			result = Boolean.logicalAnd(result, input.get(i));
		
		return result;
	}
	
	public boolean OR(LinkedList<Boolean> input) {
		boolean result = false;

		for (int i = 0; i < input.size(); i++)
			result = result | input.get(i);
//			result = Boolean.logicalOr(result, input.get(i));
		
		return result;
	}
	
	public boolean XOR(LinkedList<Boolean> input) {
		boolean result = false;

		for (int i = 0; i < input.size(); i++)
			result = result ^ input.get(i);
//			result =  Boolean.logicalXor(result, input.get(i));
		
		return result;
	}
	
	public boolean BUFFER(LinkedList<Boolean> input) {
		return input.getFirst();
	}
	
	public boolean NOT(LinkedList<Boolean> input){
		return !input.getFirst();
	}

	public boolean NAND(LinkedList<Boolean> input) {
		return !AND(input);
	}
	
	public boolean NOR(LinkedList<Boolean> input){
		return !OR(input);
	}
	
	public boolean XNOR(LinkedList<Boolean> input){
		return !XOR(input);
	}
}

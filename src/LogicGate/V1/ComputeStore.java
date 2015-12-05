package LogicGate.V1;

import java.util.*;

public class ComputeStore {
	private TreeMap<Integer, String> inputSrcString;
	private HashMap<String, LinkedHashMap<String, Gate>> gateLists;
	
	public ComputeStore(HashMap<String, LinkedHashMap<String, Gate>> gateLists){
		this.inputSrcString = new TreeMap<Integer, String>();
		this.gateLists = gateLists;
	}
	
	public String getOutputString(int index){
		String output = inputSrcString.get(index) + "\t";
		Iterator<Gate> gateItor = gateLists.get(inputSrcString.get(index)).values().iterator();
		while(gateItor.hasNext()){
			Gate newGate = gateItor.next();
			if(newGate.isOutput())
				output += newGate.isBoolState() ? 1 : 0;
		}
		return output;
	}
	
	public int getInputSize(){
		return this.inputSrcString.size();
	}
	
	public int getGateListSize(){
		return this.gateLists.size();
	}
	
	public LinkedHashMap<String, Gate> getGateList(String srcStr){
		return gateLists.get(srcStr);
	}
	
	public void addInputString(int index, String srcStr){
		this.inputSrcString.put(index, srcStr);
	}
	
	public boolean isContains(String srcStr){
		return gateLists.containsKey(srcStr);
	}
	
	public void addGateList(String srcStr, LinkedHashMap<String, Gate> gateList){
		if(!gateLists.containsKey(srcStr))
			this.gateLists.put(srcStr, gateList);
	}
}

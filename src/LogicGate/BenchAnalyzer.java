package LogicGate;

import java.util.*;
import java.util.regex.*;

public class BenchAnalyzer {
	private Scanner input;
	
	private TreeSet<Integer> inputGates = new TreeSet<Integer>();
	private TreeSet<Integer> outputGates = new TreeSet<Integer>();
	private TreeMap<Integer, Gate> mapGates = null;
	
	private Pattern pIgnor = Pattern.compile("^[^#].+");
	private Pattern pInput = Pattern.compile("INPUT\\(G(\\d+?)gat\\)");
	private Pattern pOutput = Pattern.compile("OUTPUT\\(G(\\d+?)gat\\)");
	private Pattern pStatement = Pattern.compile("G(\\d+?)gat=(.+?)\\((.+?)\\)");
	private Matcher mIgnor = null;
	private Matcher mInput = null;
	private Matcher mOutput = null;
	private Matcher mStatement = null;

	public BenchAnalyzer(Scanner input, TreeMap<Integer, Gate> gates) {
		this.input = input;
		this.mapGates = gates;
		analyzer();
//		debugPrint();
	}
	
//	INPUT(G1gat)
//	INPUT(G2gat)
//	INPUT(G3gat)
//	INPUT(G6gat)
//	INPUT(G7gat)
//	OUTPUT(G22gat)
//	OUTPUT(G23gat)
//	G10gat = nand(G1gat, G3gat)
//	G11gat = nand(G3gat, G6gat)
//	G16gat = nand(G2gat, G11gat)
//	G19gat = nand(G11gat, G7gat)
//	G22gat = nand(G10gat, G16gat)
//	G23gat = nand(G16gat, G19gat)

	
	void analyzer(){
		int gateID = 0;
		
		while(input.hasNextLine()){
			mIgnor = pIgnor.matcher(input.nextLine());
			if(mIgnor.find()){
				
				String line = mIgnor.group().replaceAll("\\s", "");
				mInput = pInput.matcher(line);
				mOutput = pOutput.matcher(line);
				mStatement = pStatement.matcher(line);
				
				// Proc. INPUT
				if(mInput.find()){
					gateID = Integer.parseInt(mInput.group(1));
					inputGates.add(gateID);
					mapGates.put(gateID, new Gate(false));
				}else if(mOutput.find()){ // Proc. OUTPUT
					gateID = Integer.parseInt(mOutput.group(1));
					outputGates.add(gateID);
					mapGates.put(gateID, new Gate(false));
				}else if(mStatement.find()){// Proc. STATEMENT
					gateID = Integer.parseInt(mStatement.group(1));
					if(!outputGates.contains(gateID))
						mapGates.put(gateID, new Gate(false));
					mapGates.get(gateID).setMethod(mStatement.group(2));
					mapGates.get(gateID).setMember(splitMember(mStatement.group(3)));
				}
			}
		}
	}
	
	private LinkedList<Integer> splitMember(String memberLine){
		LinkedList<Integer> list = new LinkedList<Integer>();
		Pattern p = Pattern.compile("G(\\d+?)gat");
		Matcher m = null;
		
		String[] gates = memberLine.split(",");
		
		for(int i = 0; i < gates.length; i++){
			m = p.matcher(gates[i]);
			if(m.find())
				list.add(Integer.parseInt(m.group(1)));
		}
		return list;
	}
	
	void debugPrint(){
		Iterator<Gate> itor = mapGates.values().iterator();
		while(itor.hasNext())
			System.out.println(itor.next().getMethod());
	}

	/**
	 * @return the inputGates
	 */
	public TreeSet<Integer> getInputGates() {
		return inputGates;
	}

	/**
	 * @return the outputGates
	 */
	public TreeSet<Integer> getOutputGates() {
		return outputGates;
	}

	/**
	 * @return the mapGates
	 */
	public TreeMap<Integer, Gate> getMapGates() {
		return mapGates;
	}
}

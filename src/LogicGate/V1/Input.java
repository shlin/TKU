package LogicGate.V1;

import java.util.*;
import java.io.*;

public class Input {
	private int benchID;
	private TreeMap<Integer, File> inputMap;
	
	public Input(int benchID){
		this.benchID = benchID;
		inputMap = new TreeMap<Integer, File>();
	}

	/**
	 * @return the benchID
	 */
	public int getBenchID() {
		return benchID;
	}

	/**
	 * @return the inputMap
	 */
	public TreeMap<Integer, File> getInputMap() {
		return inputMap;
	}
	
}

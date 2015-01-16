package LogicGate;

import java.io.*;
import java.util.*;

public class Bench {
	private int benchID;
	private File benchFile;
	private LinkedHashMap<String, Gate> logicGates;
	
	public Bench(int id, File file){
		this.benchID = id;
		this.benchFile = file;
		this.logicGates = new LinkedHashMap<String, Gate>();
	}

	/**
	 * @return the logicGates
	 */
	public LinkedHashMap<String, Gate> getLogicGates() {
		return logicGates;
	}

	/**
	 * @return the benchID
	 */
	public int getBenchID() {
		return benchID;
	}

	/**
	 * @return the benchFile
	 */
	public File getBenchFile() {
		return benchFile;
	}
	
	
}

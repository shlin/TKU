package LogicGate.V1;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ListDir {
	private File input;
	private TreeMap<Integer, Bench> benchList;
	private TreeMap<Integer, Input> inputList;
	
	private Pattern pBFilename = Pattern.compile("c(\\d+?)\\.bench\\.txt$");
	private Pattern pIFilename = Pattern.compile("^c(.+?)-(.+?)k\\.ip$");

	public ListDir(File input){
		this.input = input;
		inputList = new TreeMap<Integer, Input>();
	}
	
	public ListDir(boolean isBench, File input){
		this.input = input;
		benchList = new TreeMap<Integer, Bench>();
	}
	
	public TreeMap<Integer, Input> getInputList(){
		if(input.isDirectory()){
			String[] tmpList = input.list();
			for(int i = 0; i < tmpList.length; i++){
				Matcher m = pIFilename.matcher(tmpList[i]);
				if(m.matches()){
					int benchID = Integer.parseInt(m.group(1));
					if(inputList.containsKey(benchID)){
						inputList.get(benchID).getInputMap().put(Integer.parseInt(m.group(2)), new File(input.getAbsolutePath() + "/" + m.group()));
					}else{
						Input newInput = new Input(benchID);
						newInput.getInputMap().put(Integer.parseInt(m.group(2)), new File(input.getAbsolutePath() + "/" + m.group()));
						inputList.put(benchID, newInput);
					}
				}
			}
		}
		return inputList;
	}
	
	public TreeMap<Integer, Bench> getBenchList(){
		if(input.isDirectory()){
			String[] tmpList = input.list();
			for(int i = 0; i < tmpList.length; i++){
				String tmpFileName = tmpList[i];
				Matcher m = pBFilename.matcher(tmpFileName);
				if(m.matches()){
					Bench newBench = new Bench(Integer.parseInt(m.group(1)), new File(input.getAbsolutePath() + "/" + m.group()));
					benchList.put(newBench.getBenchID(), newBench);
					newBench = null;
				}
			}
		}
		return benchList;
	}
}

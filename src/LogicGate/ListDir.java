package LogicGate;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ListDir {
	private File dirBench;
	private TreeMap<Integer, Bench> filesBench;
	
	private Pattern pFilename = Pattern.compile("c(\\d+?)\\.bench\\.txt$");

	public ListDir(File dirBench){
		this.dirBench = dirBench;
		filesBench = new TreeMap<Integer, Bench>();
	}
	
	public TreeMap<Integer, Bench> getFileList(){
		if(dirBench.isDirectory()){
			String[] tmpList = dirBench.list();
			for(int i = 0; i < tmpList.length; i++){
				String tmpFileName = tmpList[i];
				Matcher m = pFilename.matcher(tmpFileName);
				if(m.find()){
					Bench newBench = new Bench(Integer.parseInt(m.group(1)), new File(dirBench.getAbsolutePath() + "/" + m.group()));
					filesBench.put(newBench.getBenchID(), newBench);
					newBench = null;
				}
			}
		}
		return filesBench;
	}
}

package FinalProject; 

import java.util.*;
import java.io.*;
import java.util.regex.*;

public class PlayListPool {
	private HashMap<Integer, ListRec> listMap;
	
	public PlayListPool() throws IOException{
		 this.initMap();
	}
	
	private void initMap() throws IOException{
		File finput = new File("list.txt");
		listMap = new HashMap<Integer, ListRec>();
		listMap.put(0, new ListRec("＝＝＝＝＝＝ Youtube 播放清單 ＝＝＝＝＝＝", ""));
		if(!finput.exists()){
			listMap.put(1, new ListRec("＝＝＝＝＝＝＞ BY2", "http://www.youtube.com/embed/fNJSUT97NZk?list=PLB27E983B2D5BC4C4"));
			listMap.put(2, new ListRec("＝＝＝＝＝＝＞ 五月天", "http://www.youtube.com/embed/_o0oeyCtoFA?list=PL9DFDD7E9C684961D"));
			
		}else{
			Scanner input = new Scanner(finput);
			while(input.hasNext()){
				String strSrc = input.next();
				Pattern p = Pattern.compile("^(.+?)：(.+?)$");
				Matcher m = p.matcher(strSrc);
				
				if(m.matches()){
					System.out.println(m.group(0));
					listMap.put(listMap.size(), new ListRec(" ＞＞＞ " + m.group(1), m.group(2)));
				}
			}
		}
		listMap.put(listMap.size(), new ListRec("＝＝＝＝＝＝！！！ END ！！！＝＝＝＝＝＝", ""));
		
	}
	
	public String getURL(int index){
		return listMap.get(index).getURL();
	}
	
	public int getEndIndex(){
		return listMap.size() - 1;
	}
	
	public String[] initListView(){
		int i = 0;
		
		String[] result = new String[listMap.size()];
		Iterator<ListRec> newIter = listMap.values().iterator();
		
		while(newIter.hasNext())
			result[i++] = newIter.next().getName();
		
		return result;
	}
}

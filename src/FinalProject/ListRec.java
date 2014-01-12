package FinalProject;

public class ListRec {
	private String strListName;
	private String strURL;
	
	public  ListRec(String name, String url){
		this.strListName = name;
		this.strURL = url;
	}
	
	public String getName(){
		return strListName;
	}
	
	public String getURL(){
		return strURL;
	}
}

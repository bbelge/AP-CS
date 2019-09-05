package dome;

public class Disk {
	protected double playTime;
	protected boolean gotit;
	protected String comment;
	
	public Disk(){
		playTime = 0;
		gotit = false;
		comment = "";
	}
	
	public void setComment(String c){
		comment = c;
	}
	
	public String getComment(){
		return comment;
	}
	
	public void setGotit(boolean g){
		gotit = g;
	}
	
	public boolean getGotit(){
		return gotit;
	}
}

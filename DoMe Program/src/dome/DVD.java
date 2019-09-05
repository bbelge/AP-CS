package dome;
import java.text.DecimalFormat;

import BreezySwing.Format;
public class DVD extends Disk{
	private String title;
	private String director;
	private static int count;
	
	public DVD(){
		title = "";
		director = "";
		playTime = 0;
		gotit = false;
		comment = "";
		count = 0;
	}
	
	public DVD(String t, String d, String c, double p, boolean g){
		title = t;
		director = d;
		playTime = p;
		gotit = g;
		comment = c;
	}
	
	public static void setCount(){
		count++;
	}
	
	public static int getCount(){
		return count;
	}
	
	public String info(){
		DecimalFormat decform = new DecimalFormat("0.00");
		String str = Format.justify('l', title, 15) +
				Format.justify('l', director, 15) +
				Format.justify('l', decform.format(playTime), 12) + 
				Format.justify('l', comment, 30);
		
		if (gotit == true)
			str += Format.justify('l', "yes", 8);
		else{str += Format.justify('l', "no", 8);}
		
		return str;					
	}
}



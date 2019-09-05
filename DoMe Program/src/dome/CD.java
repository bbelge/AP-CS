package dome;

import java.text.DecimalFormat;
import BreezySwing.Format;

public class CD extends Disk{
	private String track;
	private String artist;
	private int numTracks;
	protected static int count;
	
	public CD(){
		track = "";
		artist = "";
		numTracks = 0;
		playTime = 0;
		gotit = false;
		comment = "";
		count = 0;
	}
	
	public CD(String t, String a, String c, double p, boolean g, int n){
		track = t;
		artist = a;
		numTracks = n;
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
		String str = Format.justify('l', track, 15) +
				Format.justify('l', artist, 15) +
				Format.justify('l', numTracks + "", 20) +
				Format.justify('l', decform.format(playTime), 12) + 
				Format.justify('l', comment, 30);
		
		if (gotit == true)
			str += Format.justify('l', "yes", 8);
		else{str += Format.justify('l', "no", 8);}
		
		return str;					
	}
}



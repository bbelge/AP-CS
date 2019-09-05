package dome;

import BreezySwing.Format;

public class Database {
	private Disk dvds[];
	private Disk cds[];
	
	public Database(){
		dvds = new DVD[25];
		cds = new CD[25];
	}
	
	public void addDVD(String t, String d, String c, double p, String g){
		boolean g1 = false;
		if (g.equals("Y"))
			g1 = true;
		dvds[DVD.getCount()] = new DVD(t, d, c, p, g1);
		DVD.setCount();
	}
	
	public void addCD(String t, String a, String c, double p, String g, int n){
		boolean g1 = false;
		if (g.equals("Y"))
			g1 = true;
		cds[CD.getCount()] = new CD(t, a, c, p, g1, n);
		CD.setCount();
	}
	
	public static void checkCD(String t, String a, String c, double p, String g, int n){
		if (p <= 0 || n <= 0 || a.isEmpty() || c.isEmpty() || g.isEmpty() || (!g.equals("Y") && !g.equals("N")) || t.isEmpty())
			throw new IllegalArgumentException("Invalid input.");
		if (CD.getCount() >= 25)
			throw new ArrayIndexOutOfBoundsException("You have reached the maximum number of CDS.");
	}
	
	public static void checkDVD(String t, String d, String c, double p, String g){
		if (p <= 0 || d.isEmpty() || c.isEmpty() || g.isEmpty() || (!g.equals("Y") && !g.equals("N")) || t.isEmpty())
			throw new IllegalArgumentException("Invalid input.");
		if (DVD.getCount() >= 25)
			throw new ArrayIndexOutOfBoundsException("You have reached the maximum number of DVDS.");
	}
	
	public String listAll() {
		String str = "CDs:\n" +
				Format.justify('l', "track:", 15) +
				Format.justify('l', "artist:", 15) +
				Format.justify('l', "number of tracks:" + "", 20) +
				Format.justify('l', "play time:" + "", 12) + 
				Format.justify('l', "comment:", 30) +
				Format.justify('l', "got it?:", 8) + "\n";
		
		for (int i = 0; i < CD.getCount(); i++) {
			str += ((CD) cds[i]).info() + "\n";
		}
		
		str += "\n\nDVDs:\n" +
				Format.justify('l', "title:", 15) +
				Format.justify('l', "director:", 15) +
				Format.justify('l', "play time:" + "", 12) + 
				Format.justify('l', "comment:", 30) +
				Format.justify('l', "got it?:", 8) + "\n";
		
		for (int i = 0; i < DVD.getCount(); i++) {
			str += ((DVD) dvds[i]).info() + "\n";
		}
		
		return str;
	}
}



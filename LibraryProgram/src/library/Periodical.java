package library;

public class Periodical extends Item implements Comparable{
	private int issue;

	//constructors
	public Periodical(){
		super();
		issue = 0;
	}

	public Periodical(String t, int i){
		super(t);
		issue = i;
	}
	
	//getter
	public int getIssue(){
		return issue;
	}

	@Override
	public int compareTo(Object o){

		if ((((Periodical) o).getIssue()) < issue)
			return -1;
		else if ((((Periodical) o).getIssue()) > issue)
			return 1;
		
		for(int i=0; i < (Math.min(((Periodical) o).getTitle().length(), super.getTitle().length())); i++){
			if ((((Periodical) o).getTitle().charAt(i) < super.getTitle().charAt(i)))
				return -1;
			else if ((((Periodical) o).getTitle().charAt(i) > super.getTitle().charAt(i)))
				return 1;
		}
		
		return 0;
	}

	@Override
	public String print(){
		return super.getTitle() + "	" + issue;
	}

}


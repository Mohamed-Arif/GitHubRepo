public abstract class Competitor {

	private String 	compNumber;					// Swimmer identifier number of type integer
	private Name 	compName;					// Swimmer name of type Name (name class)
	private String 	compLevel;					// Swimmer level of type String (Bronze, Silver, Gold)
	private String 	compAge; 					// Extra attribute is the Swimmer's Age
	protected int [] ScoreArray = new int[5];						// an array to store scores
	
	public Competitor(String number, Name name, String level, String age, int[] Scores)
	{
		this.compNumber	= number;
		this.compName	= name;
		this.compLevel	= level;
		this.compAge	= age;
		this.ScoreArray	= Scores;
	}
	
	public String getcompNumber() {return compNumber;}
	public void setcompNumber(String compNumber) {this.compNumber = compNumber;}

	public Name getcompName() {return compName;}
	public void setcompName(String compName) {this.compName = new Name(compName);}

	public String getcompLevel() {return compLevel;}
	public void setcompLevel(String compLevel) {this.compLevel = compLevel;}

	public String getcompAge() {return compAge;}
	public void setcompAge(String compAge) {this.compAge = compAge;}

	public int[] getScoreArray() {return ScoreArray;}
	public void setScoreArray(int[] ScoreArray) {this.ScoreArray = ScoreArray;}
	
	public abstract String getShortDetails();
	public abstract Double getOverallScore();


	
}

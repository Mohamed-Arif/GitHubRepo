public class Climber {
	
	private String 	CLNumber;					// Swimmer identifier number of type integer
	private Name 	CLName;						// Swimmer name of type Name (name class)
	private String 	CLLevel;						// Swimmer level of type String (Bronze, Silver, Gold)
	private String 	CLAge; 						// Extra attribute is the Swimmer's Age
	private Integer [] ScoreArray;					// an array to store scores
	private double overAllScore;
	
public Climber(String number, Name name, String level, String age, Integer[] Scores){
		
		this.CLNumber	= number;
		this.CLName		= name;
		this.CLLevel		= level;
		this.CLAge 		= age;
		this.ScoreArray		= Scores;
		}
// @Override
public Double getOverAllScore()
	{
	Integer[] lscore= this.getScoreArray();
	double sum= 0;
	for (int score : lscore)
	sum+=score;
	return sum/lscore.length;         
};	

// @Override
public String getShortDetails()
		{
		String shortDetails = String.format("Competitor: %d (%s) has overall score %,.1f.",
		this.getCLNumber(),
		this.getCLName().getInitials(),
		this.getOverAllScore());
		return shortDetails;
		}

public String getCLNumber() {
	return CLNumber;
}

public void setCLNumber(String cLNumber) {
	CLNumber = cLNumber;
}

public Name getCLName() {
	return CLName;
}

public void setCLName(Name cLName) {
	CLName = cLName;
}

public String getCLLevel() {
	return CLLevel;
}

public void setCLLevel(String cLLevel) {
	CLLevel = cLLevel;
}

public String getCLAge() {
	return CLAge;
}

public void setCLAge(String cLAge) {
	CLAge = cLAge;
}

public Integer[] getScoreArray() {
	return ScoreArray;
}

public void setScoreArray(Integer[] scoreArray) {
	ScoreArray = scoreArray;
}

public void setOverAllScore(double overAllScore) {
	this.overAllScore = overAllScore;
}	




}

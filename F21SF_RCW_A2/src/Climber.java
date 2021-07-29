public class Climber extends Competitor {
	
	private double overAllScore;
	
public Climber(String number, Name name, String level, String age, int[] Scores){
		
	super(number, name, level, age, Scores );
		}

@Override
public String getShortDetails()
		{
		String shortDetails = String.format("Competitor: %d (%s) has overall score %,.1f.",
		this.getcompNumber(),
		this.getcompName().getInitials(),
		this.getOverallScore());
		return shortDetails;
		}





public int[] getScoreArray() {
	return ScoreArray;
}

public void setScoreArray(int[] scoreArray) {
	ScoreArray = scoreArray;
}

public void setOverAllScore(double overAllScore) {
	this.overAllScore = overAllScore;
}
@Override
public Double getOverallScore() {
	// TODO Auto-generated method stub
	int[] lscore= this.getScoreArray();
	double sum= 0;
	for (int score : lscore)
	sum+=score;
	return sum/lscore.length;
}





}

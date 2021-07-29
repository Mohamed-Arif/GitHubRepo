import java.util.Arrays;

public class Racer extends Competitor {

	private double overAllScore;


	public Racer(String number, Name name, String level, String age, int[] Scores){
		
		super(number, name, level, age, Scores );
		this.getOverallScore();
	}	

	public int[] getScoreArray() {
		return ScoreArray;
	}

	public void setScoreArray(int[] scoreArray) {
		ScoreArray = scoreArray;
	};

	 @Override
	public String getShortDetails()
			{
			String shortDetails = String.format("Competitor: %s (%s) has overall score %,.1f.",
			this.getcompNumber(),
			this.getcompName().getInitials(),
			this.getOverallScore());
			return shortDetails;
			}

	@Override
	public Double getOverallScore() {
int[] lScoreArray= this.getScoreArray(); 
		
		Arrays.sort(lScoreArray);                             
		
		double avg = 0 ;                                       

		if(getcompLevel().contentEquals("Bronze"))
		{                  																				 
			avg = lScoreArray[lScoreArray.length-1] + lScoreArray[lScoreArray.length-2] / 2.0;             
		}
		
		else if(getcompLevel().contentEquals("Silver"))
		{
			avg = lScoreArray[lScoreArray.length-1] + 
					lScoreArray[lScoreArray.length-2] +
						lScoreArray[lScoreArray.length-3]/ 3.0;
		}
		
		else if(getcompLevel().contentEquals("Gold"))
		{
			avg = lScoreArray[lScoreArray.length-1]+
					lScoreArray[lScoreArray.length-2]+lScoreArray[lScoreArray.length-3] +
						lScoreArray[lScoreArray.length-4]/ 4.0; 
		}

		return this.overAllScore = avg;   
	}



}

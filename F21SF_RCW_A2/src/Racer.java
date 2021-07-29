import java.util.Arrays;

public class Racer {

	private String 	RacerNumber;					// Swimmer identifier number of type integer
	private Name 	RacerName;						// Swimmer name of type Name (name class)
	private String 	RacerLevel;						// Swimmer level of type String (Bronze, Silver, Gold)
	private String 	RacerAge; 						// Extra attribute is the Swimmer's Age
	private Integer [] ScoreArray;					// an array to store scores
	private double overAllScore;


	public Racer(String number, Name name, String level, String age, Integer[] Scores){
		
		this.RacerNumber	= number;
		this.RacerName		= name;
		this.RacerLevel		= level;
		this.RacerAge 		= age;
		this.ScoreArray		= Scores;
		}	

	// @Override
	public Double getOverAllScore()
		{
		Integer[] lScoreArray= this.getScoreArray(); 
		
		Arrays.sort(lScoreArray);                             
		
		double avg = 0 ;                                       

		if(getRacerLevel().contentEquals("Bronze"))
		{                  																				 
			avg = lScoreArray[lScoreArray.length-1] + lScoreArray[lScoreArray.length-2] / 2.0;             
		}
		
		else if(getRacerLevel().contentEquals("Silver"))
		{
			avg = lScoreArray[lScoreArray.length-1] + 
					lScoreArray[lScoreArray.length-2] +
						lScoreArray[lScoreArray.length-3]/ 3.0;
		}
		
		else if(getRacerLevel().contentEquals("Gold"))
		{
			avg = lScoreArray[lScoreArray.length-1]+
					lScoreArray[lScoreArray.length-2]+lScoreArray[lScoreArray.length-3] +
						lScoreArray[lScoreArray.length-4]/ 4.0; 
		}

		return this.overAllScore = avg;          
	}

	public String getRacerNumber() {
		return RacerNumber;
	}

	public void setRacerNumber(String racerNumber) {
		RacerNumber = racerNumber;
	}

	public Name getRacerName() {
		return RacerName;
	}

	public void setRacerName(Name racerName) {
		RacerName = racerName;
	}

	public String getRacerLevel() {
		return RacerLevel;
	}

	public void setRacerLevel(String racerLevel) {
		RacerLevel = racerLevel;
	}

	public String getRacerAge() {
		return RacerAge;
	}

	public void setRacerAge(String racerAge) {
		RacerAge = racerAge;
	}

	public Integer[] getScoreArray() {
		return ScoreArray;
	}

	public void setScoreArray(Integer[] scoreArray) {
		ScoreArray = scoreArray;
	};

	// @Override
	public String getShortDetails()
			{
			String shortDetails = String.format("Competitor: %s (%s) has overall score %,.1f.",
			this.getRacerNumber(),
			this.getRacerName().getInitials(),
			this.getOverAllScore());
			return shortDetails;
			}



}

import java.util.Arrays;

public class Swimmer {

// Instance Variables are declared below

private int 	SwimmerNumber;					// Swimmer identifier number of type integer
private Name 	SwimmerName;					// Swimmer name of type Name (name class)
private String 	SwimmerLevel;					// Swimmer level of type String (Bronze, Silver, Gold)
private int 	SwimmerAge; 					// private String SwimmerNationality(might use as extra attribute)
private int [] 	ScoreArray;						// an array to store scores
private Double 	OverAllScore;					// the final score that will be obtained


// Constructor to create Swimmer objects

public Swimmer(int number, String name, String level, int age, int[] Scores)
{
	this.SwimmerNumber 		= number;
	this.SwimmerName 		= new Name(name);
	this.SwimmerLevel 		= level;
	this.SwimmerAge 		= age;
	this.ScoreArray 		= Scores;
	this.getOverAllScore();
}

public double getOverAllScore()
{
	double oScore =  0;
	
	int Max = ScoreArray[0];
	int iMax = 0;
	
	int Min = ScoreArray[0];
	int iMin = 0;
	
	for(int i = 0; i < ScoreArray.length; i++)
	{
		if(ScoreArray[i] >= Max)
		{
			Max = ScoreArray[i];
			iMax = i;
		}
		if((ScoreArray[i] <= Min) && (i != iMax))
		{
			Min = ScoreArray[i];
			iMin = i;
		}
	}	
	for(int i = 0; i < ScoreArray.length; i++)
	{
		if(!(i==iMax || i==iMin))
		{
			oScore = oScore + ScoreArray[i];
		}
	}
	return oScore/(ScoreArray.length-2);
}

public void setOverAllScore(Double OverAllScore)
{
	this.OverAllScore = OverAllScore;
}

// comments placeholder
// comments placeholder

public String getFullDetails()
{
String fullDetails = String.format("%s is a %s level Swimmer aged %d and their number is %d.\n" + 
									"The scores obtained by %s are: %s\n" + 
									"Their Final score is: %,.1f", 
									getSwimmerName().getFullName(), getSwimmerLevel(), getSwimmerAge(),
									getSwimmerNumber(), getSwimmerName().getFirstName(),
									Arrays.toString(ScoreArray).replace("[", "").replace("]", ""),
									getOverAllScore());
	return fullDetails;
}

public String getShortDetails()
{
	String shortDetails = String.format("CN %d (%s) has overall score of %,.1f",
							this.getSwimmerNumber(), this.getSwimmerName().getInitials(), this.getOverAllScore());
	return shortDetails;
}	

//Getters and setters to set and return values

public int getSwimmerNumber() {return SwimmerNumber;}
public void setSwimmerNumber(int SwimmerNumber) {this.SwimmerNumber = SwimmerNumber;}

public Name getSwimmerName() {return SwimmerName;}
public void setSwimmerName(String SwimmerName) {this.SwimmerName = new Name(SwimmerName);}

public String getSwimmerLevel() {return SwimmerLevel;}
public void setSwimmerLevel(String SwimmerLevel) {this.SwimmerLevel = SwimmerLevel;}

public int getSwimmerAge() {return SwimmerAge;}
public void setSwimmerAge(int SwimmerAge) {this.SwimmerAge = SwimmerAge;}

public int[] getScoreArray() {return ScoreArray;}
public void setScoreArray(int[] ScoreArray) {this.ScoreArray = ScoreArray;}

}
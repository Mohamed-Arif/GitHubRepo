import java.util.Arrays;

public class Swimmer {

// Instance Variables are declared below
private String 	SwimmerNumber;					// Swimmer identifier number of type integer
private Name 	SwimmerName;					// Swimmer name of type Name (name class)
private String 	SwimmerLevel;					// Swimmer level of type String (Bronze, Silver, Gold)
private String 	SwimmerAge; 					// private String SwimmerNationality(might use as extra attribute)
private Integer [] ScoreArray;					// an array to store scores

// Constructor to create Swimmer objects
public Swimmer(String number, Name name, String level, String age, Integer[] Scores)
{
	this.SwimmerNumber 		= number;
	this.SwimmerName 		= name;
	this.SwimmerLevel 		= level;
	this.SwimmerAge 		= age;
	this.ScoreArray 		= Scores;
}

// Method to calculate the overall score
public double getOverAllScore()			// referred code from https://stackoverflow.com/questions/8029024/calculating-average-without-highest-and-lowest-values-in-an-array
{
	double oScore =  0;	
	
	int Max = ScoreArray[0];						
	int Min = ScoreArray[0];
	
	int iMax = 0;
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
		if(!(i==iMin || i==iMax))				
		{
			oScore = oScore + ScoreArray[i];
		}
	}
	return oScore/(ScoreArray.length-2);
}

// By using the string format and the get methods, the full details are returned.
public String getFullDetails()
{
String fullDetails = String.format("%s is a %s level Swimmer aged %s and their number is %s.\n" + 
									"The scores obtained by %s are: %s\n" + 
									"Their Final score is: %,.1f", 
									getSwimmerName().getFullName(), getSwimmerLevel(), getSwimmerAge(),
									getSwimmerNumber(), getSwimmerName().getFirstName(),
									Arrays.toString(ScoreArray).replace("[", "").replace("]", ""),
									getOverAllScore());
	return fullDetails;
}

// This method works similarly as the method above. By using string formatting and get methods, the short details are returned.
public String getShortDetails()
{
	String shortDetails = String.format("Competitor Number: %s (%s) has overall score of %,.1f",
							this.getSwimmerNumber(), this.getSwimmerName().getInitials(), this.getOverAllScore());
	return shortDetails;
}	

//Getters and setters to set and return values
public String getSwimmerNumber() {return SwimmerNumber;}
public void setSwimmerNumber(String SwimmerNumber) {this.SwimmerNumber = SwimmerNumber;}

public Name getSwimmerName() {return SwimmerName;}
public void setSwimmerName(String SwimmerName) {this.SwimmerName = new Name(SwimmerName);}

public String getSwimmerLevel() {return SwimmerLevel;}
public void setSwimmerLevel(String SwimmerLevel) {this.SwimmerLevel = SwimmerLevel;}

public String getSwimmerAge() {return SwimmerAge;}
public void setSwimmerAge(String SwimmerAge) {this.SwimmerAge = SwimmerAge;}

public Integer[] getScoreArray() {return ScoreArray;}
public void setScoreArray(Integer[] ScoreArray) {this.ScoreArray = ScoreArray;}

}
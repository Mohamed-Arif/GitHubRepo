import java.util.Arrays;

public class Swimmer {

// Instance Variables are declared below
private String 	SwimmerNumber;					// Swimmer identifier number of type integer
private Name 	SwimmerName;					// Swimmer name of type Name (name class)
private String 	SwimmerLevel;					// Swimmer level of type String (Bronze, Silver, Gold)
private String 	SwimmerAge; 					// Extra attribute is the Swimmer's Age
private Integer [] ScoreArray;					// an array to store scores

// Constructor to create Swimmer objects
public Swimmer(String number, Name name, String level, String age, Integer[] Scores){
	
	this.SwimmerNumber 		= number;
	this.SwimmerName 		= name;
	this.SwimmerLevel 		= level;
	this.SwimmerAge 		= age;
	this.ScoreArray 		= Scores;
	}

// Method to calculate the overall score by neglecting the highest and lowest values
public double getOverAllScore(){
				
	double sum			= 0;	
	// The array is first sorted.
	Integer [] sortedArray = this.getScoreArray();
	Arrays.sort(sortedArray);
	// By starting the loop from 1, we disregard the 0th index
	// The loop runs till length-1. So last element is disregarded
	for(int i = 1; i < sortedArray.length-1 ; i++){
			sum = sum + ScoreArray[i];
			}
		
	return sum/(ScoreArray.length-2);
}

// By using the string formatting and the get methods, the full details are returned.
public String getFullDetails(){

String fullDetails = String.format("%s is a %s level Swimmer aged %s and their number is %s.\n" + 
									"The scores obtained by %s are: %s\n" + 
									"Their Final score is: %,.1f", 
									getSwimmerName().getFullName(), getSwimmerLevel(), getSwimmerAge(),
									getSwimmerNumber(), getSwimmerName().getFirstName(),
									Arrays.toString(ScoreArray).replace("[", "").replace("]", ""),		// using .replace to replace the "[" with empty.
									getOverAllScore());
	return fullDetails;
	}

// This method works similarly as the method above. By using string formatting and get methods, the short details are returned.
public String getShortDetails(){
	
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
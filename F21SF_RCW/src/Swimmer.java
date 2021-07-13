import java.util.Arrays;

public class Swimmer {

// Instance Variables are declared below

private int 	SwimmerNumber;					// Swimmer identifier number of type integer
private Name 	SwimmerName;					// Swimmer name of type Name (name class)
private String 	SwimmerLevel;					// Swimmer level of type String (Bronze, Silver, Gold)
private int 	SwimmerAge; 					// private String SwimmerNationality(maybe) EXTRA ATTRIBUTE
private int [] 	ScoreArray = new int [5];		// an array to store scores of 5 rounds
private Double 	FinalScore;						// the final score that will be obtained


// Constructor to create Swimmer objects

public Swimmer(int number, String name, String level, int age, int[] Scores)
{
	SwimmerNumber 	= number;
	SwimmerName 	= new Name(name);
	SwimmerLevel 	= level;
	SwimmerAge 		= age;
	ScoreArray 		= Scores;
	this.getFinalScoreArray();
}

// Generating getters and setters to set and return values

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

public Double getFinalScoreArray() 
{
	int [] Scores = this.getScoreArray(); 		// the array score value is assigned to the variable
	Arrays.sort(Scores);						// using the array method "sort", the scores are sorted in ascending order
	double average = 0;							// initializing the value of average as 0
	
if(getSwimmerLevel().contentEquals("Bronze"))	// Check the level of the swimmer with Bronze being the lowest level
{
	average = Scores[Scores.length-1];			// Calculating the score for Bronze level
}

else if(getSwimmerLevel().contentEquals("Silver"))
{
	average = (Scores[Scores.length-1] + Scores[Scores.length-2])/2.0;	// Calculating the score for Silver level
}
else if(getSwimmerLevel().contentEquals("Gold"))
{
	average = (Scores[Scores.length-1] + Scores[Scores.length-2] + Scores[Scores.length-3])/3.0;	// Calculating the score for Gold level
}

return this.FinalScore = average;
}

public void setFinalScoreArray(Double FinalScore)
{
	this.FinalScore = FinalScore;
}

// comments placeholder
// comments placeholder

public String getFullDetails()
{
	int Scores[] = getScoreArray();
	String ScoreString = "";
	
	for(int i =0; i<Scores.length; i++)
	{
		if(i != 4)
		{
			ScoreString = ScoreString + ScoreArray[i] + ",";
		}
		else
		{
			ScoreString = ScoreString + ScoreArray[i];
		}
	}

String fullDetails = String.format("%s is a Swimmer.\n Their age is %d and their number is %d.\n" + 
									"They are in the %s Level and the scores obtained are: %s\n" + 
									"Their Final score is: %,.1f", 
									getSwimmerName().getFullName(), getSwimmerAge(),
									getSwimmerNumber(), getSwimmerLevel(), ScoreString, getFinalScoreArray());

return fullDetails;
}

public String getShortDetails()
{
	String 
}



public class Name {			// utilizing Name.java from the gitlab repo f21sf-2020-21/ programs/ 05-name2/ Name.java
	
	 private String firstName;
	 private String middleName;
	 private String lastName;

	 //constructor to create object with a first and last name
	 public Name(String fName, String lName) {
	firstName = fName;
	middleName = "";
	lastName = lName;
	 }

	 //constructor to create object with first, middle and last name
	 //if there isn't a middle name, that parameter could be an empty
	//String
	 public Name(String fName, String mName, String lName) {
	firstName = fName;
	middleName = mName;
	lastName = lName;
	}
	 //constructor to create name from full name
	 //in the format first name then space then last name
	 //or first name then space then middle name then space then last name
	 public Name (String fullName) {
	 int spacePos1 = fullName.indexOf(' ');
	 firstName = fullName.substring(0, spacePos1);
	 int spacePos2 = fullName.lastIndexOf(' ');
	 if (spacePos1 == spacePos2)
	 middleName = "";
	 else
	 middleName = fullName.substring(spacePos1+1, spacePos2);
	 lastName = fullName.substring(spacePos2 + 1);
	 }

	 //returns the first name
	 public String getFirstName() {return firstName; }
	 //returns the last name
	 public String getLastName() {return lastName; }

	 //change the last name to the value provided in the parameter
	 public void setLastName(String ln) {
	 lastName = ln;
	 }

	 //returns the first name then a space then the last name
	 public String getFirstAndLastName() {
	return firstName + " " + lastName;
	 }

	 //returns the last name followed by a comma and a space
	 // then the first name
	 public String getLastCommaFirst() {
	return lastName + ", "+ firstName;
	 }

	 //returns the full name
	
	 //either first name then space then last name
	 //or first name then space then middle name then space
	 // and then last name
	 public String getFullName() {
	 String result = firstName + " ";
	 if (!middleName.equals("")) {
	 result += middleName + " ";
	 }
	 result += lastName;
	 return result;
	}
	public String getInitials() {
		if(middleName =="") {
			return String.format("%s%s",firstName.charAt(0) , lastName.charAt(0));
			
		}
		else {
		return String.format("%s%s%s",firstName.charAt(0) , middleName.charAt(0) , lastName.charAt(0));
	}
}}}
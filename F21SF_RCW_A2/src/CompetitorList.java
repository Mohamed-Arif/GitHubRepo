import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class contains an ArrayList of Swimmer objects.
 * It contains methods that are used to generate the report and look up a competitor using their number.
 * @author Arif
 */

public class CompetitorList extends ArrayList<Competitor> {

public ArrayList <Competitor> compList;
/**
* Creating an ArrayList of swimmers
*/
public CompetitorList(ArrayList <Competitor> compList){
	this.compList = new ArrayList<>();
	}

/**
 * A simple method to add swimmers to the list.
 * Assuming that the swimmer does not already exist in the list
 * @param s
 */
public void addSwimmer(Swimmer s){
	String num = s.getcompNumber();
	String existing = checkSwim(num);			// this checks whether the number entered already exists
	if(existing != s.getcompNumber()) {		// change back to null if it doesn't work
		compList.add(s);	
	}else {
		System.out.println("You have either entered an invalid number or a competitor exists with the same number.");
		}
	}

/**
 * This method is used to search for a swimmer using their unique identification number
 * I know that the spec stressed that the competitor number should be of int datatype,
 * but I am really constrained by time and went with the easier option.
 * @param SwimmerNumber is taken as a parameter
 * @return short details of the swimmer whose number has been entered (or)
 * return null if the number doesn't exist.
 */
public  String checkSwim(String number){
	for(Competitor s : compList){								// enhanced for loop iterates through the list
		if(s.getcompNumber().equals(number)){		// if the swimmer number passed in the parameter and the one from the get
			return s.getShortDetails();						// method match, then it returns the short details.
			}
		}
	return null;
	}

/**
 * This is the method which will produce the desired report by calling the methods from this class.	
 * @return the final report
 */
public String getReport(){
		String report = String.format("%s\nSTATISTICAL\n%s\n%s\n%s", tableOfComp(),			// Rather simple.
										getsListSize(), topScorer(), scoreFrequency());		// Just calling the methods in this class.
		return report;
		}

/**
 * This method generates a table/list of all the swimmers.
 * @return a display of swimmers, their full and short details.
 */
public String tableOfComp(){
	String details = "";
	details = String.format("Number\t\tName\t\tLevel\t\tAge\t\tScores\t\t\tOverall Score\n");
		
	for(Competitor s : compList){
		details = String.format("\t\t%s","\t\t\t%s","\t\t\t%s","\t\t\t%d","\t\t%s","\t\t\t\t%s\n",
										s.getcompNumber(),s.getcompName(),s.getcompLevel(),
										s.getSwimmerAge(),s.getScoreArray(),s.getOverallScore());
		}
	
	details = details + String.format("\n");
		
	for(Competitor s : compList){
		details = details + String.format("\n" + "Full details for %s: \n%s", s.getcompNumber(),s.getFullDetails());
		}
		
	for(Competitor s : compList){
		details = details + String.format("\n" + "Short details for %s: \n%s", s.getcompNumber(),s.getShortDetails());
		}
	return details;
	}

/**
* This method adds a line to the report showing the number of swimmers.
* @return size of list.
*/
public String getsListSize(){
	return "\nThere are " + compList.size() + " Swimmers in this competition.\n";
	}

/**
* A method that will return the name of the swimmer who has the highest overall score
* @return the name of the swimmer
*/	
public String topScorer(){

	String topReport	= "";
	Double max			= 0.0;
	String name;			
		
	for(Competitor s : compList){
			if(max < s.getOverallScore()){
				max			= s.getOverallScore();								
				name		= s.getcompName().getFullName();
				topReport	= name + " has the highest overall score";
				}
			}		
		return topReport;
		}

/**
 * This method uses the value of scores as an index
 * used getYearsFrequencyReport() as reference from 
 * https://gitlab-student.macs.hw.ac.uk/mg90/f21sf-2020-21/-/blob/master/programs/09-fileio/StudentList.java
 * @return
 */
public String scoreFrequency()
{
	int [] freq = new int[5];
	for (Swimmer s : swimList){
		for(int f : s.getScoreArray()){
			freq[f]++;
			}
		}
	
	String freqReport = String.format("\nScore: ","\t\t0\t\t1\t\t2\t\t3\t\t4\t\t5\n",
										"Frequency: \t");
	for (int i : freq){
		freqReport = freqReport + "\t" + i;
		}
	return freqReport;
	}


}
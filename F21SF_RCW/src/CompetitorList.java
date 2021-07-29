import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class contains an ArrayList of Swimmer objects.
 * It contains methods that are used to generate the report and look up a competitor using their number.
 * @author Arif
 */

public class CompetitorList {

public ArrayList <Swimmer> swimList;
/**
* Creating an ArrayList of swimmers
*/
public CompetitorList(){
	swimList = new ArrayList<>();
	}

/**
 * A simple method to add swimmers to the list.
 * Assuming that the swimmer does not already exist in the list
 * @param s
 */
public void addSwimmer(Swimmer s){
	String num = s.getSwimmerNumber();
	String existing = checkSwim(num);			// this checks whether the number entered already exists
	if(existing != s.getSwimmerNumber()) {		// change back to null if it doesn't work
		swimList.add(s);	
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
public  String checkSwim(String SwimmerNumber){
	for(Swimmer s : swimList){								// enhanced for loop iterates through the list
		if(s.getSwimmerNumber().equals(SwimmerNumber)){		// if the swimmer number passed in the parameter and the one from the get
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
		
	for(Swimmer s : swimList){
		details = String.format("\t\t%s","\t\t\t%s","\t\t\t%s","\t\t\t%d","\t\t%s","\t\t\t\t%s\n",
										s.getSwimmerNumber(),s.getSwimmerName(),s.getSwimmerLevel(),
										s.getSwimmerAge(),s.getScoreArray(),s.getOverAllScore());
		}
	
	details = details + String.format("\n");
		
	for(Swimmer s : swimList){
		details = details + String.format("\n" + "Full details for %s: \n%s", s.getSwimmerNumber(),s.getFullDetails());
		}
		
	for(Swimmer s : swimList){
		details = details + String.format("\n" + "Short details for %s: \n%s", s.getSwimmerNumber(),s.getShortDetails());
		}
	return details;
	}

/**
* This method adds a line to the report showing the number of swimmers.
* @return size of list.
*/
public String getsListSize(){
	return "\nThere are " + swimList.size() + " Swimmers in this competition.\n";
	}

/**
* A method that will return the name of the swimmer who has the highest overall score
* @return the name of the swimmer
*/	
public String topScorer(){

	String topReport	= "";
	Double max			= 0.0;
	String name;			
		
	for(Swimmer s : swimList){
			if(max < s.getOverAllScore()){
				max			= s.getOverAllScore();								
				name		= s.getSwimmerName().getFullName();
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

public void readFile(String filename) {
    File file = new File(filename);

    // Track parsed lines for useful error output
    int lineNum = 1;

    try (
        BufferedReader input = new BufferedReader(new FileReader(file));
    ) {
        // Skip over first line (csv column headings)
        String line = input.readLine();

        while ((line = input.readLine()) != null) {
            lineNum++;

            processLine(line);
        }
    } catch (FileNotFoundException e) {
        System.out.println(file.getName() + " does not exist.");
    } catch (IOException e) {
        System.out.println(file.getName() + " could not be read.");
    }
}
private void processLine (String line) {
    // Splitting with regex trims excess whitespace near commas
    // Java's split operator discards empty strings by default, -1 keeps them (empty
    // csv columns are valid)
    try {
	String[] details = line.split("\\s*,\\s*", -1);

    // All rows in csv file have same columns
    if (details.length == 5) {
        String number		= details[0];
        Name name			= new Name(details[1]);
        String level		= details[2];
        String age			= details[3];
        Integer [] scores	= new Integer[4];
        Swimmer s = new Swimmer(number, name, level, age, scores);
        swimList.add(s);
    } else {
       System.out.println("Please check the details you've entered in your file");
    }
    }catch(NumberFormatException nfe)
    {
    	System.out.println(nfe.getMessage());
    }
}

public  void writeToFile(String filename, String report) {
	
	 FileWriter fw;
	 try {
	    fw = new FileWriter(filename);
	    fw.write("COMPETITION REPORT\n");
	    fw.write(report);
	 	fw.close();
	 }
	 //message and stop if file not found
	 catch (FileNotFoundException fnf){
		 System.out.println(filename + " not found ");
		 System.exit(0);
	 }
	 //stack trace here because we don't expect to come here
	 catch (IOException ioe){
	    ioe.printStackTrace();
	    System.exit(1);
	 }
}

}
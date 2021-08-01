import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
 * This method adds swimmers to the list.
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
 * This method produces the desired report by calling the methods from this class.	
 * @return the final report
 */
public String getReport(){
		String report = String.format("%s\nSTATISTICAL\n%s\n%s\n%s", tableOfComp(),			
										getsListSize(), topScorer(), scoreFrequency()); // Just calling the methods in this class.	
		return report;
		}

/**
 * This method generates a table/list of all the swimmers with the help of String formatting.
 * @return a display of swimmers, their full and short details.
 */
public String tableOfComp(){
	String details = "";
	details = String.format("Number\t\tName\t\tLevel\t\tAge\t\tScores\t\t\tOverall Score\n");
		
	for(Swimmer s : swimList){
		details = String.format("\t\t%s","\t\t\t%s","\t\t\t%s","\t\t\t%s","\t\t%s","\t\t\t\t%s\n",
										s.getSwimmerNumber(),s.getSwimmerName(),s.getSwimmerLevel(),
										s.getSwimmerAge(),s.getScoreArray(),s.getOverAllScore());
		}
	
	details = details + String.format("\n");
		
	for(Swimmer s : swimList){
		details = details + String.format("\n" + "Full details for %s: \n%s\n", s.getSwimmerNumber(),s.getFullDetails());
		}
		
	for(Swimmer s : swimList){
		details = details + String.format("\n" + "Short details for %s: \n%s\n", s.getSwimmerNumber(),s.getShortDetails());
		}
	return details;
	}

/**
* This method returns a statement with the number size of the list.
* @return size of list.
*/
public String getsListSize(){
	return "\nThere are " + swimList.size() + " Swimmers in this competition.\n";
	}

/**
* This method returns the name of the competitor who has the highest overall score
* @return the name of the competitor
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
 * This method uses the value of scores as an index and returns the frequency of the scores.
 * @return
 */
public String scoreFrequency()
{
	/*used getYearsFrequencyReport() as reference from 
	  https://gitlab-student.macs.hw.ac.uk/mg90/f21sf-2020-21/-/blob/master/programs/09-fileio/StudentList.java*/
	
	int [] freq = new int[6];
	for (Swimmer s : swimList){
		for(int f : s.getScoreArray()){
			freq[f]++;
			}
		}
	
	String freqReport = "\nScore: "+"\t\t\t1\t2\t3\t4\t5\n"+"Frequency:\t";
	for (int i = 1; i < 6; i++){
		freqReport = freqReport + "\t" + freq[i];
		}
	return freqReport;
	}

/**
 * This method reads the input file.
 * @param filename
 */
public void readFile(String filename) {
    File file = new File(filename);

    // Track parsed lines for useful error output
    int lineNum = 1;

    try (
        BufferedReader input = new BufferedReader(new FileReader(file));
    ) {
        // Skip over first line (inputfile column headings)
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

/**
 * This method will process the input file and split it near commas
 * @param line
 */
private void processLine (String line) {
   
    try {
	String[] details = line.split(",");

    // The number of elements split by commas is 9. So length is set to 9.
    if (details.length == 9) {
        String number		= details[0];
        Name name			= new Name(details[1]);
        String level		= details[2];
        String age			= details[3];
        Integer [] scores	= new Integer[5];
        for (int i = 0; i < 5; i++){
        	scores[i] = Integer.parseInt(details[i+4]);
		}
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

/**
 * This method will write the generated report to the output file
 * @param filename
 * @param report
 */
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
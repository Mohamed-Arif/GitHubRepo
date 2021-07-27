import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class "swimList" contains an ArrayList of Swimmer objects.
 * It contains methods that are used to generate the final report.
 * @author Arif
 */

public class SwimList {

public ArrayList <Swimmer> swimList;
/**
* Creating an ArrayList of swimmers
*/
public SwimList()
{
	swimList = new ArrayList<>();
}

/**
 * A simple method to add swimmers to the list.
 * Assuming that the swimmer does not already exist in the list
 * @param s
 */
public void addSwimmer(Swimmer s)
{
	swimList.add(s);			
}

/**
 * This method is used to search for a swimmer using their unique identification number
 * @param SwimmerNumber is taken as a parameter
 * @return short details of the swimmer whose number has been entered (or)
 * return null if the number doesn't exist.
 */
public  String checkSwim(String SwimmerNumber)
{
	for(Swimmer s : swimList)
	{
		if(s.getSwimmerNumber().equals(SwimmerNumber))
		{
			return s.getShortDetails();
		}			
	}
	return null;
}

/**
 * This is the method which will produce the desired report by calling the methods from this class.	
 * @return the final report
 */
public String getReport()
	{
		String report = String.format("%s\nSTATISTICAL\n%s\n%s\n%s", tableOfComp(),
										getsListSize(), topScorer(), scoreFrequency());
		return report;	
	}

/**
 * This method generates a table/list of all the swimmers.
 * @return a display of swimmers, their full and short details.
 */
public String tableOfComp()
{
	String details = "";
	details = String.format("Number\t\tName\t\tLevel\t\tAge\t\tScores\t\t\tOverall Score\n");
		
	for(Swimmer s : swimList)
	{
		details = String.format("\t\t%s","\t\t\t%s","\t\t\t%s","\t\t\t%d","\t\t%s","\t\t\t\t%s\n",
										s.getSwimmerNumber(),s.getSwimmerName(),s.getSwimmerLevel(),
										s.getSwimmerAge(),s.getScoreArray(),s.getOverAllScore());
	}
	
	details = details + String.format("\n");
		
	for(Swimmer s : swimList)
	{
		details = details + String.format("\n" + "Full details for %s: \n%s", s.getSwimmerNumber(),s.getFullDetails());
	}
		
	for(Swimmer s : swimList)
	{
		details = details + String.format("\n" + "Short details for %s: \n%s", s.getSwimmerNumber(),s.getShortDetails());
	}
	return details;	
}

/**
* This method adds a line to the report showing the number of swimmers.
* @return size of list.
*/
public String getsListSize()
{
	return "\nThere are " + swimList.size() + " Swimmers in this competition.\n";
}

/**
* A method that will return the name of the swimmer who has the highest overall score
* @return the name of the swimmer
*/	
public String topScorer()
{

	String topReport = "";
	Double max = 0.0;
	String name;			
		
	for(Swimmer s : swimList)
		{
			if(max < s.getOverAllScore())								
			{
				max = s.getOverAllScore();								
				name = s.getSwimmerName().getFullName();
				topReport = name + " has the highest overall score";
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
	for (Swimmer s : swimList)
	{
		for(int f : s.getScoreArray())
		{
			freq[f]++;
		}
	}
	
	String freqReport = String.format("\nScore: ","\t\t0\t\t1\t\t2\t\t3\t\t4\t\t5\n",
										"Frequency: \t");
	for (int i : freq)
	{
		freqReport = freqReport + "\t" + i;
	}
	return freqReport;
}


public void writeToFile(String filename, String report)
{
	FileWriter fw;
	try
	{
		fw = new FileWriter(filename);
		fw.write("The report\n");
		fw.write(report);
		fw.close();
	}
	catch(FileNotFoundException fnf)
	{
		System.out.println("A file with this name was not found.");
		System.exit(0);
	}
	catch(IOException ioe)
	{
		ioe.printStackTrace();
		System.exit(1);
	}		
}

public void readFile(String filename, SwimList list)
{
	Scanner sc = null;
	try
	{
		File f = new File(filename);
		sc = new Scanner(f);
	}
	catch(FileNotFoundException e)
	{
	System.out.println(filename + " was not found ");
	System.exit(0);
	}
	
	String line;
	while(sc.hasNextLine())
	{
		line = sc.nextLine();
	if(!line.isBlank()) {
	try
	{
		String [] parts = line.split(",");
		
		String	number	= parts[0].replace(" ", "");
		String	name	= parts[1].trim();
		String 	level	= parts[2].replace(" ","");
		String 	age		= parts[3].replace(" ","");
		Integer[] score = new Integer[5];
		
		int k = 0;
		if(parts.length == 10) {
		for(int i = 5; i < parts.length; i++)
		{
			score[k] = Integer.parseInt(parts[i].trim());
			k++;
		}
		
		Swimmer s = new Swimmer (number, new Name(name), level, age, score);
		list.addSwimmer(s);
		} else
		{
			System.out.println("Error in value entered. Please check again." + line);
		}
	}
	catch(NumberFormatException nfe)
	{
		System.out.println("A number conversion error has occured." + nfe.getMessage());
	}
	catch (ArrayIndexOutOfBoundsException air)
	{
		System.out.println("The file you're trying to process seems to be missing values." + air.getMessage());
	}
	}
}
}		


}
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Manager {

	SwimmerList swimmerList = new SwimmerList();	 

public void readFile() {
				
	File inputFileObject = new File("input.txt"); 
	Scanner scannerObject;
				
	try {
		String[] lines = new String[20];
		scannerObject = new Scanner(inputFileObject);
				
		for(int i=0;scannerObject.hasNextLine();i++)
			{
				lines[i]=scannerObject.nextLine();
			}
					swimmerList.readList(lines);
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}					    
			}		 
		
	
	public static void main(String[] args)
	{
	
	}
}


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

public class Manager {

	SwimmerList swimmerList = new SwimmerList();	 

public void readFile() {
				
	File inputFileObject = new File("input.txt"); 
	Scanner sc;
				
	try {
		String[] lines = new String[20];
		sc = new Scanner(inputFileObject);
				
		for(int i=0;sc.hasNextLine();i++)
			{
				lines[i]=sc.nextLine();
			}
					swimmerList.readList(lines);
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}					    
			}		 
		
public void writeFile() {
	
	 FileWriter  writeFile;

	try {
		writeFile = new FileWriter("output.txt");
		writeFile.write(SwimmerList.getReport());
		writeFile.close();
		
	} catch (IOException e) {
		e.printStackTrace();
	} 
		
			    
}
	
	public static void main(String[] args)
	{
	
	}
}


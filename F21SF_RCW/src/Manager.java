import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

public class Manager {

	SwimmerList swimmerList = new SwimmerList();	 
	public void readFile()
	{							// Using the scanner class to read line by line			
	File doc = new File("input.txt"); 
	Scanner sc;
				
	try {
		String[] file = new String[20];			
		sc = new Scanner(doc);
		
		while(sc.hasNextLine())
		{
			int i=0;
			file[i]=sc.nextLine();
			i++;
		}
		swimmerList.readList(file);					
		} 
		
	catch (FileNotFoundException e)				//If the attempt to open the file has failed, the FileNotFoundException signals it.
	{
		e.printStackTrace();
	}
	}		 
		
public void writeFile() {
	
	 FileWriter writeFile;
	 try{
		writeFile = new FileWriter("output.txt");
		writeFile.write(swimmerList.getReport());
		writeFile.close();
		} 
	 catch(IOException e)
	 {
		e.printStackTrace();
	 }			    
}


public void checkSwimmer(Scanner readInput)
{
	System.out.println("Enter Number: ");
	try 
	{
		int swimmerID = Integer.parseInt(readInput.nextLine());
		System.out.println(this.swimmerList.checkSwimmer(swimmerID));
	}
	catch(NumberFormatException e)
	{
		System.out.println(e);
	}
}
	
	public static void main(String[] args)
	{
	Manager manager = new Manager();
	System.out.println("Enter your Choice:\n1. Read report\n2. Generate Report\n"
						+ "3. Check Scottish Archer Id\n4. Exit\n");
	Scanner sc = new Scanner(System.in);
	
		int n = 2;
		
		switch(n) {
		
		case 1:
				manager.readFile();
				break;
		case 2:
				manager.writeFile();
				break;
		case 3:
				manager.checkSwimmer(sc);
				break;
		default:
				sc.close();
		}
	}
}


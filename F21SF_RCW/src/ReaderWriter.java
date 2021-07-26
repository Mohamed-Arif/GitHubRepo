import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReaderWriter 
{	
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
		System.out.println(filename + " not found ");
		System.exit(0);
		}
		
		String line = null;
		while(sc.hasNextLine())
		{
			line = sc.nextLine();
		try
		{
			String [] parts = line.split(",");
			
			String	number	= parts[0].trim();
			String	name	= parts[1];
			String 	level	= parts[2].trim();
			String 	age		= parts[3].trim();
			Integer[] score = new Integer[4];
			
			int k = 0;
			
			for(int i = 0; i < parts.length; i++)
			{
				score[k] = Integer.parseInt(parts[4].trim());
				k++;
			}
			
			Swimmer s = new Swimmer (number, new Name(name), level, age, score);
			list.addSwimmer(s);
			
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

	public void writeFile(String filename, String report)
	{
		FileWriter fw;
		try
		{
			fw = new FileWriter(filename);
			fw.write(report);
			fw.close();
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("A file with this name was not found.");
			System.exit(0);
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
			System.exit(1);
		}		
	}
}
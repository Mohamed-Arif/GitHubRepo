import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SwimmerList {
	
private Swimmer[] SwimmerArray = new Swimmer[15];
int size = 0;

public void readList(String[] lines)
{
	for (int i = 0; lines[i] != null;i++)
	{ 
		String words [] = lines[i].split(", ");
		int intScores [] = new int[5];
		String strScores [] = words[5].split(",");
		
		for(int j = 0; j< strScores.length; j++)
		{
			intScores[j]= Integer.parseInt(strScores[j]);
		}
	}
	this.SwimmerArray[i] = new Swimmer(Integer.parseInt(words[0]),words[1],
			Integer.parseInt(words[2]), words[3], words[4], intScores);
}
}

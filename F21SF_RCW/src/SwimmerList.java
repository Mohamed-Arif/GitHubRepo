import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SwimmerList {
	
private Swimmer[] SwimmerArray = new Swimmer[15];
//int size = 0;

public void readList(String[] lines)
{
	for (int i = 0; lines[i] != null;i++)
	{ 
		String word [] = lines[i].split(", ");
		int nScores [] = new int[5];
		String sScores [] = word[5].split(",");
		
		for(int j = 0; j< sScores.length; j++)
		{
			nScores[j]= Integer.parseInt(sScores[j]);
		}
	
	this.SwimmerArray[i] = new Swimmer(Integer.parseInt(word[0]), word[1], word[2], Integer.parseInt(word[3]), nScores);
	}
}

public String detailedReport()
{
	String details = "";
	details = String.format("%-40s%-20s%-20s%-20s%-20s%s\n", "Competitiors","Age","Level","Scores","Overall Score");
	
	for(int i = 0; i<SwimmerArray.length;i++)
	{
		if(SwimmerArray[i] != null)
		{
			details = String.format("%-40s%-20s%-20s%-20s%-20s%s\n",SwimmerArray[i].getSwimmerNumber(),
						SwimmerArray[i].getSwimmerName(),SwimmerArray[i].getSwimmerAge(),SwimmerArray[i].getSwimmerLevel(),
						SwimmerArray[i].getScoreArray(),SwimmerArray[i].getOverAllScore());
		}
	}

	details = details + String.format("\n","");
	for(int i=0; i < this.SwimmerArray.length;i++)
	{
		if(SwimmerArray[i] != null)
		{
			details = details + String.format("Full Details for %d:\n%s\n", SwimmerArray[i].getSwimmerNumber(),
					SwimmerArray[i].getFullDetails());
		}
	}

	for(int i=0; i < this.SwimmerArray.length;i++)
	{
		if(SwimmerArray[i] != null)
		{
			details = details + String.format("Short Details for %d:\n%s\n", SwimmerArray[i].getSwimmerNumber(),
					SwimmerArray[i].getShortDetails());
		}
	}
	
	return details;
}

public String topScorer()
{
	String report = "";
	Double topScore = 0.0;
	int k = 0;
	int count = 0;
	
	for(int i =0; i < this.SwimmerArray.length; i++)
	{
		if(SwimmerArray[i] != null)
		{
			if(topScore < SwimmerArray[i].getOverAllScore())
			{
				topScore = SwimmerArray[i].getOverAllScore();
				k = 0;
			}
		}
	}
	
	report = String.format("STATISTICAL\nThere are %d Compitiors\n",count);
	
	if(count != 0)
	{
		report = report + String.format("The top score is %.1f and it has been scored by %s.\n",
										SwimmerArray[k].getOverAllScore(), SwimmerArray[k].getSwimmerName().getFullName());
	}
	
	return report;
}

public String getReport()
{
	@SuppressWarnings("unused")
	String report = String.format("%s\n%s\n%s", detailedReport(), topScorer());
	
return "5";	
}

public String findSwimmer(int SwimmerNumber)
{
	for(int i=0; i<this.SwimmerArray.length;i++)
	{
		
		if(SwimmerArray[i]!=null)
		{
			if(SwimmerNumber==SwimmerArray[i].getSwimmerNumber())
			{
				return "The Competitor with this number has registered for the event.";
			}	
		}			
	}
	return "A Competitor with this number has not registered for the event. ";
}

}

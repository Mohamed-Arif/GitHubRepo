import java.util.ArrayList;

public class SwimmerList {

private ArrayList<Swimmer> SwimmerList = new ArrayList<>();
private Swimmer[] SwimmerArray = new Swimmer[15];

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
	
	this.SwimmerArray[i] = new Swimmer((word[0], word[1], word[2], Integer.parseInt(word[3]), nScores);
	}
}

public String getReport()
{
	String report = String.format("%s\n%s\n%s", detailedReport(), topScorer(), numSwimmers());
	return report;	
}

public String detailedReport()
{
	String details = "";
	details = String.format("%-30s%-30s%-20s%-20s%s\n", "Competitiors","Age","Level","Scores","Overall Score");
	
	for(int i = 0; i<SwimmerArray.length;i++)
	{
		if(SwimmerArray[i] != null)
		{
			details = String.format("%-30s%-30s%-20s%-20s%s\n",SwimmerArray[i].getSwimmerNumber(),
						SwimmerArray[i].getSwimmerName(),SwimmerArray[i].getSwimmerAge(),SwimmerArray[i].getSwimmerLevel(),
						SwimmerArray[i].getScoreArray(),SwimmerArray[i].getOverAllScore());
		}
	}
	details = details + String.format("\n");
	
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
	int top = 0;
	
	for(int i =0; i < this.SwimmerArray.length; i++)
	{
		if(SwimmerArray[i] != null)
		{
			if(topScore < SwimmerArray[i].getOverAllScore())
			{
				topScore = SwimmerArray[i].getOverAllScore();
				top = i;
				report = report + String.format("STATISTICAL\nThe top score is %.1f and it has been scored by %s.\n", 
						SwimmerArray[top].getOverAllScore(), SwimmerArray[top].getSwimmerName().getFullName());
			}
		}
	}
	
	return report;
}

public String numSwimmers(){
    return "There are " + SwimmerArray.length + " Swimmers" + "\n";
}

public String checkSwimmer(int SwimmerNumber)
{
	for(int i=0; i<this.SwimmerArray.length;i++)
	{
		if(SwimmerArray[i]!=null && SwimmerNumber==SwimmerArray[i].getSwimmerNumber())
		{
				return SwimmerArray[i].getShortDetails();		// change i to SwimmerNumber if it doesn't work
			}	
		}			
	return null;
}
}

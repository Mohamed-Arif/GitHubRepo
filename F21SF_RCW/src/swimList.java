import java.util.ArrayList;

public class swimList {

	public ArrayList <Swimmer> swimList;
	
	public swimList()
	{
		swimList = new ArrayList<Swimmer>();
	}

	public void addSwimmer(Swimmer s)
	{
		String no = s.getSwimmerNumber();
				
	}

	/*
	 * 
	 * 
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


	public String getSize()
	{
		return "There are " + swimList.size() + " Swimmers in this competition.";
	}

	public String tableOfComp()
	{
		String details = "";
		details = String.format("Number\t\tName\t\t\tLevel\t\t\tAge\t\tScores\t\t\t\tOverall Score\n");
		
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





}

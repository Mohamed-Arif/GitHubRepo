
public class test {

	public static void main (String[]args) {
	
		Integer[] ScoreArray = {5, 3, 4, 3, 5};
		String SwimmerLevel = "Gold";
	
		Swimmer s1 = new Swimmer("77", new Name("Valterri Bottas"), SwimmerLevel, "29" ,ScoreArray);
	
		System.out.println(s1.getSwimmerNumber());
		System.out.println(s1.getSwimmerName().getFullName());
		System.out.println(s1.getSwimmerLevel());
		System.out.println(s1.getSwimmerAge());
		System.out.println(s1.getFullDetails());
		System.out.println(s1.getShortDetails());
		System.out.println(s1.getOverAllScore());
		System.out.println("\n");
		
	
		
		Integer[] ScoreArray2 = {5, 5, 4, 5, 5};
		
		Swimmer s2 = new Swimmer("44", new Name("Lewis Hamilton"), SwimmerLevel, "33" ,ScoreArray2);
	
		System.out.println(s2.getSwimmerNumber());
		System.out.println(s2.getSwimmerName().getFullName());
		System.out.println(s2.getSwimmerLevel());
		System.out.println(s2.getSwimmerAge());
		System.out.println(s2.getFullDetails());
		System.out.println(s2.getShortDetails());
		System.out.println(s2.getOverAllScore());
	
	
	}
}

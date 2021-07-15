
public class test {

	public static void main (String[]args) {
	
		int [] ScoreArray = {90, 95, 96, 97, 91};
		String SwimmerLevel = "Gold";
	
		Swimmer phillips = new Swimmer(77, "Valterri Bottas", SwimmerLevel, 29 ,ScoreArray);
	
		System.out.println(phillips.getSwimmerNumber());
		System.out.println(phillips.getSwimmerName().getFullName());
		System.out.println(phillips.getSwimmerLevel());
		System.out.println(phillips.getSwimmerAge());
		System.out.println(phillips.getFullDetails());
		System.out.println(phillips.getShortDetails());
		System.out.println(phillips.getOverAllScoreArray());
		System.out.println();
		
	
	
	
	
	
	
	}
}

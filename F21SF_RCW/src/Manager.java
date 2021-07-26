import java.util.Scanner;

public class Manager {

	public static void main (String[]args)
	{
		SwimList swimmah = new SwimList();
		ReaderWriter rw = new ReaderWriter();
		rw.readFile("input.txt", swimmah);
		
		String report = swimmah.getReport();
		
		rw.writeFile("output.txt", report);
		
		for( int num = 0; num < 3; num++)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the swimmer number to retrieve their details");
			String id = sc.next();
			sc.close();
			if(swimmah.checkSwim(id) != null)
			{
				System.out.println(swimmah.checkSwim(id));
			}
			else
			{
				System.out.println("Please check the number you have entered");
			}
		}
	
	}	
}
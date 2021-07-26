import java.io.File;
import java.util.Scanner;

public class Manager {

	public static void main (String[]args)
	{
		SwimList swimmah = new SwimList();
		ReaderWriter rw = new ReaderWriter();
		rw.readFile("input.txt", swimmah);
		
	
	}
	
	
}


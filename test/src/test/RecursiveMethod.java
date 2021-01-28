package test;

public class RecursiveMethod {

	public static void main(String[] args) {
		
		CountBackwards(10);

	}
	
public static void CountBackwards(int n)
{
	if(n == 0)
	{
		System.out.println("Done!");
	} else {
		System.out.println(n);
		n--;
		CountBackwards(n);
	}
}

}

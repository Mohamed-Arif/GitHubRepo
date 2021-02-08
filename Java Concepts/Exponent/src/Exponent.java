import java.util.Scanner;

public class Exponent {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		int a , b;
		
		System.out.println("Enter Value 1:" );
		a = scan.nextInt();
		
		System.out.println("Enter Value 2:" );
		b = scan.nextInt();
		
		double power = Math.pow(a,b);
		System.out.println("The power is:" +power);

	}

}

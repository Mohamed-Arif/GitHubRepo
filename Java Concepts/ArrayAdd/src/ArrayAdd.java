import java.util.Scanner;

public class ArrayAdd {

	public static void main(String[] args) {
	
		int m , n , i , j;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter no of rows:");
		m = scan.nextInt();
		
		System.out.println("Enter no of columns:");
		n = scan.nextInt();
		
		int a[][] = new int[m][n];
		
		System.out.println("Enter matrix a:");
		for(i=0; i<m; i++)
		{
			for(j=0; j<n; j++)
			{
				a[i][j] = scan.nextInt(); 
			}
		}

		int b[][] = new int[m][n];
		
		System.out.println("Enter matrix b:");
		for(i=0; i<m; i++)
		{
			for(j=0; j<n; j++)
			{
				b[i][j] = scan.nextInt(); 
			}
		}
	
		int c[][] = new int [m][n];
		
		for(i=0; i<m; i++)
		{
			for(j=0; j<n; j++)
			{
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		
		
		System.out.println("The sum is:");
		for(i=0; i<m; i++)
		{
			for(j=0; j<n; j++)
			{
				System.out.print(c[i][j] + "    ");
			}
			System.out.println();
			}
	}
}
			


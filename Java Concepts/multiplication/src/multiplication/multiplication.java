package multiplication;

import java.util.Scanner;

public class multiplication {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
      

        
        for(int i=1; i<=10; i++)
        {
            
           System.out.println(N+" x "+i+" = " +N*i);
        	/*System.out.print(N );
            System.out.print(" x " );
            System.out.print(i);
            System.out.print(" = ");
            
            int pdt = N * i;
            System.out.println(pdt);*/

        }



        scanner.close();
    }
}

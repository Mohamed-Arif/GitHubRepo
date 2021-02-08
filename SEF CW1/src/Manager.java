import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Manager {
	ChessPlayerList chessPlayerList = new ChessPlayerList();
	
	
public void readFile() {
		
		File inputFileObject = new File("input.txt"); 
		Scanner scannerObject;
		
		try {
			String[] lines = new String[20];
			scannerObject = new Scanner(inputFileObject);
			for(int i=0;scannerObject.hasNextLine();i++) {
				lines[i]=scannerObject.nextLine();
			}
			chessPlayerList.readChessPlayerListFile(lines);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
			    
	}
	

	public void writeFile() {
			
		 FileWriter  writeFile;

		try {
			writeFile = new FileWriter("output.txt");
			writeFile.write(chessPlayerList.getReport());
			writeFile.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
			
				    
    }
	
	public void findChessPlayerNumber(Scanner readInput) {
		
		System.out.print("Enter the Chess Player Number: ");
		try {
			
			Integer chessPlayerId = Integer.parseInt(readInput.nextLine());
			System.out.println(this.chessPlayerList.findChessPlayerNumber(chessPlayerId));
			
		}
		
		catch(NumberFormatException e) {
			System.out.println("Invalid Input");
		}
		
	}
	
	
	public static void main(String[] args) {
		   
		Manager manager = new Manager();
		Scanner readInput = new Scanner(System.in);
		while(true) {
			System.out.println("Enter your Choice:\n1. Read report\n2. Generate Report\n"
					+ "3. Check Scottish Archer Id\n4. Exit\n");
			String options = readInput.nextLine();
			
			if(Integer.parseInt(options)==1) {
				manager.readFile();
			}else if(Integer.parseInt(options)==2) {
				manager.writeFile();
			}else if(Integer.parseInt(options)==3) {
				manager.findChessPlayerNumber(readInput);
			}else {
				readInput.close();
				return; 
			}
		}
		

	}
}


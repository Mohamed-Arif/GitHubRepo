import java.util.ArrayList;
import java.util.Scanner;

public class WhileLoops {

	public static void main(String[] args) {

		String sentence = "Water Earth Fire Air";
		Scanner scan = new Scanner(sentence);
		ArrayList words = new ArrayList();

		while (scan.hasNext()) {
			words.add(scan.next());
		}

		System.out.println(words);

	}

}
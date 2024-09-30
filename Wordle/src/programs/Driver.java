package programs;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Game game = new Game("dobby");
		Scanner scanner = new Scanner(System.in);
		boolean done = false;
		String guess, scored;
		
		System.out.println("Wordle:\n__________________________________ \n\nAn"
				+ " uppercase letter: "
				+ "correct letter, correct position \nA letter in parentheses: "
				+ "correct letter, incorrect position \n"
				+ "A lowercase letter: incorrect letter\n______"
				+ "____________________________ \n\n\n");
		
		
		do {
		System.out.println("Enter Guess: ");
		guess = scanner.next();
		scored = game.scoredString(guess);
		
		System.out.println(scored);
		
		if (scored.equals(game.word.toUpperCase())) {
			done = true;
			System.out.println("Congratulations! You guessed the word!");
		}

		} while ((game.attempt <= 5) && (!done));

		if (!scored.equals(game.word.toUpperCase())) {
			System.out.println("Tragically, you have failed.\nThe word was: " + 
		game.word.toLowerCase());
		}
		
		scanner.close();
	}

}

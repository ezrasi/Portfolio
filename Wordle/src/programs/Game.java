package programs;

public class Game {
	
	public String word;
	private StringBuffer wordCopy;
	public int attempt = 1;
	
	
	public Game() {
		this.word = "boots";
		this.attempt = 1;
		this.wordCopy = new StringBuffer("boots");
	}
	
	public Game(String word) {
		this.word = word.toLowerCase().trim();
		this.attempt = 1;
		this.wordCopy = new StringBuffer(word.toLowerCase().trim());
	}
	
	public String scoredString(String str) {
		this.wordCopy.setLength(0);
		this.wordCopy.append(this.word);
		StringBuffer result = new StringBuffer("");
		String resultString;
		if (!Game.isValid(str.trim())) {
			result.append("Invalid input");
			resultString = result.toString();
			return resultString;
		}
		result.append(str.trim().toLowerCase());
		
	//if letter is correct in correct spot, replace that letter in wordCopy
	// with a space so it doesn't get caught in the next for loop
		for (int i = 0; i < 5; i++) {
			char c1 = result.charAt(i);
			char c2 = this.wordCopy.charAt(i);
			if (c1 == c2) {
				c1 = Character.toUpperCase(c1);
				this.wordCopy.replace(i, i+1, " ");
			}
			String replacer = "" + c1;
			result.replace(i, i+1, replacer);
		}
		
	// following checks if there are correct letters in wrong spot	
		for (int i = 0; i < result.length(); i++) {
			char c1 = result.charAt(i);
			if (!Character.isAlphabetic(c1)) {
				continue;
			}
			if (Character.isLowerCase(c1)) {
				for (int j = 0; j < 5; j++) {
					char c2 = this.wordCopy.charAt(j);
					if (c1 == c2) {
						this.wordCopy.replace(j, j+1, " ");
						result.insert(i, "(");
						result.insert(i + 2, ")");
						i += 2;
						break;
					} 
				}
			}
		} 
		
	this.attempt++;
		
		resultString = result.toString();
		return resultString;
	}
	
	
	private static boolean isValid(String str) {
		boolean result = true;
		
		if (!(str.length() == 5)) {
			result = false;
			return result;
		}
		for (int i = 0; i <= 4; i++) {
			char c = str.charAt(i);
			if (!Character.isAlphabetic(c) || Character.isSpace(c)) {
				result = false;
				return result;
			}
		}
		
		return result;
	}
	
}

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		int charPos = -1;
		String output = null;
		boolean firstA = true;

		for (char character : input.toCharArray()) {
			charPos++;
			if (character == 'a' && firstA) {
				output = new String(input.toCharArray()).substring(charPos);
				firstA = false;
			}
		}
		System.out.println(output);
	}
}
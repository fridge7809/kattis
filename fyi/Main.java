import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int number;
		Scanner scanner = new Scanner(System.in);

		number = scanner.nextInt();
		String stringInput = Integer.toString(number);

		if (stringInput.substring(0, 3).equals("555")) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
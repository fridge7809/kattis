import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int x = scanner.nextInt();
		int y = scanner.nextInt();

		boolean isXPositive = util.checkIfPositive(x);
		boolean isYPositive = util.checkIfPositive(y);

		if (isXPositive && isYPositive) {
			System.out.println(1);
		} else if (!isXPositive && isYPositive) {
			System.out.println(2);
		} else if (!isXPositive && !isYPositive) {
			System.out.println(3);
		} else if (isXPositive && !isYPositive) {
			System.out.println(4);
		}
	}
}
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int x = scanner.nextInt();
		int y = scanner.nextInt();
		int n = scanner.nextInt();

		int iteration = 1;
		while (iteration <= n) {
			if (iteration % x == 0 && iteration % y == 0) {
				System.out.println("FizzBuzz");
			} else if (iteration % y == 0) {
				System.out.println("Buzz");
			} else if (iteration % x == 0) {
				System.out.println("Fizz");
			} else {
				System.out.println(iteration);
			}
			iteration++;
		}
	}
}
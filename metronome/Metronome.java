import java.util.Scanner;

public class Metronome{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int input = scanner.nextInt();

		double output = (double) input / 4;

		System.out.println(output);
	}
}
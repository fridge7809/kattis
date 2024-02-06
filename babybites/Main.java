import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		String secondLine = scanner.nextLine();
		String[] array = secondLine.split(" ");
		boolean hasPrinted = false;
		boolean isFishy = false;

		int iteration = 1;
		for (String string : array) {
			if (!string.equals("mumble")) {
				if (Integer.parseInt(string) != iteration) {
					isFishy = true;
				}
			}
			iteration++;
		}
		
		if (isFishy) {
			System.out.println("something is fishy");
		} else if (array.length != n) {
			System.out.println("something is fishy");
		} else  {
			System.out.println("makes sense");
		}
	}
}
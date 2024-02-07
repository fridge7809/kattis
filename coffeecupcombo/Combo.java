import java.util.Scanner;

public class Combo {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = Integer.valueOf(s.nextLine());
		String inputString = s.nextLine();
		char[] charArray = inputString.toCharArray();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Character.getNumericValue(charArray[i]);
		}

		int sum = 0;
		int lec = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				sum = 2; // add
				lec++;
			} else {
				if (sum > 0) {
					lec++;
					sum--;
				}
			}
		}
		System.out.println(lec);
	}
}

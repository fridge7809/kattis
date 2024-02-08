import java.util.Scanner;

public class zoom {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int j = 0;
		int spaces = n / k;
		int[] arr = new int[spaces];
		int collected = 0;
		while (j < n) {
			int idx = j + 1;
			int current = scanner.nextInt();
			if (idx % k != 0) {
				j++;
				continue;
			}
			arr[collected] = current;
			collected++;
			j++;
		}
		for (int p = 0; p < arr.length; p++) {
			System.out.print(arr[p] + " ");
		}
	}
}
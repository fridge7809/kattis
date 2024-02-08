import java.util.Scanner;

public class zoom {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int j = 0;
		int[] arr = new int[n / k];
		int collected = 0;
		while (j < n) {
			int current = scanner.nextInt();
			if ((j + 1) % k != 0) {
				j++;
				continue;
			}
			arr[collected++] = current;
			j++;
		}
		for (int p = 0; p < arr.length; p++) {
			System.out.print(arr[p] + " ");
		}
	}
}
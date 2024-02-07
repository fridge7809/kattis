import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class bitbybit {

	public char[] bitArr;

	public bitbybit(int n) {
		bitArr = new char[n];
		for (int i = 0; i < n; i++) {
			bitArr[i] = '?';
		}
	}

	public void clear(int idx) {
		bitArr[idx] = '0';
	}

	public void set(int idx) {
		bitArr[idx] = '1';
	}

	public void and(int p, int q) {
		if (bitArr[p] == '1' && bitArr[q] == '1') {
			bitArr[p] = '1';
		}
		if (bitArr[p] == '0' && bitArr[q] == '0') {
			bitArr[p] = '0';
		}
		if (bitArr[p] == '?' && bitArr[q] == '?') {
			bitArr[p] = '?';
		}

	}

	public void or(int p, int q) {
		if (bitArr[p] == '1' || bitArr[q] == '1') {
			bitArr[p] = '1';
		}
		if (bitArr[p] == '0' || bitArr[q] == '0') {
			bitArr[p] = '0';
		}
		if (bitArr[p] == '?' || bitArr[q] == '?') {
			bitArr[p] = '?';
		}
	}

	private void print() {
		for (int i = 0; i < bitArr.length; i++) {
			System.out.print(bitArr[i]);
		}
		System.out.print("\n");
	}

	public void reverse() {
		int k = bitArr.length;
		char[] temp = new char[k];
		for (int i = 0; i < bitArr.length; i++) {
			temp[k - 1] = bitArr[i];
			k -= 1;
		}
		bitArr = temp;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		bitbybit bitbybit = new bitbybit(32);

		int ops = 0;
		while (scanner.hasNextInt()) {
			ops = scanner.nextInt();
			if (ops == 0) {
				break;
			}
			scanner.nextLine();
			while (ops > 0) {
				String line = scanner.nextLine();
				String[] arr = line.split(" ");
				String operation = arr[0];
				int first = Integer.parseInt(arr[1]);

				if (arr.length == 3) {
					int second = Integer.parseInt(arr[2]);
					if (operation.equals("AND")) {
						bitbybit.and(first, second);
					}
					if (operation.equals("OR")) {
						bitbybit.or(first, second);
					}
				}

				if (operation.equals("SET")) {
					bitbybit.set(first);
				}
				if (operation.equals("CLEAR")) {
					bitbybit.clear(first);
				}

				ops--;
			}
			bitbybit.reverse();
			bitbybit.print();
			bitbybit.reverse();
		}
	}


}
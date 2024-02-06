import java.util.ArrayList;
import java.util.List;
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
	}

	public void or(int p, int q) {
		if (bitArr[p] == '1' || bitArr[q] == '1') {
			bitArr[p] = '1';
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> instructions = new ArrayList<>();
		bitbybit bitbybit = new bitbybit(32);

		while (scanner.hasNextLine()) {
			instructions.add(scanner.nextLine());
		}
		for (String op : instructions) {
			if (op.length() > 1) {
				String[] arr = op.split(" ");
				if (arr.length == 2) {
					if (arr[0].equals("AND")) {
						bitbybit.and(Integer.valueOf(arr[1]), Integer.valueOf(arr[2]));
					}
					if (arr[0].equals("OR")) {
						bitbybit.or(Integer.valueOf(arr[1]), Integer.valueOf(arr[2]));
					}
				}
				if (arr[0].equals("SET")) {
					bitbybit.set(Integer.valueOf(arr[1]));
				}
				if (arr[0].equals("CLEAR")) {
					bitbybit.clear(Integer.valueOf(arr[1]));
				}
			}
		}
		for (int i = 0; i < bitbybit.bitArr.length; i++) {
			System.out.println(bitbybit.bitArr[i]);
		}
	}
}
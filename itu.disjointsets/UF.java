import java.util.Scanner;

public class UF {

	int[] id;
	int[] size;

	public UF(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
		size = new int[n];
		for (int i = 0; i < n; i++) {
			size[i] = 1;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		UF itu = new UF(N);
		scanner.nextLine();
		while (M > 0) {
			int operation = scanner.nextInt();
			int s = scanner.nextInt();
			int t = scanner.nextInt();
			switch (operation) {
				case 0:
					if (itu.query(s, t)) {
						System.out.println(1);
					} else {
						System.out.println(0);
					}
					break;
				case 1:
					itu.union(s, t);
					break;
				case 2:
					itu.move(s, t);
					break;
				default:
					break;
			}
			M--;
		}
	}

	public boolean query(int s, int t) {
		return find(s) == find(t);
	}

	private int find(int p) {
		if (p != id[p]) {
			id[p] = find(id[p]);
		}
		return id[p];
	}


	public void union(int s, int t) {
		int i = find(s);
		int j = find(t);

		if (i == j) {
			return;
		}

		if (size[i] < size[j]) {
			id[i] = j;
			size[j] += size[i];
		} else {
			id[j] = i;
			size[i] += size[j];
		}
	}

	public void move(int s, int t) {
		int i = find(s);
		int j = find(t);
		int grandparent = id[s];

		// De er i samme set, gør ingenting
		if (i == j) {
			return;
		}

		// Set ny root reference på elementet
		id[s] = j;



	}
}
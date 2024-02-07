import java.util.Scanner;
import java.util.Arrays;

public class Atlogur {

	Knight[] knights;

	public Atlogur(int n) {
		knights = new Knight[n];
	}

	private class Knight {
		int health;
		int strength;

		public Knight(int h, int s) {
			this.health = h;
			this.strength = s;
		}

		public boolean isDead() {
			return health <= 0;
		}

	}

	public void print() {
		for (int i = 0; i < knights.length; i++) {
			System.out.println("knight id: " + i + "\n" + "health: " + knights[i].health + " strength: " + knights[i].strength);
		}
	}

	public void addKnight(int h, int s, int idx) {
		Knight toAdd = new Knight(h, s);
		knights[idx] = toAdd;
	}

	public int findVictor() {

		int victor = 0;
		for (int i = 1; i < knights.length; i++) {
			victor = battle(victor, i);
		}

		return victor + 1;
	}

	public int battle(int first, int second) {
		Knight one = knights[first];
		Knight two = knights[second];

		int attk = 0;
		while (!one.isDead() && !two.isDead()) {
			switch (attk) {
				case 0:
					attack(one, two);
					attk++;
					break;
				case 1:
					attack(two, one);
					attk--;
					break;
			}
		}

		return one.isDead() ? second : first;
	}

	public void attack(Knight from, Knight to) {
		to.health -= from.strength;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Atlogur atlogur = new Atlogur(n);

		scanner.nextLine();

		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine();
			int[] arr = Arrays.stream(line.split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			int health = arr[0];
			int strength = arr[1];
			atlogur.addKnight(health, strength, i);
		}

		System.out.println(atlogur.findVictor());
	}
}
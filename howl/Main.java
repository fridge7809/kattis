import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		StringBuilder modifiedInput = new StringBuilder(input);
		int index = modifiedInput.indexOf("O");
		if (index >= 0) {
			modifiedInput.insert(index + 1, 'O');
		}
		System.out.println(modifiedInput);
	}
}
import java.awt.image.WritableRenderedImage;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int height;
		int width;
		height = scanner.nextInt();
		width = scanner.nextInt();
		System.out.println(0.5*height*width);
	}
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        
        if (first.length() < second.length()) {
            System.out.println("no");
        } else {
            System.out.println("go");
        }
    }
}
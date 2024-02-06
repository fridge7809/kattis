import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\s");
        String month = scanner.next();
        int day = scanner.nextInt();
        
        Calculate result = new Calculate(month, day);
        System.out.println(result.getResult());
    }
}
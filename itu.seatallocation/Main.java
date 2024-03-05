import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import edu.princeton.cs.algs4.MaxPQ;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        MaxPQ<Party> pq = new MaxPQ<Party>(n);

        for (int i = 0; i < n; i++) {
            pq.insert(new Party(Integer.valueOf(scanner.nextLine()), i));
        }

        for (int i = 0; i < m; i++) {
            Party party = pq.delMax();
            party.allocateSeat();
            pq.insert(party);
        }

        for (Party party : pq) {
            System.out.println(party.getSeatsAllocated());
        }

    }
}

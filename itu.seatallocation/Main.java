import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import edu.princeton.cs.algs4.MaxPQ;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        Party[] parties = new Party[n];
        MaxPQ<Party> pq = new MaxPQ<Party>(n);

        for (int i = 0; i < n; i++) {
            Party item = new Party(Integer.valueOf(scanner.nextLine()), i);
            parties[i] = item;
            pq.insert(item);
        }

        for (int i = 0; i < m; i++) {
            Party party = pq.delMax();
            party.allocateSeat();
            pq.insert(party);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(parties[i].getSeatsAllocated());
        }
    }
}

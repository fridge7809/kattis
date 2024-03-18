import java.util.Scanner;

import edu.princeton.cs.algs4.*;

public class Harmony {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // number of vertices
        int m = scanner.nextInt(); // number of edges
        Graph graph = new Graph(n);
        Stack<Edge> edges = new Stack<Edge>();

        scanner.nextLine();
        for (int i = 0; i < m; i++) {
            String[] parts = scanner.nextLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            int c = Integer.parseInt(parts[2]);
            if (c == 1) {
                graph.addEdge(u, v);
            }
            edges.push(new Edge(u, v, c));
        }

        Bipartite bipartite = new Bipartite(graph);

        if (!bipartite.isBipartite()) {
            System.out.println(0);
            return;
        }

        boolean flag = true;
        for (Edge e : edges) {
            boolean color1 = bipartite.color(e.either());
            boolean color2 = bipartite.color(e.other(e.either()));
            if (e.weight() == 0) {
                flag = (color1 == color2);
                if (!flag) {
                    break;
                }
            }

        }

        System.out.println(flag ? 1 : 0);
    }

}

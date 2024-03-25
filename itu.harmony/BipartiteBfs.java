import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;

public class BipartiteBfs {
    private boolean isBipartite; // is the graph bipartite?
    private boolean[] color; // color[v] gives vertices on one side of bipartition
    private boolean[] seen; // marked[v] = true iff v has been visited in DFS
    private int[] edgeTo; // edgeTo[v] = last edge on path to v
    private Stack<Integer> cycle; // odd-length cycle

    /**
     * Determines whether an undirected graph is bipartite and finds either a
     * bipartition or an odd-length cycle.
     *
     * @param G the graph
     */
    public BipartiteBfs(Graph G) {
        isBipartite = true;
        color = new boolean[G.V()];
        seen = new boolean[G.V()];
        edgeTo = new int[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if (!seen[v]) {
                dfs(G, v);
            }
        }
        assert check(G);
    }

    private void dfs(Graph g, int v) {
        Stack<Integer> q = new Stack<Integer>();
        q.push(v);

        while (!q.isEmpty()) {
            int u = q.pop();
            seen[u] = true;

            for (int adj : g.adj(u)) {

                if (cycle != null)
                    return;

                if (!seen[adj]) {
                    q.push(adj);
                    color[adj] = !color[u];
                    edgeTo[adj] = u;
                }

                if (color[adj] == color[u]) {
                    isBipartite = false;
                }

            }
        }
    }

    /**
     * Returns true if the graph is bipartite.
     *
     * @return {@code true} if the graph is bipartite; {@code false} otherwise
     */
    public boolean isBipartite() {
        return isBipartite;
    }

    /**
     * Returns the side of the bipartite that vertex {@code v} is on.
     *
     * @param v the vertex
     * @return the side of the bipartition that vertex {@code v} is on; two vertices
     *         are in the same side of the bipartition if and only if they have the
     *         same color
     * @throws IllegalArgumentException      unless {@code 0 <= v < V}
     * @throws UnsupportedOperationException if this method is called when the graph
     *                                       is not bipartite
     */
    public boolean color(int v) {
        validateVertex(v);
        if (!isBipartite)
            throw new UnsupportedOperationException("graph is not bipartite");
        return color[v];
    }

    /**
     * Returns an odd-length cycle if the graph is not bipartite, and
     * {@code null} otherwise.
     *
     * @return an odd-length cycle if the graph is not bipartite
     *         (and hence has an odd-length cycle), and {@code null}
     *         otherwise
     */
    public Iterable<Integer> oddCycle() {
        return cycle;
    }

    private boolean check(Graph G) {
        // graph is bipartite
        if (isBipartite) {
            for (int v = 0; v < G.V(); v++) {
                for (int w : G.adj(v)) {
                    if (color[v] == color[w]) {
                        System.err.printf("edge %d-%d with %d and %d in same side of bipartition\n", v, w, v, w);
                        return false;
                    }
                }
            }
        }

        // graph has an odd-length cycle
        else {
            // verify cycle
            int first = -1, last = -1;
            for (int v : oddCycle()) {
                if (first == -1)
                    first = v;
                last = v;
            }
            if (first != last) {
                System.err.printf("cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }

        return true;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = seen.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }
}
class HamiltonianCycle {
    private static int V;
    private static int[] path;

    static boolean isSafe(int v, int[][] graph, int pos) {
        if (graph[path[pos - 1]][v] == 0)
            return false;

        for (int i = 0; i < pos; i++) {
            if (path[i] == v)
                return false;
        }

        return true;
    }

    static boolean hamCycleUtil(int[][] graph, int pos) {
        if (pos == V)
            return graph[path[pos - 1]][path[0]] == 1;

        for (int v = 1; v < V; v++) {
            if (isSafe(v, graph, pos)) {
                path[pos] = v;

                if (hamCycleUtil(graph, pos + 1))
                    return true;

                path[pos] = -1;
            }
        }

        return false;
    }

    static void solve(int[][] graph) {
        V = graph.length;
        path = new int[V];

        for (int i = 0; i < V; i++)
            path[i] = -1;

        path[0] = 0;

        if (!hamCycleUtil(graph, 1)) {
            System.out.println("Solution does not exist!");
            return;
        }

        System.out.println("Hamiltonian cycle exists:");
        for (int i = 0; i < V; i++) {
            System.out.print(path[i] + " -> ");
        }
        System.out.println(path[0]);
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 0, 1},
            {1, 0, 1, 1},
            {0, 1, 0, 1},
            {1, 1, 1, 0}
        };

        solve(graph);
    }
}
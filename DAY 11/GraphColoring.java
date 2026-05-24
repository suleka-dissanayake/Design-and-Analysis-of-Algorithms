public class GraphColoring {

    static int V = 4;
    static int[] color = new int[V];

    static boolean isSafe(int v, int[][] graph, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && color[i] == c) {
                return false;
            }
        }
        return true;
    }

    static boolean graphColor(int[][] graph, int m, int v) {
        if (v == V) {
            return true;
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(v, graph, c)) {
                color[v] = c;

                if (graphColor(graph, m, v + 1)) {
                    return true;
                }

                color[v] = 0;
            }
        }

        return false;
    }

    static void solve(int[][] graph, int m) {
        if (graphColor(graph, m, 0)) {
            System.out.println("Solution Exists");

            for (int i = 0; i < V; i++) {
                System.out.println("Vertex " + i + " -> Color " + color[i]);
            }
        } else {
            System.out.println("Solution does not exist");
        }
    }

    public static void main(String[] args) {

        int[][] graph = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0}
        };

        int m = 3;

        solve(graph, m);
    }
}
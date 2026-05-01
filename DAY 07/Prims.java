class Prims{
    static final int INF = 999999;

    static void prim(int V, int[][] G) {
        boolean[] selected = new boolean[V];
        selected[0] = true;

        int no_edge = 0;
        int cost = 0;

        System.out.println("Edges in MST:");

        while (no_edge < V - 1) {
            int min = INF;
            int x = 0, y = 0;

            for (int i = 0; i < V; i++) {
                if (selected[i]) {
                    for (int j = 0; j < V; j++) {
                        if (!selected[j] && G[i][j] != 0) {
                            if (G[i][j] < min) {
                                min = G[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }

            System.out.println(x + " - " + y + " : " + G[x][y]);
            cost += G[x][y];
            selected[y] = true;
            no_edge++;
        }

        System.out.println("Total cost: " + cost);
    }

    public static void main(String[] ar) {
        int V = 5;
        int[][] G = {
            {0, 2, 3, 6, 0},
            {2, 0, 8, 4, 6},
            {8, 7, 3, 1, 0},
            {3, 7, 0, 9, 4},
            {4, 9, 2, 7, 5}
        };

        prim(V, G);
    }
}
class Kruskal{
    static final int INF = 999999;
    static int[] parent;

    static int find(int i) {
        while(parent[i] != i)
            i = parent[i];
        return i;
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        parent[rootA] = rootB;
    }

    public static void kruskal(int V, int[][] cost) {
        parent = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        int edge_count = 0;
        int mincost = 0;

        System.out.println("Edges in MST:");

        while (edge_count < V - 1) {
            int min = INF;
            int a = -1, b = -1;

            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (i != j && cost[i][j] != INF) {
                        if (find(i) != find(j) && cost[i][j] < min) {
                            min = cost[i][j];
                            a = i;
                            b = j;
                        }
                    }
                }
            }

            union(a, b);
            System.out.println(a + " - " + b + " : " + min);
            mincost += min;
            edge_count++;
        }

        System.out.println("Total cost: " + mincost);
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] cost = {
            {INF, 10, 6, 5},
            {10, INF, INF, 15},
            {6, INF, INF, 4},
            {5, 15, 4, INF}
        };

        kruskal(V, cost);
    }
}
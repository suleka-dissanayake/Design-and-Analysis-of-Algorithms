import java.util.Scanner;

class Q3 {
	private static int findMinDistanceNode(int[] distances, boolean[] visited, int n) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < n; v++) {
            if (!visited[v] && distances[v] <= min) {
                min = distances[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
	
	private static int findShortestPath(int[][] graph, int n, int src, int dest) {
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[src] = 0;

        for (int count = 0; count < n; count++) {
            int u = findMinDistanceNode(distances, visited, n);
            if (u == -1) break;
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && distances[u] != Integer.MAX_VALUE) {
                    int newDist = distances[u] + graph[u][v];
                    if (newDist < distances[v]) {
                        distances[v] = newDist;
                    }
                }
            }
        }
        return distances[dest];
    }
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] adjMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = sc.nextInt();
            }
        }

        int source = sc.nextInt();
        int destination = sc.nextInt();

        System.out.println(findShortestPath(adjMatrix, n, source, destination));
    }
}

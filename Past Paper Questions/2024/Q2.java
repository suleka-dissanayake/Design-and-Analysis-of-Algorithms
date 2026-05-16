class Q2 {
    static int[][] g = {
            {0,1,1,0,0},
            {1,0,0,1,0},
            {1,0,0,1,1},
            {0,1,1,0,0},
            {0,0,1,0,0}
    };

    static boolean[] visited = new boolean[5];
	
    static void dfs(int x) {

        visited[x] = true;

        System.out.print(x + " ");

        for(int i=0;i<5;i++) {

            if(g[x][i] == 1 && !visited[i]) {

                dfs(i);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Route:");

        dfs(0);
    }
}
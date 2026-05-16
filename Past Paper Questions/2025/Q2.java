class Q2 {
    public static void main(String[] args) {
        int[][] d = {
                {0,50,100,150},
                {50,0,50,100},
                {100,50,0,50},
                {150,100,50,0}
        };

        boolean[] visited = new boolean[4];

        int current = 0;
        int total = 0;

        visited[0] = true;

        System.out.print("Path: 0 ");

        for(int i=1;i<4;i++) {

            int min = 9999;
            int next = -1;

            for(int j=0;j<4;j++) {

                if(!visited[j] &&
                        d[current][j] < min) {

                    min = d[current][j];
                    next = j;
                }
            }

            visited[next] = true;

            total += min;

            System.out.print(next + " ");

            current = next;
        }

        total += d[current][0];

        System.out.println("0");

        System.out.println("Distance = " + total);
    }
}
class Q3 {
    public static void main(String[] args) {
        char[] node =
                {'A','B','C','D','E','F','G',
                 'H','I','J','K','L','M'};

        int[] degree = {3,3,2,4,2,1,3,1,1,1,1,1,1};

        for(int i=0;i<node.length;i++) {
            System.out.println(
                    node[i] + " = " + degree[i]);
        }
    }
}
class Q1A {
    public static void main(String[] args) {
		int a = 0, b = 1, c;
        System.out.print(a + " " + b + " ");
        for(int i=3; i<=28; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}
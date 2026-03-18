class RecursiveSum{
    static int sumBetweenTwo(int a, int b) {
        if (b > a) {
            return b + sumBetweenTwo(a, b - 1);
        }
        return b;
    }

    public static void main(String[] args) {
        int firstNum = 2;
        int secondNum = 8;
        System.out.println("Sum is " + sumBetweenTwo(firstNum, secondNum));
    }
}
class NQueen {
    static final int N = 4;

    static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int[][] board, int row, int column) {
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 1)
                return false;
        }

        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        for (int i = row, j = column; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    static boolean solve(int[][] board, int column) {
        if (column >= N) {
            return true;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, column)) {
                board[i][column] = 1;

                if (solve(board, column + 1))
                    return true;

                board[i][column] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];

        if (!solve(board, 0)) {
            System.out.println("Solution does not exist!");
            return;
        }

        printBoard(board);
    }
}
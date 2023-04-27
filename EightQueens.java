public class EightQueens {
    static final int N = 8;
    
    static boolean isOk(int board[][], int row, int col) {
        int i, j;
        for (i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    static boolean putQueen(int board[][], int row) {
        if (row == N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isOk(board, row, i)) {
                board[row][i] = 1;

                if (putQueen(board, row + 1))
                    return true;

                board[row][i] = 0;
            }
        }
        return false;
    }

    static void printBoard(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String place = board[i][j] == 1 ? "x" : "0";
                System.out.print(place + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int board[][] = new int[N][N];

        if (putQueen(board, 0))
            printBoard(board);
        else
            System.out.println("Коллапс! :)");
    }
}

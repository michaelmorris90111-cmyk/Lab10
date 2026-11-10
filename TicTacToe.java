import java.util.Scanner;

public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static final String[][] board = new String[ROWS][COLS];
    private static String currentPlayer = "X";

    public static void switchPlayer() {
        if (currentPlayer == "X") {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }
    }
    private static void clearBoard()
    {
        for(int row=0; row < ROWS; row++)
        {
            for(int col=0; col < COLS; col++)
            {
                board[row][col] = " "; // make this cell a space
            }
        }
    }
    private static void display(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("[" + board[i][j] + "]");
            }
            System.out.println();
        }
    }
    private static boolean isValidMove(int rowMove, int colMove)
    {
        boolean retVal = false;
        if(board[rowMove][colMove].equals(" "))
            retVal = true;
        return retVal;
    }
    private static boolean isWin(String player)
    {
        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return true;
        }
        return false;
    }
    private static boolean isColWin(String player)
    {
        for(int col=0; col < COLS; col++)
        {
            if(board[0][col].equals(player) && board[1][col].equals(player) &&
                    board[2][col].equals(player))
            {
                return true;
            }
        }
        return false; // no row win
    }
    private static boolean isRowWin(String player)
    {
        for(int row=0; row < ROWS; row++)
        {
            if(board[row][0].equals(player) && board[row][1].equals(player) &&
                    board[row][2].equals(player))
            {
                return true;
            }
        }
        return false;
    }
    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
                || (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean playAgain;
        do {
            clearBoard();
            currentPlayer = "X";
            boolean gameOver = false;

            while (!gameOver) {
                display();
                System.out.println("Player " + currentPlayer + "'s turn");

                int rowMove, colMove;
                do {
                    rowMove = SafeInput.getRangedInt(in, "Input the row of your move (1-3)", 1, 3) - 1;
                    colMove = SafeInput.getRangedInt(in, "Input the column of your move (1-3)", 1, 3) - 1;
                    if (!isValidMove(rowMove, colMove)) {
                        System.out.println("That cell is taken. Try again.");
                    }
                } while (!isValidMove(rowMove, colMove));

                board[rowMove][colMove] = currentPlayer;

                if (isWin(currentPlayer)) {
                    display();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                } else if (isTie()) {
                    display();
                    System.out.println("It's a tie!");
                    gameOver = true;
                } else {
                    switchPlayer();
                }
            }

            playAgain = SafeInput.getYNConfirm(in, "Play again? (y/n): ");
        } while (playAgain);
    }
    private static boolean isTie() {
        boolean full = true;
        for (int row = 0; row < ROWS; row++)
            for (int col = 0; col < COLS; col++)
                if (board[row][col].equals(" "))
                    full = false;
        if (full)
            return true;

        for (int i = 0; i < 3; i++) {
            if (!isDeadLine(board[i][0], board[i][1], board[i][2])) return false;
            if (!isDeadLine(board[0][i], board[1][i], board[2][i])) return false;
        }
        if (!isDeadLine(board[0][0], board[1][1], board[2][2])) return false;
        if (!isDeadLine(board[0][2], board[1][1], board[2][0])) return false;

        return true;
    }

    private static boolean isDeadLine(String a, String b, String c) {
        boolean hasX = a.equals("X") || b.equals("X") || c.equals("X");
        boolean hasO = a.equals("O") || b.equals("O") || c.equals("O");
        return hasX && hasO;
    }
}
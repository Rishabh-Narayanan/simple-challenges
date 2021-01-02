package Challenges.Extra;
import java.util.Scanner;
public class TicTacToe {
    int numRows;
    private char[][] gameBoard;
    public TicTacToe(int rows) {
        numRows = rows;
        gameBoard = new char[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                gameBoard[i][j] = ' ';
            }
        }
    }
    public void setGameBoard(int i, char player) {
        gameBoard[i / numRows][i % numRows] = player;
    }
    public char getGameBoard(int i) {
        return gameBoard[i / numRows][i % numRows];
    }
    public void printBoard() {
        int n = numRows;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" ");
                System.out.print(gameBoard[i][j]);
                System.out.print(" ");
                if (j < n - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < n - 1) {
                for (int j = 0; j < n; j++) {
                    System.out.print("--- ");
                }
            }
            System.out.println();
        }
    }
    public char winner(int n, char c) {
        int col = 0, row = 0, diag = 0, oppdiag = 0;
        for (int i = 0; i < numRows; i++) {
            if (gameBoard[i][n % numRows] == c) {
                col++;
            }
            if (gameBoard[n / numRows][i] == c) {
                row++;
            }
            if (gameBoard[i][i] == c) {
                diag++;
            }
            if (gameBoard[i][numRows - 1 - i] == c) {
                oppdiag++;
            }
        }
        if (col == numRows || row == numRows || diag == numRows || oppdiag == numRows)
            return c;
        return ' ';
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numRows = 3;
        TicTacToe t = new TicTacToe(numRows);
        boolean playerX = false;
        boolean draw = false;
        boolean keepPlaying = true;
        System.out.println("Format of the game:");
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                System.out.printf(" %3s ", i * numRows + j);
                if (j < numRows - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < numRows - 1) {
                for (int j = 0; j < numRows; j++) {
                    System.out.print("----- ");
                }
            }
            System.out.println();
        }
        System.out.println("Choose a number that corresponds to the correct square: \n\n");
        t.printBoard();
        while (keepPlaying) {
            playerX = !playerX;
            if (playerX) {
                System.out.println("Player X's turn");
            } else {
                System.out.println("Player O's turn");
            }
            int square;
            do {
                System.out.println("Which square do you choose?");
                square = scan.nextInt();
            } while (square < 0 || square >= numRows * numRows || t.getGameBoard(square) != ' ');
            if (playerX) {
                t.setGameBoard(square, 'X');
                if (t.winner(square, 'X') == 'X') {
                    keepPlaying = false;
                }
            } else {
                t.setGameBoard(square, 'O');
                if (t.winner(square, 'O') == 'O') {
                    keepPlaying = false;
                }
            }
            int count = 0;
            for (int i = 0; i < numRows * numRows; i++) {
                if (t.getGameBoard(i) != ' ') {
                    count++;
                }
            }
            if (count == numRows * numRows) {
                keepPlaying = false;
                draw = true;
            }
            t.printBoard();
        }
        if (draw) {
            System.out.println("Draw!");
        } else {
            System.out.println("Player " + ((playerX) ? 'X' : 'O') + " wins!");
        }
    }
}
package paquete_Curso_Java_anterior;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        boolean gameOver = false;
        char currentPlayer = 'X';
        int moves = 0;

        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            displayBoard(board);

            System.out.print("Player " + currentPlayer + ", enter a position (0-8): ");
            int position = scanner.nextInt();

            if (isValidMove(board, position)) {
                board[position] = currentPlayer;
                moves++;

                if (checkWin(board, currentPlayer)) {
                    displayBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                } else if (moves == 9) {
                    displayBoard(board);
                    System.out.println("It's a tie!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }

    public static void displayBoard(char[] board) {
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    public static boolean isValidMove(char[] board, int position) {
        return (position >= 0 && position < 9 && board[position] == ' ');
    }

    public static boolean checkWin(char[] board, char player) {
        return (board[0] == player && board[1] == player && board[2] == player) || // Rows
                (board[3] == player && board[4] == player && board[5] == player) ||
                (board[6] == player && board[7] == player && board[8] == player) ||
                (board[0] == player && board[3] == player && board[6] == player) || // Columns
                (board[1] == player && board[4] == player && board[7] == player) ||
                (board[2] == player && board[5] == player && board[8] == player) ||
                (board[0] == player && board[4] == player && board[8] == player) || // Diagonals
                (board[2] == player && board[4] == player && board[6] == player);
    }
}

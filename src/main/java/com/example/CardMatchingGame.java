package com.example;

import java.util.Scanner;

/**
 * 
 * @author Edwin Natnat Jr
 * @version 1.0
 *          This class is the main class of the "Card Matching Game"
 *          application.
 */
public class CardMatchingGame {
    public static String[][] cards = new String[4][4];
    public static String[][] board = new String[4][4];

    public static Scanner scanner = new Scanner(System.in);

    public enum DeckCards {

        A, B, C, D, E, F, G, H;
    }

    public static void printBoard() {

        for (int i = 0; i < 4; i++) {
            System.out.println("    ");
            for (int j = 0; j < 4; j++) {
                System.out.print(board[i][j] + "  |  ");
            }
            System.out.println();
        }
    }

    public static void shuffleDeck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int random = (int) (Math.random() * 8);
                board[i][j] = DeckCards.values()[random].toString();
            }
        }
    }

    public static boolean isValid(String[][] board, int row, int col) {
        if (row < 0 || row > 3 || col < 0 || col > 3) {
            return false;
        }
        if (board[row][col] == null) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        shuffleDeck();
        System.out.println("Welcome to the Card Matching Game!");
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "!");

        // asks user to enter the row and column of the card
        System.out.println("Please enter the row and column of the card you want to flip: ");
        System.out.println("Row: ");
        int row = scanner.nextInt();
        System.out.println("Column: ");
        int col = scanner.nextInt();

        // checks if the user's input is valid, but make sure the user doesn't see the
        // card
        // Make user match two cards of the same type
        if (isValid(board, row, col)) {
            System.out.println("You flipped the card: " + board[row][col]);
            System.out.println("Please enter the row and column of the card you want to flip: ");
            System.out.println("Row: ");
            int row2 = scanner.nextInt();
            System.out.println("Column: ");
            int col2 = scanner.nextInt();
            if (isValid(board, row2, col2)) {
                System.out.println("You flipped the card: " + board[row2][col2]);
                if (board[row][col].equals(board[row2][col2])) {
                    System.out.println("You matched the two cards!");
                    board[row][col] = "x";
                    board[row2][col2] = "x";
                } else {
                    System.out.println("Sorry, you didn't match the two cards!");
                    board[row][col] = "X!";
                    board[row2][col2] = "X!";
                }
            } else {
                System.out.println("Sorry, you didn't enter a valid row and column!");
            }
        } else {
            System.out.println("Sorry, you didn't enter a valid row and column!");
        }
        printBoard();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras.logic;

/**
 *
 * @author luiss
 */
public class Board {

    private char[][] board;

    public Board(char[][] board) {
        this.board = board;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public char getLetter(int row, int col) {
        return board[row][col];
    }

    public int getSize() {
        return board.length;
    }

    public void displayBoard() {
        for (char[] row : board) {
            for (char letter : row) {
                System.out.print(letter + " ");
            }
            System.out.println();
        }
    }
}

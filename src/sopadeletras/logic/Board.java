/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras.logic;

/**
 * Clase que representa un tablero de sopa de letras.
 */
public class Board {

    private char[][] board; // Matriz que representa el tablero de la sopa de letras.

    /**
     * Constructor de la clase Board.
     *
     * @param board La matriz que representa el tablero de la sopa de letras.
     */
    public Board(char[][] board) {
        this.board = board;
    }

    /**
     * Obtiene la matriz que representa el tablero de la sopa de letras.
     *
     * @return La matriz que representa el tablero.
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     * Establece la matriz que representa el tablero de la sopa de letras.
     *
     * @param board La matriz que representa el tablero.
     */
    public void setBoard(char[][] board) {
        this.board = board;
    }

    /**
     * Obtiene la letra en la posición especificada del tablero.
     *
     * @param row La fila de la letra.
     * @param col La columna de la letra.
     * @return La letra en la posición especificada.
     */
    public char getLetter(int row, int col) {
        return board[row][col];
    }

    /**
     * Obtiene el tamaño del tablero (cantidad de filas o columnas).
     *
     * @return El tamaño del tablero.
     */
    public int getSize() {
        return board.length;
    }

    /**
     * Muestra el tablero en la consola.
     */
    public void displayBoard() {
        for (char[] row : board) {
            for (char letter : row) {
                System.out.print(letter + " ");
            }
            System.out.println();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras.logic;

/**
 *
 * @author luiss
 */
public class Graph {

    private int size;
    private boolean[][] adjacencyMatrix;
    private char[][] board;

    public Graph(int length, char[][] board) {
        this.board = board;
        this.size = board.length;
        this.adjacencyMatrix = new boolean[size * size][size * size];
        initializeGraph();
    }

    private void initializeGraph() {
        int n = board.length;

        // Inicializar la matriz de adyacencia
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int nodeIndex = i * n + j;

                // Conectar con las celdas adyacentes
                connectAdjacentNodes(i, j, nodeIndex);
            }
        }
    }

    private void connectAdjacentNodes(int x, int y, int nodeIndex) {
        int n = board.length;
        int[] rowDirections = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colDirections = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int direction = 0; direction < 8; direction++) {
            int newRow = x + rowDirections[direction];
            int newCol = y + colDirections[direction];

            // Verificar límites del tablero
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                int adjacentNodeIndex = newRow * n + newCol;
                adjacencyMatrix[nodeIndex][adjacentNodeIndex] = true;
            }
        }
    }

    public boolean searchWord(String word) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int startNode = i * n + j;
                if (dfs(startNode, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int node, String word, int index, boolean[][] visited) {
        int n = board.length;
        int row = node / n;
        int col = node % n;

        if (index == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= n || col >= n || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;

        for (int neighbor = 0; neighbor < size * size; neighbor++) {
            if (adjacencyMatrix[node][neighbor] && dfs(neighbor, word, index + 1, visited)) {
                return true;
            }
        }

        visited[row][col] = false;
        return false;
    }
}

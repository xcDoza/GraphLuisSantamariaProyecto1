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

    public boolean searchWordDFS(String word) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (dfs(row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= size || col < 0 || col >= size || board[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '*'; // Marca la celda como visitada

        boolean found = dfs(row - 1, col, word, index + 1)
                || dfs(row + 1, col, word, index + 1)
                || dfs(row, col - 1, word, index + 1)
                || dfs(row, col + 1, word, index + 1)
                || dfs(row - 1, col - 1, word, index + 1)
                || dfs(row - 1, col + 1, word, index + 1)
                || dfs(row + 1, col - 1, word, index + 1)
                || dfs(row + 1, col + 1, word, index + 1);

        board[row][col] = temp; // Desmarca la celda

        return found;
    }

    public boolean searchWordBFS(String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (bfs(row, col, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean bfs(int startRow, int startCol, String word) {
        int[] rowDirections = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colDirections = {-1, 0, 1, -1, 1, -1, 0, 1};

        CustomCola<NodePosition> queue = new CustomCola<>();
        queue.enqueue(new NodePosition(startRow, startCol, 0));

        while (!queue.isEmpty()) {
            NodePosition current = queue.dequeue();
            int currentRow = current.getRow();
            int currentCol = current.getCol();
            int currentIndex = current.getIndex();

            if (currentIndex == word.length() - 1) {
                return true;
            }

            board[currentRow][currentCol] = '.'; // Marcar la letra actual como visitada

            for (int d = 0; d < 8; d++) {
                int newRow = currentRow + rowDirections[d];
                int newCol = currentCol + colDirections[d];
                int newIndex = currentIndex + 1;

                if (isValid(newRow, newCol, word, newIndex)) {
                    queue.enqueue(new NodePosition(newRow, newCol, newIndex));
                }
            }
        }

        return false;
    }

    private boolean isValid(int row, int col, String word, int index) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        return true;
    }

    private class NodePosition {

        private int row;
        private int col;
        private int index;

        public NodePosition(int row, int col, int index) {
            this.row = row;
            this.col = col;
            this.index = index;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getIndex() {
            return index;
        }
    }
}

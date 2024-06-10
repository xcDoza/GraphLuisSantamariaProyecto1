/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras.logic;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import sopadeletras.logic.CustomCola;
import sopadeletras.logic.CustomList;

/**
 *
 * @author luiss
 */
public class CustomGraph {

    private Node[][] nodes;

    public CustomGraph(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        nodes = new Node[rows][cols];

        // Inicializar los nodos del grafo
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nodes[i][j] = new Node(board[i][j], i, j);
            }
        }

        // Conectar los nodos
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Node current = nodes[i][j];
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (k >= 0 && k < rows && l >= 0 && l < cols && (k != i || l != j)) {
                            current.addNeighbor(nodes[k][l]);
                        }
                    }
                }
            }
        }
    }

    public boolean searchWordBFS(String word) {
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                if (searchWordBFSFromNode(nodes[i][j], word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWordBFSFromNode(Node startNode, String word) {
        CustomCola<Node> queue = new CustomCola<>();
        CustomList<Node> visitedList = new CustomList<>();
        queue.enqueue(startNode);

        while (!queue.isEmpty()) {
            Node currentNode = queue.dequeue();
            int charIndex = visitedList.size();

            if (charIndex < word.length() && currentNode.getData() == word.charAt(charIndex)) {
                visitedList.add(currentNode);

                if (charIndex == word.length() - 1) {
                    return true; // Se encontró la palabra completa
                }

                // Agregar los nodos vecinos a la cola para seguir buscando
                CustomList<Node> neighbors = currentNode.getNeighbors();
                CustomList.Node<Node> neighborNode = neighbors.getHead();
                while (neighborNode != null) {
                    queue.enqueue(neighborNode.getData());
                    neighborNode = neighborNode.getNext();
                }
            }
        }
        return false;
    }

    public SingleGraph searchWordBFSWithTree(String word) {
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                SingleGraph tree = new SingleGraph("BFS Tree");
                tree.setStrict(false);
                tree.setAutoCreate(true);

                if (searchWordBFSFromNodeWithTree(nodes[i][j], word, tree)) {
                    return tree;
                }
            }
        }
        return null;
    }

    private boolean searchWordBFSFromNodeWithTree(Node startNode, String word, Graph tree) {
        CustomCola<Node> queue = new CustomCola<>();
        CustomList<Node> visitedList = new CustomList<>();
        queue.enqueue(startNode);

        String startId = startNode.getRow() + "," + startNode.getCol();
        tree.addNode(startId).setAttribute("ui.label", startNode.getData());

        while (!queue.isEmpty()) {
            Node currentNode = queue.dequeue();
            int charIndex = visitedList.size();

            if (charIndex < word.length() && currentNode.getData() == word.charAt(charIndex)) {
                visitedList.add(currentNode);

                if (charIndex == word.length() - 1) {
                    return true; // Se encontró la palabra completa
                }

                // Agregar los nodos vecinos a la cola para seguir buscando
                CustomList<Node> neighbors = currentNode.getNeighbors();
                CustomList.Node<Node> neighborNode = neighbors.getHead();
                while (neighborNode != null) {
                    Node neighbor = neighborNode.getData();
                    if (!visitedList.contains(neighbor) && !queue.contains(neighbor)) {
                    queue.enqueue(neighbor);
                    visitedList.add(neighbor);

                        String neighborId = neighbor.getRow() + "," + neighbor.getCol();
                        tree.addNode(neighborId).setAttribute("ui.label", neighbor.getData());
                        tree.addEdge(currentNode.getRow() + "," + currentNode.getCol() + "-" + neighborId,
                                currentNode.getRow() + "," + currentNode.getCol(), neighborId);
                    }
                    neighborNode = neighborNode.getNext();
                }
            }
        }
        return false;
    }
    
    public boolean searchWordDFS(String word) {
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[0].length; j++) {
                Node currentNode = nodes[i][j];
                if (currentNode.getData() == word.charAt(0)) {
                    // Iniciar la búsqueda de la palabra desde el nodo actual
                    CustomList<Node> visitedList = new CustomList<>();
                    if (searchWordDFSFromNode(currentNode, word, 0, visitedList)) {
                        return true; // La palabra fue encontrada
                    }
                }
            }
        }
        return false;
    }

    private boolean searchWordDFSFromNode(Node currentNode, String word, int index, CustomList<Node> visitedList) {
        if (index == word.length() - 1) {
            return true; // Se encontró la palabra completa
        }

        visitedList.add(currentNode);

        CustomList<Node> neighbors = currentNode.getNeighbors();
        CustomList.Node<Node> neighborNode = neighbors.getHead();
        while (neighborNode != null) {
            Node neighbor = neighborNode.getData();
            if (!visitedList.contains(neighbor) && neighbor.getData() == word.charAt(index + 1)) {
                if (searchWordDFSFromNode(neighbor, word, index + 1, visitedList)) {
                    return true;
                }
            }
            neighborNode = neighborNode.getNext();
        }

        visitedList.remove(currentNode);
        return false;

    }

    public class Node {

        private char data;
        private int row;
        private int col;
        private CustomList<Node> neighbors;

        public Node(char data, int row, int col) {
            this.data = data;
            this.row = row;
            this.col = col;
            this.neighbors = new CustomList<>();
        }

        public char getData() {
            return data;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public void addNeighbor(Node neighbor) {
            this.neighbors.add(neighbor);
        }

        public CustomList<Node> getNeighbors() {
            return neighbors;
        }
    }
}

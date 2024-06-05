/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sopadeletras;

import sopadeletras.logic.CustomList;
import sopadeletras.util.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import sopadeletras.logic.Node;
import sopadeletras.logic.WordSearch;

/**
 *
 * @author luiss
 */
public class SopaDeLetras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CustomList<String> dictionary = new CustomList<>();
        char[][] board = new char[4][4];

        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                dictionary = FileUtils.loadDictionary(selectedFile);
                board = FileUtils.loadBoard(selectedFile);

                // Imprimir el diccionario cargado
                System.out.println("Dictionary:");
                Node<String> current = dictionary.getHead();
                while (current != null) {
                    System.out.println(current.getData());
                    current = current.getNext();
                }

                // Imprimir el tablero cargado
                System.out.println("Board:");
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        System.out.print(board[i][j] + " ");
                    }
                    System.out.println();
                }

                Scanner scanner = new Scanner(System.in);
                System.out.println("Seleccione el método de búsqueda (DFS o BFS):");
                String searchMethod = scanner.nextLine().toUpperCase();

                // Crear instancia de WordSearch con el diccionario y el tablero cargados
                WordSearch wordSearch = new WordSearch(selectedFile, selectedFile, searchMethod);

                // Buscar palabras en el tablero
                long startTime = System.currentTimeMillis();
                wordSearch.findWords(dictionary, searchMethod);
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                System.out.println("Tiempo total en encontrar todas las palabras: " + elapsedTime + " milisegundos");

                // Buscar una palabra específica
                System.out.println("Ingrese una palabra para buscar en el tablero:");
                String specificWord = scanner.nextLine();
                wordSearch.findSpecificWord(specificWord);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

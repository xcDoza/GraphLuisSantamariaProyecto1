/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sopadeletras;

import sopadeletras.logic.CustomList;
import sopadeletras.logic.CustomList.Node;
import sopadeletras.util.FileUtils;
import javax.swing.JFileChooser;
import sopadeletras.logic.WordSearch;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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

                // Configurar y crear el objeto WordSearch
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingrese el método de búsqueda (BFS/DFS):");
                String searchMethod = scanner.nextLine();

                WordSearch wordSearch = new WordSearch(selectedFile, selectedFile, searchMethod);

                // Llamar al método findWords para encontrar todas las palabras
                wordSearch.findWords();

                // Buscar una palabra específica
                while (true) {
                    System.out.println("Ingrese una palabra para buscar en el tablero (o 'salir' para terminar):");
                    String specificWord = scanner.nextLine();
                    
                    if ("salir".equalsIgnoreCase(specificWord)) {
                        break;
                    }

                    if (!wordSearch.findSpecificWord(specificWord)) {
                        System.out.println("La palabra " + specificWord + " no se encontró en el tablero.");
                        System.out.println("¿Desea agregar la palabra al diccionario? (s/n):");
                        String addWord = scanner.nextLine();
                        if ("s".equalsIgnoreCase(addWord)) {
                            wordSearch.addToDictionary(specificWord);
                            FileUtils.saveDictionary(wordSearch.getDictionary(), selectedFile);
                            System.out.println("La palabra " + specificWord + " ha sido agregada al diccionario.");
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

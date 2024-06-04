/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sopadeletras;

import sopadeletras.logic.CustomList;
import sopadeletras.util.FileUtils;
import java.io.File;
import java.io.IOException;
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
                for (int i = 0; i < dictionary.size(); i++) {
                    System.out.println(dictionary.get(i));
                }

                // Imprimir el tablero cargado
                System.out.println("Board:");
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        System.out.print(board[i][j] + " ");
                    }
                    System.out.println();
                }

                // Crear instancia de WordSearch con el diccionario y el tablero cargados
                WordSearch wordSearch = new WordSearch(selectedFile, selectedFile);

                // Buscar palabras en el tablero
                long startTime = System.currentTimeMillis();
                wordSearch.findWords(dictionary);
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                System.out.println("Tiempo total en encontrar todas las palabras: " + elapsedTime + " milisegundos");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

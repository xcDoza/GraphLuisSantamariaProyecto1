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

/**
 * Clase principal que gestiona la carga de archivos y la búsqueda de palabras en una sopa de letras.
 */
public class SopaDeLetras {
    
    /** 
     * @param args the command line arguments 
     */ 
    private File dictionaryFile; // Archivo que contiene el diccionario de palabras.
    private File boardFile; // Archivo que contiene el tablero de la sopa de letras.
    private WordSearch wordSearch; // Objeto utilizado para realizar la búsqueda de palabras.

    /**
     * Carga los archivos de diccionario y tablero.
     *
     * @param dictionaryFile Archivo que contiene el diccionario de palabras.
     * @param boardFile Archivo que contiene el tablero de la sopa de letras.
     */
    public void cargarArchivos(File dictionaryFile, File boardFile) {
        this.dictionaryFile = dictionaryFile;
        this.boardFile = boardFile;
    }

    /**
     * Busca palabras en la sopa de letras utilizando un método de búsqueda especificado.
     *
     * @param metodoBusqueda El método de búsqueda a utilizar (BFS o DFS).
     */
    public void buscarPalabras(String metodoBusqueda) {
        if (this.dictionaryFile == null || this.boardFile == null) {
            System.err.println("Los archivos de diccionario y tablero no están cargados.");
            return;
        }
        try {
            this.wordSearch = new WordSearch(dictionaryFile, boardFile, metodoBusqueda);
            this.wordSearch.findWords();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al crear WordSearch: " + e.getMessage());
        }
    }
}
    
    ///Main para probar los metodos, todos funcionan
    
//    public static void main(String[] args) { 
//        CustomList<String> dictionary = new CustomList<>(); 
//        char[][] board = new char[4][4]; 
// 
//        JFileChooser fileChooser = new JFileChooser(); 
//        int result = fileChooser.showOpenDialog(null); 
//        if (result == JFileChooser.APPROVE_OPTION) { 
//            File selectedFile = fileChooser.getSelectedFile(); 
//            try { 
//                dictionary = FileUtils.loadDictionary(selectedFile); 
//                board = FileUtils.loadBoard(selectedFile); 
// 
//                // Imprimir el diccionario cargado 
//                System.out.println("Dictionary:"); 
//                Node<String> current = dictionary.getHead(); 
//                while (current != null) { 
//                    System.out.println(current.getData()); 
//                    current = current.getNext(); 
//                } 
// 
//                // Imprimir el tablero cargado 
//                System.out.println("Board:"); 
//                for (int i = 0; i < 4; i++) { 
//                    for (int j = 0; j < 4; j++) { 
//                        System.out.print(board[i][j] + " "); 
//                    } 
//                    System.out.println(); 
//                } 
// 
//                // Configurar y crear el objeto WordSearch 
//                Scanner scanner = new Scanner(System.in); 
//                System.out.println("Ingrese el método de búsqueda (BFS/DFS):"); 
//                String searchMethod = scanner.nextLine(); 
// 
//                WordSearch wordSearch = new WordSearch(selectedFile, selectedFile, searchMethod); 
// 
//                // Llamar al método findWords para encontrar todas las palabras 
//                wordSearch.findWords(); 
// 
//                // Buscar una palabra específica 
//                while (true) { 
//                    System.out.println("Ingrese una palabra para buscar en el tablero (o 'salir' para terminar):"); 
//                    String specificWord = scanner.nextLine(); 
//                     
//                    if ("salir".equalsIgnoreCase(specificWord)) { 
//                        break; 
//                    } 
// 
//                    if (!wordSearch.findSpecificWord(specificWord)) { 
//                        System.out.println("La palabra " + specificWord + " no se encontró en el tablero."); 
//                        System.out.println("¿Desea agregar la palabra al diccionario? (s/n):"); 
//                        String addWord = scanner.nextLine(); 
//                        if ("s".equalsIgnoreCase(addWord)) { 
//                            wordSearch.addToDictionary(specificWord); 
//                            FileUtils.saveDictionary(wordSearch.getDictionary(), selectedFile); 
//                            System.out.println("La palabra " + specificWord + " ha sido agregada al diccionario."); 
//                        } 
//                    } 
//                } 
//            } catch (IOException e) { 
//                e.printStackTrace(); 
//            } 
//        } 
//    } 
//}



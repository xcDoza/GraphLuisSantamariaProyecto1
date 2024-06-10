/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras.logic;

import org.graphstream.graph.implementations.SingleGraph;
import java.io.File;
import java.io.IOException;
import sopadeletras.util.FileUtils;
import org.graphstream.graph.Graph;

/**
 * Clase que representa la búsqueda de palabras en un tablero. Permite cargar un
 * diccionario y un tablero, y buscar palabras en el tablero.
 */
public class WordSearch {

    private CustomGraph graph; // El grafo que representa el tablero de juego
    private CustomList<String> dictionary; // El diccionario de palabras a buscar
    private String searchMethod; // El método de búsqueda a utilizar (BFS o DFS)

    /**
     * Constructor de la clase WordSearch.
     *
     * @param dictionaryFile El archivo que contiene el diccionario de palabras.
     * @param boardFile El archivo que contiene el tablero de juego.
     * @param searchMethod El método de búsqueda a utilizar (BFS o DFS).
     * @throws IOException Si ocurre un error de lectura en los archivos.
     */
    public WordSearch(File dictionaryFile, File boardFile, String searchMethod) throws IOException {
        this.dictionary = FileUtils.loadDictionary(dictionaryFile);
        char[][] board = FileUtils.loadBoard(boardFile);
        this.graph = new CustomGraph(board);
        this.searchMethod = searchMethod;
    }

    public WordSearch(CustomList<String> dictionary, char[][] board, String selectedMethod) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Busca todas las palabras del diccionario en el tablero.
     */
    public void findWords() {
        for (int i = 0; i < dictionary.size(); i++) {
            String word = dictionary.get(i);
            boolean found;
            if ("BFS".equalsIgnoreCase(searchMethod)) {
                found = graph.searchWordBFS(word);
            } else {
                found = graph.searchWordDFS(word);
            }
            if (found) {
                System.out.println("La palabra " + word + " se encontró en el tablero.");
            } else {
                System.out.println("La palabra " + word + " no se encontró en el tablero.");
            }
        }
    }

    /**
     * Busca una palabra específica en el tablero.
     *
     * @param word La palabra a buscar.
     * @return true si la palabra se encontró, false si no.
     */
    public boolean findSpecificWord(String word) {
        boolean found = graph.searchWordBFS(word);
        if (found) {
            System.out.println("La palabra " + word + " se encontró en el tablero.");
        } else {
            System.out.println("La palabra " + word + " no se encontró en el tablero.");
        }
        return found;
    }

    /**
     * Busca una palabra específica en el tablero y muestra el árbol de
     * búsqueda.
     *
     * @param word La palabra a buscar.
     * @return El árbol de búsqueda.
     */
    public SingleGraph findSpecificWordWithTree(String word) {
        return graph.searchWordBFSWithTree(word);
    }

    /**
     * Guarda una palabra en el diccionario y en el archivo "dictionary.txt".
     *
     * @param word La palabra a guardar en el diccionario.
     */
    public void saveWordToDictionary(String word) {
        if (!dictionary.contains(word)) {
            dictionary.add(word);
            try {
                FileUtils.saveDictionary(dictionary, new File("dictionary.txt"));
            } catch (IOException e) {
                System.err.println("Error al guardar la palabra en el diccionario: " + e.getMessage());
            }
        }
    }

    /**
     * Agrega una palabra al diccionario.
     *
     * @param word La palabra a agregar al diccionario.
     */
    public void addToDictionary(String word) {
        dictionary.add(word);
    }

    /**
     * Obtiene el diccionario de palabras.
     *
     * @return El diccionario de palabras.
     */
    public CustomList<String> getDictionary() {
        return dictionary;
    }

    /**
     * Obtiene las palabras encontradas en el tablero.
     *
     * @return Las palabras encontradas.
     */
    public Iterable<String> getWordsFound() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

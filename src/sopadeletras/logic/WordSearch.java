/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras.logic;

import java.io.File;
import java.io.IOException;
import sopadeletras.util.FileUtils;

/**
 *
 * @author luiss
 */
public class WordSearch {

    private Graph graph;
    private CustomList<String> dictionary;
    private String searchMethod;

    public WordSearch(File dictionaryFile, File boardFile, String searchMethod) throws IOException {
        this.dictionary = FileUtils.loadDictionary(dictionaryFile);
        char[][] board = FileUtils.loadBoard(boardFile);
        this.graph = new Graph(board.length, board);
        this.searchMethod = searchMethod;
    }

    public void findWords(CustomList<String> dictionary, String searchMethod) {
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

    public void findSpecificWord(String word) {
        boolean found = graph.searchWordBFS(word);
        if (found) {
            System.out.println("La palabra " + word + " se encontró en el tablero.");
        } else {
            System.out.println("La palabra " + word + " no se encontró en el tablero.");
        }
    }
}

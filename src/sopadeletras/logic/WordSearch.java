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
 *
 * @author luiss
 */
public class WordSearch {

    private CustomGraph graph;
    private CustomList<String> dictionary;
    private String searchMethod;

    public WordSearch(File dictionaryFile, File boardFile, String searchMethod) throws IOException {
        this.dictionary = FileUtils.loadDictionary(dictionaryFile);
        char[][] board = FileUtils.loadBoard(boardFile);
        this.graph = new CustomGraph(board);
        this.searchMethod = searchMethod;
    }

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

    public boolean findSpecificWord(String word) {
        boolean found = graph.searchWordBFS(word);
        if (found) {
            System.out.println("La palabra " + word + " se encontró en el tablero.");
        } else {
            System.out.println("La palabra " + word + " no se encontró en el tablero.");
        }
        return found;
    }

    public SingleGraph findSpecificWordWithTree(String word) {
        return graph.searchWordBFSWithTree(word);
    }

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

    public void addToDictionary(String word) {
        dictionary.add(word);
    }

    public CustomList<String> getDictionary() {
        return dictionary;
    }
}

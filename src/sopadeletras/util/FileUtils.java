/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras.util;

import sopadeletras.logic.CustomList;
import sopadeletras.logic.CustomArray;
import sopadeletras.logic.CustomList.Node;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase de utilidad para cargar y guardar archivos de diccionario y tablero.
 */
public class FileUtils {

    /**
     * Carga un diccionario desde un archivo.
     *
     * @param file El archivo que contiene el diccionario.
     * @return El diccionario cargado.
     * @throws IOException Si ocurre un error de lectura en el archivo.
     */
    public static CustomList<String> loadDictionary(File file) throws IOException {
        System.out.println("Loading dictionary from file: " + file.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        CustomList<String> dictionary = new CustomList<>();
        String line;
        boolean isReadingDictionary = false;

        while ((line = reader.readLine()) != null) {
            line = line.trim();

            if (line.equals("dic")) {
                isReadingDictionary = true;
                continue;
            } else if (line.equals("/dic")) {
                isReadingDictionary = false;
                continue;
            }

            if (isReadingDictionary) {
                dictionary.add(line);
            }
        }
        reader.close();
        return dictionary;
    }

    /**
     * Carga un tablero desde un archivo.
     *
     * @param file El archivo que contiene el tablero.
     * @return El tablero cargado.
     * @throws IOException Si ocurre un error de lectura en el archivo.
     */
    public static char[][] loadBoard(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        CustomArray boardArray = new CustomArray(16);
        String line;
        boolean isReadingBoard = false;

        while ((line = reader.readLine()) != null) {
            line = line.trim();

            if (line.equals("tab")) {
                isReadingBoard = true;
                continue;
            } else if (line.equals("/tab")) {
                isReadingBoard = false;
                continue;
            }

            if (isReadingBoard) {
                String[] letters = line.split(",");
                for (String letter : letters) {
                    boardArray.add(letter.charAt(0));
                }
            }
        }
        reader.close();

        char[][] board = new char[4][4];
        for (int i = 0; i < 16; i++) {
            board[i / 4][i % 4] = boardArray.get(i);
        }
        return board;
    }

    /**
     * Guarda un diccionario en un archivo.
     *
     * @param dictionary El diccionario a guardar.
     * @param file El archivo en el que se guardará el diccionario.
     * @throws IOException Si ocurre un error al escribir en el archivo.
     */
    public static void saveDictionary(CustomList<String> dictionary, File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.newLine();
            writer.write("dic");
            writer.newLine();
            Node<String> current = dictionary.getHead();
            while (current != null) {
                writer.write(" " + current.getData());
                writer.newLine();
                current = current.getNext();
            }
            writer.write("/dic");
        }
    }
}

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
 *
 * @author luiss
 */
public class FileUtils {

    public static CustomList<String> loadDictionary(File file) throws IOException {
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
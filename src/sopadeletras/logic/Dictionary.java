/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras.logic;

/**
 * Representa un diccionario de palabras.
 * Contiene una lista de palabras almacenadas.
 */
public class Dictionary {
    private CustomList<String> words; // Lista de palabras en el diccionario

    /**
     * Constructor de la clase Dictionary.
     *
     * @param words La lista de palabras del diccionario.
     */
    public Dictionary(CustomList<String> words) {
        this.words = words;
    }

    /**
     * Obtiene la lista de palabras del diccionario.
     *
     * @return La lista de palabras.
     */
    public CustomList<String> getWords() {
        return words;
    }

    /**
     * Establece la lista de palabras del diccionario.
     *
     * @param words La lista de palabras a establecer.
     */
    public void setWords(CustomList<String> words) {
        this.words = words;
    }

    /**
     * Muestra todas las palabras del diccionario en la consola.
     */
    public void displayDictionary() {
        CustomList.Node<String> current = words.getHead();
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
}
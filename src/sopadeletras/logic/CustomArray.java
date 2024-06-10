/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras.logic;

/**
 * Clase que representa un arreglo personalizado de caracteres con capacidad dinámica.
 */
public class CustomArray {
    private char[] elements; // Arreglo que contiene los elementos del CustomArray.
    private int size; // Tamaño actual del CustomArray.

    /**
     * Constructor que inicializa un CustomArray con una capacidad inicial especificada.
     *
     * @param initialCapacity La capacidad inicial del CustomArray.
     */
    public CustomArray(int initialCapacity) {
        elements = new char[initialCapacity];
        size = 0;
    }

    /**
     * Añade un elemento al CustomArray.
     *
     * @param element El elemento a añadir.
     */
    public void add(char element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    /**
     * Obtiene el elemento en la posición especificada del CustomArray.
     *
     * @param index La posición del elemento a obtener.
     * @return El elemento en la posición especificada.
     * @throws IndexOutOfBoundsException Si el índice está fuera de rango.
     */
    public char get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    /**
     * Obtiene el tamaño actual del CustomArray.
     *
     * @return El tamaño actual del CustomArray.
     */
    public int size() {
        return size;
    }

    /**
     * Redimensiona el CustomArray al doble de su tamaño actual.
     */
    private void resize() {
        char[] newArray = new char[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras.logic;

/**
 *
 * @author luiss
 */
public class CustomArray {
    private char[] elements;
    private int size;

    public CustomArray(int initialCapacity) {
        elements = new char[initialCapacity];
        size = 0;
    }

    public void add(char element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    public char get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    public int size() {
        return size;
    }

    private void resize() {
        char[] newArray = new char[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras.logic;

/**
 * Clase que representa un nodo en una lista enlazada.
 *
 * @param <T> El tipo de dato que se almacenará en el nodo.
 */
public class Node<T> {
    private T data; // El dato almacenado en el nodo
    private Node<T> next; // El siguiente nodo en la lista

    /**
     * Constructor de la clase Node.
     *
     * @param data El dato que se almacenará en el nodo.
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Obtiene el dato almacenado en el nodo.
     *
     * @return El dato del nodo.
     */
    public T getData() {
        return data;
    }

    /**
     * Establece el dato almacenado en el nodo.
     *
     * @param data El dato a establecer.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Obtiene el siguiente nodo en la lista.
     *
     * @return El siguiente nodo.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Establece el siguiente nodo en la lista.
     *
     * @param next El siguiente nodo.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
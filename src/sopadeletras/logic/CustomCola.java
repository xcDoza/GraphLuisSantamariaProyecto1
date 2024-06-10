/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras.logic;

/**
 * Clase que representa una cola personalizada genérica.
 *
 * @param <T> El tipo de elementos que contendrá la cola.
 */
public class CustomCola<T> {

    private Node<T> front; // Nodo del frente de la cola.
    private Node<T> rear; // Nodo trasero de la cola.

    /**
     * Clase interna que representa un nodo de la cola.
     *
     * @param <T> El tipo de dato que contendrá el nodo.
     */
    private static class Node<T> {

        T data; // El dato almacenado en el nodo.
        Node<T> next; // Referencia al siguiente nodo en la cola.

        /**
         * Constructor de la clase Node.
         *
         * @param data El dato a almacenar en el nodo.
         */
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Constructor de la clase CustomCola.
     * Crea una cola vacía.
     */
    public CustomCola() {
        this.front = this.rear = null;
    }

    /**
     * Añade un elemento al final de la cola.
     *
     * @param item El elemento a añadir.
     */
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }

    /**
     * Elimina y devuelve el elemento del frente de la cola.
     *
     * @return El elemento en el frente de la cola.
     */
    public T dequeue() {
        if (this.front == null) {
            return null;
        }
        Node<T> temp = this.front;
        this.front = this.front.next;
        if (this.front == null) {
            this.rear = null;
        }
        return temp.data;
    }

    /**
     * Verifica si la cola está vacía.
     *
     * @return true si la cola está vacía, false de lo contrario.
     */
    public boolean isEmpty() {
        return this.front == null;
    }

    /**
     * Verifica si la cola contiene un elemento específico.
     *
     * @param node El elemento a buscar en la cola.
     * @return true si la cola contiene el elemento, false de lo contrario.
     */
    public boolean contains(T node) {
        Node<T> current = front;
        while (current != null) {
            if (current.data.equals(node)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

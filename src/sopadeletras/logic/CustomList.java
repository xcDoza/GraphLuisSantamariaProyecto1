/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras.logic;

/**
 * Una lista personalizada (singly linked list) que almacena elementos genéricos.
 *
 * @param <T> El tipo de elementos que se almacenarán en la lista.
 */
public class CustomList<T> {

    private Node<T> head; // El primer nodo de la lista
    private int size; // El tamaño actual de la lista

    /**
     * Clase interna que representa un nodo en la lista.
     *
     * @param <T> El tipo de datos que el nodo almacenará.
     */
    public static class Node<T> {

        public T data; // El dato almacenado en el nodo
        public Node<T> next; // El siguiente nodo en la lista

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

    /**
     * Constructor de la clase CustomList.
     * Inicializa una lista vacía.
     */
    public CustomList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Añade un elemento al final de la lista.
     *
     * @param data El elemento a añadir.
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Obtiene el primer nodo de la lista.
     *
     * @return El primer nodo de la lista.
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Verifica si la lista contiene un elemento específico.
     *
     * @param data El elemento a buscar.
     * @return true si la lista contiene el elemento, false de lo contrario.
     */
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Elimina la primera ocurrencia de un elemento de la lista, si está presente.
     *
     * @param data El elemento a eliminar.
     */
    public void remove(T data) {
        if (head == null) {
            return;
        }
        if (head.getData().equals(data)) {
            head = head.getNext();
            return;
        }
        Node<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }
    }

    /**
     * Obtiene el elemento en la posición especificada en la lista.
     *
     * @param index La posición del elemento.
     * @return El elemento en la posición especificada.
     * @throws IndexOutOfBoundsException si el índice está fuera de rango.
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Obtiene el tamaño actual de la lista.
     *
     * @return El tamaño de la lista.
     */
    public int size() {
        return size;
    }
}
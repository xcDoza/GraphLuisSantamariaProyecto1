/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras.logic;

/**
 *
 * @author luiss
 */
public class CustomCola<T> {

    private Node<T> front;
    private Node<T> rear;

    private static class Node<T> {

        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public CustomCola() {
        this.front = this.rear = null;
    }

    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }

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

    public boolean isEmpty() {
        return this.front == null;
    }
}

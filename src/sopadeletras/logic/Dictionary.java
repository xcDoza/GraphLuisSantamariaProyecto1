/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras.logic;

/**
 *
 * @author luiss
 */
public class Dictionary {
    private CustomList<String> words;

    public Dictionary(CustomList<String> words) {
        this.words = words;
    }

    public CustomList<String> getWords() {
        return words;
    }

    public void setWords(CustomList<String> words) {
        this.words = words;
    }

    public void displayDictionary() {
        CustomList.Node<String> current = words.getHead();
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

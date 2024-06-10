/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sopadeletras.logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luiss
 */
public class BFSArbol {

    private Node root;
    private List<Node> nodes;

    public BFSArbol(Node root) {
        this.root = root;
        this.nodes = new ArrayList<>();
        this.nodes.add(root);
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public Node getRoot() {
        return root;
    }

    public List<Node> getNodes() {
        return nodes;
    }
}

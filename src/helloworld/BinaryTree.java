/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package helloworld;

import java.util.ArrayList;

/**
 *
 * @author ishay
 */
public class BinaryTree {

    Node root;
    ArrayList<Node> arrayList;

    public BinaryTree() {
        this.arrayList = new ArrayList<>();
    }

    public void addNode(String word, String meaning) {

        // Create a new Node and initialize it
        Node newNode = new Node(word, meaning);

        // If there is no root this becomes root
        if (root == null) {

            root = newNode;

        } else {

            // Set root as the Node we will start
            // with as we traverse the tree
            Node focusNode = root;

            // Future parent for our new Node
            Node parent;

            while (true) {

                // root is the top parent so we start
                // there
                parent = focusNode;

                // Check if the new node should go on
                // the left side of the parent node
                if (word.compareTo(focusNode.word) < 0) {

                    // Switch focus to the left child
                    focusNode = focusNode.leftChild;

                    // If the left child has no children
                    if (focusNode == null) {

                        // then place the new node on the left of it
                        parent.leftChild = newNode;
                        return; // All Done

                    }

                } else { // If we get here put the node on the right

                    focusNode = focusNode.rightChild;

                    // If the right child has no children
                    if (focusNode == null) {

                        // then place the new node on the right of it
                        parent.rightChild = newNode;
                        return; // All Done

                    }

                }

            }
        }

    }

    // All nodes are visited in ascending order
    // Recursion is used to go to one node and
    // then go to its child nodes and so forth
    public void inOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            // Traverse the left node
            inOrderTraverseTree(focusNode.leftChild);

            // Visit the currently focused on node
            System.out.println(focusNode);

            // Traverse the right node
            inOrderTraverseTree(focusNode.rightChild);

        }

    }

    public ArrayList<Node> preorderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            this.arrayList.add(focusNode);

            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);

        }
        return this.arrayList;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }

}

class Node {

    String word;
    String meaning;

    Node leftChild;
    Node rightChild;

    Node(String word, String meaning) {

        this.word = word;
        this.meaning = meaning;

    }

    @Override
    public String toString() {

        return word + " has the meaning" + meaning;

        /*
		 * return name + " has the key " + key + "\nLeft Child: " + leftChild +
		 * "\nRight Child: " + rightChild + "\n";
         */
    }

}

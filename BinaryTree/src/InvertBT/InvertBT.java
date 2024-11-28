package InvertBT;

import java.util.ArrayDeque;
import java.util.Queue;

/*
Invert Binary Tree – Iterative and Recursive Solution
Given a binary tree, write an efficient algorithm to invert it.
 */
class Node
{
    int data;
    Node left = null, right = null;

    Node(int data) {
        this.data = data;
    }
}

public class InvertBT {
    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void swap(Node root){
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    public static void invertBinaryTree(Node root){
       if(root==null){
           return;
       }
       swap(root);
       invertBinaryTree(root.left);
       invertBinaryTree(root.right);
    }
    public static void invertBinaryTreeIterative(Node root){
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            swap(node);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
    }
    public static void main(String[] args) {
          /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // invertBinaryTree(root);
        invertBinaryTreeIterative(root);
        preorder(root);
    }
}

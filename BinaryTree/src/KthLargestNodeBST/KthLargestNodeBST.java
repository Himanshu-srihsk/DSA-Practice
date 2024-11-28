package KthLargestNodeBST;

/*
Find k’th largest node in a BST
Given a BST and a positive number k, find the k'th largest node in the BST.
 */

import java.util.concurrent.atomic.AtomicInteger;

class Node
{
    int data;
    Node left = null, right = null;

    Node(int data) {
        this.data = data;
    }
}
public class KthLargestNodeBST {
    public static Node insert(Node root,int key){
        if(root==null){
            return new Node(key);
        }
        if(root.data > key){
            root.left = insert(root.left,key);
        }else{
            root.right = insert(root.right,key);
        }
        return root;
    }
    public static Node kthLargest(Node root, AtomicInteger i, int k){
        if(root==null){
            return null;
        }

        Node right = kthLargest(root.right,i,k);

        if(right!=null){
            return right;
        }

        if(i.incrementAndGet()==k){
            return root;
        }
        return kthLargest(root.left,i,k);
    }
    public static Node kthLargest(Node root, int k){
        AtomicInteger i = new AtomicInteger(0);
      return kthLargest(root,i,k);
    }
    public static void main(String[] args) {
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

        Node root = null;
        for (int key: keys) {
            root = insert(root, key);
        }

        int k = 5;
        Node node = kthLargest(root, k);

        if (node != null) {
            System.out.println(node.data);
        }
        else {
            System.out.println("Invalid Input");
        }
    }
}

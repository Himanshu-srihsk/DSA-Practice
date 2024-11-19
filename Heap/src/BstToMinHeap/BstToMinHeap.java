package BstToMinHeap;

import java.util.*;

/*
Convert a Binary Search Tree into a Min Heap
Given a binary search tree (BST), efficiently convert it into a min-heap. In order words, convert a binary search tree into a complete binary tree where each node has a higher value than its parent’s value.

For example, the solution should convert the BST on the left into the binary tree on the right, or any other binary tree with the same set of keys that satisfies the structural and heap-ordering property of min-heap data structure.
 */
class Node
{
    int key;
    Node left, right;

    Node(int key) {
        this.key = key;
    }
    Node(){}

}
public class BstToMinHeap {
    public static Node insert(Node root,int key){
        if(root==null){
            return new Node(key);
        }
        if(root.key < key){
            root.right = insert(root.right,key);
        } else{
            root.left = insert(root.left, key);
        }
        return root;
    }
    public static void printLevelOrderTraversal(Node root)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }

        Queue<Node> q = new ArrayDeque<Node>();
        q.add(root);

        while (!q.isEmpty())
        {
            int n = q.size();
            while (n-- > 0)
            {
                Node front = q.poll();
                System.out.print(front.key + " ");

                if (front.left != null) {
                    q.add(front.left);
                }

                if (front.right != null) {
                    q.add(front.right);
                }
            }

            System.out.println();
        }
    }
    public static void inorder(Node root,Deque<Integer> nodes){
         if(root==null){
             return;
         }
         inorder(root.left,nodes);
         nodes.addLast(root.key);
         inorder(root.right,nodes);
    }
    public static void preorder(Node root,Deque<Integer> nodes){
        if(root==null){
            return;
        }
       root.key = nodes.pollFirst();
        preorder(root.left,nodes);
        preorder(root.right,nodes);
    }
    public  static  void convert(Node root){
        Deque<Integer> nodes = new ArrayDeque<>();
        inorder(root,nodes);
        preorder(root,nodes);
    }
    public static Node push(Node node, Node head){
        if(head==null){
            head = node;
            head.right = null;
            return head;
        }
        node.right = head;
       // head.left = node;
        head = node;

        return head;
    }
    public static Node convertTreeToList(Node root,Node head){
         if(root==null){
             return head;
         }
         head = convertTreeToList(root.right,head);
         head = push(root,head);
         head = convertTreeToList(root.left,head);
         root.left = null;
         return head;
    }
    public static void printList(Node head){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.key+" ");
            curr = curr.right;
        }
        System.out.println();
    }
    public static Node LLtoHeap(Node head){
        Node root=null;
        root = head;
        if(head == null){
            return root;
        }
        Queue<Node> queue = new ArrayDeque<Node>();
        head= head.right;
        root.right = null;
        queue.add(root);
        while(head!=null){
            Node parent = queue.poll();
            Node next = head;
            head= head.right;
            next.right = null;
            parent.left = next;
            queue.add(parent.left);

            if(head!=null){
                next = head;
                head = head.right;
                next.right = null;
                parent.right = next;
                queue.add(parent.right);
            }
        }
        return  root;
    }
    public static Node convertForIncompleteBT(Node root){
        Node head = null;
        head = convertTreeToList(root,head);
        System.out.println("Printing LL ...................");
        printList(head);
        return LLtoHeap(head);
    }
    public static void main(String[] args) {
//        int[] keys = { 5, 3, 2, 4, 8, 6, 10 };
//
//        /* Construct the following BST
//                   5
//                 /   \
//                /     \
//               3       8
//              / \     / \
//             /   \   /   \
//            2     4 6    10
//        */
//
//        Node root = null;
//        for (int key: keys) {
//            root = insert(root, key);
//        }
//
//         convert(root);
//        printLevelOrderTraversal(root);

      //  CASE 2: BST is not a Complete Binary Tree


        int[] keys = { 5, 3, 2, 4, 8, 10 };

        /* Construct the following BST
                   5
                 /   \
                /     \
               3       8
              / \       \
             /   \       \
            2     4      10
        */

        Node root = null;
        for (int key: keys) {
            root = insert(root, key);
        }
        printLevelOrderTraversal(root);
        root = convertForIncompleteBT(root);
        System.out.println("printLevelOrderTraversal(root);");
        printLevelOrderTraversal(root);
    }
}

package BinaryTreeIfHeap;

/*
Check if a binary tree is a min-heap or not
Given a binary tree, check if it is a min-heap or not. In order words, the binary tree must be a complete binary tree where each node has a higher value than its parent’s value.
 */
class Node
{
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}
public class BinaryTreeIfHeap {
    private static int size(Node root)
    {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }
    public static boolean isHeap(Node root,int count ,int ind){
        if(root==null){
            return true;
        }
        if(ind>=count){
            return false;
        }

        if((root.left != null && root.left.data <= root.data)||(root.right!=null && root.right.data <= root.data)){
            return false;
        }
        boolean left = isHeap(root.left, count, 2*ind+1);
        boolean right = isHeap(root.right,count, 2*ind+2);

        return left && right;
    }
    public static boolean isHeap(Node root){
       int count  = size(root);
       return isHeap(root,count,0);
    }
    public static void main(String[] args) {
       /* Construct the following tree
                   2
                 /   \
                /     \
               3       4
              / \     / \
             /   \   /   \
            5     6 8    10
        */

        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);
       // root.left.right = new Node(6);
        root.right.left = new Node(8);
       root.right.right = new Node(10);

        if (isHeap(root)) {
            System.out.println("The given binary tree is a min-heap");
        }
        else {
            System.out.println("The given binary tree is not a min-heap");
        }
    }
}

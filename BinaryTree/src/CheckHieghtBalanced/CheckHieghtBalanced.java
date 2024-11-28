package CheckHieghtBalanced;

import java.util.concurrent.atomic.AtomicBoolean;

/*
Check if a binary tree is height-balanced or not
Given a binary tree, write an efficient algorithm to check if it is height-balanced or not. In a height-balanced tree,
the absolute difference between the height of the left and right subtree for every node is 0 or 1.
 */
class Node
{
    int data;
    Node left = null, right = null;

    Node(int data) {
        this.data = data;
    }
}
public class CheckHieghtBalanced {
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left,right)+1;
    }
    public static boolean isHeightBalanced(Node root){
        if(root==null){
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)>1){
            return false;
        }
        return isHeightBalanced(root.left) && isHeightBalanced(root.right);
    }
    public static int isHeightBalanced1(Node root, AtomicBoolean isBalanced){
        if(root==null){
            return 0;
        }
        int left = isHeightBalanced1(root.left,isBalanced);
        int right = isHeightBalanced1(root.right,isBalanced);
        if(Math.abs(left-right)>1){
            isBalanced.set(false);
        }
        return Math.max(left,right)+1;
    }
    public static boolean isHeightBalanced1(Node root){
        AtomicBoolean isBalnced = new AtomicBoolean(true);
        isHeightBalanced1(root,isBalnced);
        return isBalnced.get();
    }
    public static void main(String[] args) {
       /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     /
            4   5   6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        if (isHeightBalanced1(root)) {
            System.out.println("Binary tree is balanced");
        }
        else {
            System.out.println("Binary tree is not balanced");
        }
    }
}

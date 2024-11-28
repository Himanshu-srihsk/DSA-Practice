package DiameterBT;
/*
Find the diameter of a binary tree
Given a binary tree, write an efficient algorithm to compute the diameter of it.
A binary tree diameter equals the total number of nodes on the longest path between any two leaves in it.
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
public class DiameterBT {
    public static int getDiameter(Node root, AtomicInteger diameter){
        if(root==null){
            return 0;
        }
        int leftDiameter = getDiameter(root.left,diameter);
        int rightDiameter = getDiameter(root.right,diameter);
        diameter.set(Math.max(diameter.get(), leftDiameter+rightDiameter+1));
        return Math.max(leftDiameter,rightDiameter)+1;

    }
    public static int getDiameter(Node root){
        AtomicInteger diameter = new AtomicInteger(0);
         getDiameter(root,diameter);
         return diameter.get();
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        System.out.println("The diameter of the tree is " + getDiameter(root));
    }
}

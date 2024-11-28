package MaximumPathSum;

/*
Given a binary tree, write an efficient algorithm to find the maximum path sum between any two nodes in it. The path can start and end at any node in the tree and need not go through the root.
 */

import java.util.concurrent.atomic.AtomicInteger;

class Node
{
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = this.right = null;
    }
}
public class MaximumPathSum {
    public static int findMaxPathSum(Node root, AtomicInteger res){
       if(root==null){
           res.set(0);
           return 0;
       }
       int leftMax = findMaxPathSum(root.left,res);
       int rightMax = findMaxPathSum(root.right,res);
       int sum = root.data + leftMax + rightMax;
       if(sum>res.get()){
           res.set(sum);
       }
       return Math.max(leftMax,rightMax) + root.data;
    }
    public static void main(String[] args) {
       /* Construct the following tree
                1
              /   \
             /     \
            2      10
           / \    /  \
         -1  -4  -5   -6
             /   / \
            3   7   4
                 \
                 -2
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(-1);
        root.left.right = new Node(-4);
        root.right.left = new Node(-5);
        root.right.right = new Node(-6);
        root.left.right.left = new Node(4);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(4);
        root.right.left.left.right = new Node(-2);

        AtomicInteger result = new AtomicInteger(Integer.MIN_VALUE);
        findMaxPathSum(root, result);
        System.out.println("The maximum path sum is " + result.get());
    }
}

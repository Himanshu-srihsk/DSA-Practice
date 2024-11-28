package HeightOfBT;

import java.util.ArrayDeque;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
public class HeightOfBT {
    public static int height(Node root){
         if(root==null){
             return 0;
         }
         int left = height(root.left);
         int right = height(root.right);
         return Math.max(left,right)+1;
    }
    public static int heightIter(Node root){
        if(root==null){
            return 0;
        }
        Queue<Node> q = new ArrayDeque<Node>();
        q.add(root);
        int height = 0;
        while(!q.isEmpty()){
            int size = q.size();
            height++;
            while(size>0 && !q.isEmpty()){
                Node node = q.poll();
                if(node.left!=null){
                    q.add(node.left);

                }
                if(node.right!=null){
                    q.add(node.right);
                }
                size--;
            }
        }
        return height;
    }
    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
        // root.right.right.right = new Node(29);

        System.out.println("The height of the binary tree is " + height(root));
        System.out.println("The height of the binary tree is " + heightIter(root));
    }
}

package InPlaceMerge2BalanceBST;

/*
In-place merge two height-balanced BSTs
Given two height-balanced binary search trees, in-place merge them into a single balanced binary search tree.
 For each node of a height-balanced tree, the difference between its left and right subtree height is at most 1.
 */
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

public class InPlaceMerge2BalanceBST {
    static class NodeWrapper{
        Node node;
        NodeWrapper(Node node){
            this.node = node;
        }
    }
    public static Node push(Node a,Node head){
        a.right = head;
        if(head!=null){
            head.left = a;
        }
        head = a;
        return head;
    }
    public static Node BstToDLL(Node a,Node head){
       if(a==null){
           return head;
       }
       head = BstToDLL(a.right,head);
       head = push(a,head);
       head = BstToDLL(a.left,head);
       a.left = null;
       return head;
    }
    public static Node sortedMerge(Node a,Node b){
       if(a==null){
           return b;
       }
       if(b==null){
           return a;
       }
       Node res = null;
       if(a.data <=b.data){

           a.right = sortedMerge(a.right,b);
           a.right.left = a;
           a.left = null;
           return a;

       }else{

           b.right = sortedMerge(a,b.right);
           b.right.left = b;
           b.left = null;
           return b;
       }

    }
    public static Node DllToBST(NodeWrapper a,int size){
       if( size <=0){
           return null;
       }
       Node left = DllToBST(a,size/2);
       Node root = a.node;
       a.node = a.node.right;

       Node right = DllToBST(a, size - (size/2 + 1) );
       root.left = left;
       root.right = right;
       return root;
    }
    public static int size(Node head){
        Node curr = head;
        int c=0;
        while(curr!=null){
            curr=curr.right;
            c++;
        }
        return c;
    }
    public static void printDDL(Node head){
        Node curr= head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr = curr.right;
        }
        System.out.println();
        return;
    }
    public static Node merge(Node a,Node b){
        Node first = null;
        Node second = null;
        first = BstToDLL(a,first);
        second = BstToDLL(b,second);
        System.out.println("....................................");
        printDDL(first);
        printDDL(second);
        System.out.println("....................................");
        Node whole = sortedMerge(first,second);
        return DllToBST(new NodeWrapper(whole),size(whole));
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
       /*
        Construct the first BST
              20
             /  \
            10  30
                / \
               25 100
        */

        Node first = new Node(20);
        first.left = new Node(10);
        first.right = new Node(30);
        first.right.left = new Node(25);
        first.right.right = new Node(100);

        /*
        Construct the second BST
              50
             /  \
            5    70
        */

        Node second = new Node(50);
        second.left = new Node(5);
        second.right = new Node(70);

        // merge both BSTs
        Node root = merge(first, second);

        preorder(root);
    }
}

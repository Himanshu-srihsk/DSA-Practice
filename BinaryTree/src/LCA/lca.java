package LCA;

class Node
{
    int data;
    Node left = null, right = null;

    Node(int data) {
        this.data = data;
    }
}
public class lca {
    public static boolean isNodePresent(Node root, Node x){
        if(root==null){
            return false;
        }
        if(root == x){
            return true;
        }
        return isNodePresent(root.left,x) || isNodePresent(root.right,x);
    }
    public static Node LCA(Node root,Node a, Node b){
        if(root==null){
            return null;
        }
        if(root==a || root==b){
            return root;
        }
        Node left = LCA(root.left,a,b);
        Node right = LCA(root.right,a,b);
        if(left!=null && right!=null){
            return root;
        }
        return left!=null? left: right;
    }
    public static void findLCA(Node root, Node a, Node b){
        if(isNodePresent(root,a) && isNodePresent(root,b)){
           Node lca =  LCA(root,a,b);
           System.out.println("LCA FOUND i.e "+ lca.data);
        }else{
            System.out.println("LCA Doesnot exists");
        }
    }
    public static void main(String[] args) {
        /* Construct the following tree
              1
            /   \
           /     \
          2       3
           \     / \
            4   5   6
               / \
              7   8
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        findLCA(root, root.right.left.left, root.right.right);
        findLCA(root, root.right.left.left, new Node(10));
        findLCA(root, root.right.left.left, root.right.left.left);
        findLCA(root, root.right.left.left, root.right.left);
        findLCA(root, root.left, root.right.left);
    }
}

package expressionTree;

import java.util.Stack;

class Node
{
    char data;
    Node left, right;

    Node(char data)
    {
        this.data = data;
        this.left = this.right = null;
    }

    Node(char data, Node left, Node right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
public class expressionTree {
    public static void postorder(Node root)
    {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data);
    }
    public static Node construct(String exp){
        Stack<Node> st = new Stack<>();
        for(Character ch: exp.toCharArray()){
            if(isOperator(ch)){
                Node y = st.pop();
                Node x = st.pop();
                Node node = new Node(ch,x,y);
                st.push(node);
            }else{
                st.push(new Node(ch));
            }
        }
        return st.pop();
    }
    public static boolean isOperator(Character c){
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }
    public static void inorder(Node root){
         if(root==null){
             return;
         }
        if(isOperator(root.data)) {
            System.out.print("( ");
        }
         inorder(root.left);

         System.out.print(root.data+ " ");
         inorder(root.right);
        if(isOperator(root.data)){
            System.out.print(" )");
        }
    }
    public static void main(String[] args) {
        String postfix = "ab+cde+**";
        Node root = construct(postfix);

        System.out.print("Postfix Expression: ");
        postorder(root);

        System.out.print("\nInfix Expression: ");
        inorder(root);
    }
}

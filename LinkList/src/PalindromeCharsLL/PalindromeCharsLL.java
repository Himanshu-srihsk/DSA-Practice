package PalindromeCharsLL;

class Node
{
    char data;
    Node next;

    Node(char ch)
    {
        this.data = ch;
        this.next = null;
    }
}
public class PalindromeCharsLL {
    static class NodeWrapper
    {
        public Node node;

        NodeWrapper(Node node) {
            this.node = node;
        }
    }
    public static boolean isPalindrome(NodeWrapper left, Node right){
        if(right==null){
            return true;
        }
        boolean check = isPalindrome(left, right.next) && left.node.data == right.data;
        left.node=left.node.next;
        return check;
    }
    public static void parseTree(Node head, StringBuilder s1, StringBuilder s2){
        if(head==null){
            return;
        }
        s1.append(head.data);
        parseTree(head.next,s1,s2);
        s2.append(head.data);
    }
    public static boolean isPalindrome1(Node head){
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        parseTree(head,s1,s2);
        return s1.toString().equals(s2.toString());
    }
    public static void main(String[] args) {
        Node head = new Node('A');
        head.next = new Node('B');
        head.next.next = new Node('D');
        head.next.next.next = new Node('B');
        head.next.next.next.next = new Node('A');

        // Wrap node, so its reference can be changed inside `isPalindrome()`
        NodeWrapper left = new NodeWrapper(head);
        if (isPalindrome1(head)) {
            System.out.println("Linked List is a palindrome.");
        }
        else {
            System.out.println("Linked List is not a palindrome.");
        }
        if (isPalindrome(left, head)) {
            System.out.println("Linked List is a palindrome.");
        }
        else {
            System.out.println("Linked List is not a palindrome.");
        }
    }
}

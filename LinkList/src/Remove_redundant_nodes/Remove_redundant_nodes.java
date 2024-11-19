package Remove_redundant_nodes;
/*
Remove redundant nodes from a path formed by a linked list
Given a linked list that stores a path formed by cells of a matrix, remove the redundant nodes in that path. The path can be both vertical and horizontal, but never diagonal. To determine the complete path, we need the endpoints of all vertical and horizontal paths; middle nodes don’t provide any value and are therefore redundant. So, the resultant list should contain coordinates of only endpoints of all vertical and horizontal paths.

 */

class Node
{
    int x, y;
    Node next;

    Node(int x, int y, Node next)
    {
        this.x = x;
        this.y = y;
        this.next = next;
    }

    @Override
    public String toString() {
        return ("(" + x + ", " + y + ")");
    }
}

public class Remove_redundant_nodes {

    public static void printList(Node head)
    {
        for (Node ptr = head; ptr != null; ptr = ptr.next) {
            System.out.print(ptr + " —> ");
        }
        System.out.println("null");
    }
    public static boolean checkifallonsameaxis(Node prev,Node curr,Node next){
        boolean samex = false;
        boolean samey = false;
        samex = prev.x == curr.x && curr.x == next.x;
        samey = prev.y ==curr.y && curr.y == next.y;
        return  samex || samey;
    }
    public static Node removeNodes(Node head){
         Node prev = null;

         Node curr = head;
         while(curr!=null){
            if(prev==null){
                prev = curr;
            }else{
                Node next = curr.next;
                if(next != null && checkifallonsameaxis(prev,curr,next)){
                    prev.next = next;
                }else{
                    prev = curr;
                }
            }
            curr= curr.next;
         }
         return head;
    }
    public static void main(String[] args) {
// input coordinates
        int[][] keys = { {0, 1}, {0, 5}, {0, 8}, {2, 8},
                {5, 8}, {7, 8}, {7, 10}, {7, 12} };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i][0], keys[i][1], head);
        }

        head = removeNodes(head);
        printList(head);
    }
}

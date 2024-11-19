package RearrangeLL;
//Rearrange linked list in a specific manner
/*
Input : 1 —> 2 —> 3 —> 4 —> 5 —> null
Output: 1 —> 3 —> 5 —> 2 —> 4 —> null
 */
class Node{
    int data;
    Node next;
    Node(){}
    Node(int data, Node next){
        this.data=data;
        this.next=next;
    }
}
public class RearrangeLL {
    public static void printList(Node head){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static void rearrange(Node head){
        if(head==null || head.next==null){
            return;
        }
        Node dummyNodeA = new Node();
        Node dummyNodeB = new Node();
        Node a = dummyNodeA;
        Node b = dummyNodeB;
        Node curr= head;
        while(curr!=null){
          a.next = curr;
          a=a.next;
          curr=curr.next;
          if(curr!=null){
              b.next=curr;
              b=b.next;
              curr=curr.next;
          }
        }
        b.next = null;
        a.next = dummyNodeB.next;
        head = dummyNodeA.next;
        return;
    }
    public static void main(String[] args) {
        // input keys
        int[] keys = { 1, 2, 3, 4, 5,6 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        printList(head);
        rearrange(head);
        printList(head);
    }
}

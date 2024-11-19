package SortDoublyLL;

class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data = data;
        this.next = this.prev = null;
    }
}
public class SortDoublyLL {
   public static Node push(Node head, int data){
        Node newNode = new Node(data);
        newNode.next = head;
        if(head!=null){
            head.prev=newNode;
        }
        return newNode;
    }
    public static void printDDL(Node head){
       Node curr= head;
       while(curr!=null){
           System.out.print(curr.data+" ");
           curr = curr.next;
       }
       System.out.println();
       return;
    }
    public static Node[] findHeadStart(Node head){
        if(head==null || head.next==null){
            return new Node[]{head,null};
        }
       Node slow=head;
       Node fast=head;
       Node prev = null;

       while(fast!=null){
           fast=fast.next;
           if(fast!=null){
               prev=slow;
               slow = slow.next;
               fast=fast.next;
           }
       }
       Node b = slow;
       if(prev!=null){
           prev.next = null;
       }
       if(b!=null){
           b.prev=null;
       }
       Node a = head;
       return new Node[]{a,b};
    }
    public static Node sortDDL(Node head){
       if(head==null || head.next==null){
           return head;
       }
       Node[] node = findHeadStart(head);
       Node a = node[0];
       Node b= node[1];
       a= sortDDL(a);
        b= sortDDL(b);

       head = merge(a,b);
       return  head;
    }
    public static Node merge(Node a,Node b){
       if(b==null){
           return a;
       }
       if(a==null){
           return b;
       }
       if(a.data<=b.data){
           a.next = merge(a.next,b);
           a.next.prev = a;
           a.prev=null;
           return  a;

       }else{
           b.next = merge(a,b.next);
           b.next.prev = b;
           b.prev=null;
           return b;
       }
    }

    public static void main(String[] args) {
        int[] keys = { 6, 4, 8, 7, 9, 2, 1 };
        Node head= null;
        for(int i=keys.length-1;i>=0;i--){
           head = push(head,keys[i]);
        }

        printDDL(head);
        head = sortDDL(head);
        printDDL(head);
    }
}

package ReverseLL;

import java.util.concurrent.atomic.AtomicBoolean;

class Node{
    int data;
    Node next;
    Node(){}
}

public class ReverseLL {
    static class NodeWrapper{
        Node node;
        NodeWrapper(Node node){
            this.node=node;
        }
    }
    public static Node push(Node node, int data){
        Node newNode = new Node();
        newNode.data=data;
        newNode.next=node;
        return newNode;
    }
    public static void printList(Node head){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static Node reverse(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node curr= head;
        Node rest = head.next;
        if(rest==null){
            return curr;
        }
        Node temp = reverse(rest);
        curr.next.next = curr;
        curr.next = null;
        return temp;
    }
    public static Node reverseIter(Node head){
        Node curr = head;
        Node prev = null;
        while(curr!=null){
            Node next = curr.next;
            curr.next=prev;
            prev = curr;
            curr=next;
        }
        return prev;
    }
    public static Node reverseInGroups(Node head, int k){
        if(head==null || head.next == null){
            return head;
        }
      Node curr = head;
      int c=k;
      Node prev=null;

      while(curr!=null && c>0){
          Node next = curr.next;
          curr.next=prev;
          prev = curr;
          curr=next;
          c--;
      }
      head.next = reverseInGroups(curr,k);
      return prev;
    }
    public static Node reverseSpecificPortion(Node head,int m,int n){
        if(m>=n){
            return null;
        }
        if(head==null || head.next==null){
            return head;
        }
        Node curr = head;
        Node temp = null;

        int c=m;
        while(curr!=null && c>1){
            temp = curr;
            curr = curr.next;
            c--;
        }
        Node firstElem = curr;
        if(curr==null){
            return head;
        }
        Node prev = temp;
        c=n-m+1;
        while(curr!=null && c>0){
            Node next = curr.next;
            curr.next=prev;
            prev = curr;
            curr=next;
            c--;
        }
        firstElem.next = curr;
        if(temp!=null){
            temp.next = prev;
        }


        return head;
    }
    public static boolean checkPalin(NodeWrapper node1, Node node2){
         if(node2==null){
             return true;
         }


         boolean check = checkPalin(node1, node2.next);
         if(node1.node.data != node2.data){
             return false;
         }
         node1.node = node1.node.next;
        return check;
    }
    public static boolean checkPalin(Node head){

        return checkPalin(new NodeWrapper(head),head);
    }
    public static Node findMiddle(Node head, AtomicBoolean odd){
        if(head==null){
            return head;
        }
        Node prev=  null;
        Node slow = head;
        Node fast = head;
        while(fast!=null){
            fast=fast.next;
            if(fast!=null){
                prev=slow;
                slow=slow.next;
                fast=fast.next;
            }else{
                odd.set(true);
            }
        }
        Node next = null;
        if(odd.get() == true){
            next = slow.next;
        }else{
            next = prev.next;

        }
        prev.next = null;
        return next;

    }
    public static boolean checkPalin1(Node head){
        if(head==null || head.next==null){
            return true;
        }
        AtomicBoolean isOddLength = new AtomicBoolean(false);
        Node middle =findMiddle(head,isOddLength);
        Node a = head;
        Node b = reverse(middle);

        return checkIfPalin(a,b);
    }
    public static boolean checkIfPalin(Node a, Node b){
        if(a==null && b==null){
            return true;
        }
        if(a==null || b==null){
            return false;
        }
        return a.data== b.data && checkIfPalin(a.next,b.next);
    }
    public static void main(String[] args) {
        // input keys
        int[] keys = { 1, 2, 3, 4, 5, 6,7,8,9 };
//        int[] keys1 = {1, 3, 5, 3, 1};
        int[] keys1 = {2, 3, 5,5, 3, 1};

        Node head = null;
        for (int i = keys1.length - 1; i >=0; i--) {
            head = push(head, keys1[i]);
        }
        printList(head);
       // head = reverse(head);
      //  head = reverseIter(head);
       // head = reverseInGroups(head, 2);
        //Reverse specific portion of a linked list
        /*
        Linked List: 1 —> 2 —> 3 —> 4 —> 5 —> 6 —> 7 —> None
         start position = 2
         end position = 5
         */

        int m = 2, n = 7;
       // head = reverseSpecificPortion(head, m, n);

        if (checkPalin1(head)) {
            System.out.println("The linked list is a palindrome");
        }
        else {
            System.out.println("The linked list is not a palindrome");
        }

        printList(head);
    }
}

package Merge_k_sorted_linked_lists;

import java.util.PriorityQueue;

/*
Efficiently merge `k` sorted linked lists
 */
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
    Node(){}
}
public class Merge_k_sorted_linked_lists {
    public static void printList(Node head){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static Node mergeKLists(Node[] lists){
        PriorityQueue<Node> pq = new PriorityQueue<>((Node a, Node b) -> a.data - b.data);
        for(int i=0;i<lists.length;i++){
            pq.add(lists[i]);
        }
        Node head = null;
        Node tail = head;
        while(!pq.isEmpty()){
          Node node = pq.poll();
          if(head==null){
              head=tail = node;

          }else{
              tail.next=node;
              tail = tail.next;
          }
          if(node.next!=null){
              pq.add(node.next);
          }
            tail.next=null;
        }
        return head;
    }
    public static Node mergeKDivideAndConquer(Node[] lists){
        int start = 0;
        int end = lists.length -1;
        int i = end;
        while(i!=0){
          while(start<end){
              lists[start] = merge1(lists[start], lists[end]);
              start++;
              end--;
          }
          start=0;
          i=end;
        }
        System.out.println("bdc nwem");
        return lists[0];
    }
    public static Node merge(Node a, Node b){
       if(a==null){
           return b;
       }
       if(b==null){
           return a;
       }
       Node res;
       if(a.data<=b.data){
           res = a;
           res.next = merge(a.next,b);

       }else{
           res=b;
           res.next = merge(a,b.next);

       }
       return res;
    }

    public static Node merge1(Node a, Node b){
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }

        Node dummy = new Node();
        Node res= dummy;
        while(a!=null && b!=null){
           if(a.data <=b.data){
               res.next = a;
               a=a.next;
           } else{
               res.next = b;
               b=b.next;
           }
            res = res.next;
            res.next = null;


        }
        if(a!=null){
            res.next = a;
        }
        if(b!=null){
            res.next = b;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        int k = 3;    // total number of linked lists

        // an array to store the head nodes of the linked lists
        Node[] lists = new Node[k];

        lists[0] = new Node(1);
        lists[0].next = new Node(5);
        lists[0].next.next = new Node(7);

        lists[1] = new Node(2);
        lists[1].next = new Node(3);
        lists[1].next.next = new Node(6);
        lists[1].next.next.next = new Node(9);

        lists[2] = new Node(4);
        lists[2].next = new Node(8);
        lists[2].next.next = new Node(10);


//        Node head = mergeKLists(lists);
//        printList(head);
        Node head1 = mergeKDivideAndConquer(lists);
        printList(head1);
    }
}

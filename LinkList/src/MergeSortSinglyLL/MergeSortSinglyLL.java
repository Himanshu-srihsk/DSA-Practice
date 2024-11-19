package MergeSortSinglyLL;

class Node
{
    int data;
    Node next;

    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}

public class MergeSortSinglyLL {
    public static Node[] frontBackSplit(Node head){
        if(head==null || head.next==null){
            return new Node[]{head,null};
        }
        Node slow = head;
        Node fast = head.next;
        while(fast!=null){
            fast=fast.next;
            if(fast!=null){
                fast = fast.next;
                slow = slow.next;
            }
        }

        Node b = null;
        if(slow!=null){
            b=slow.next;
            slow.next = null;
        }

        Node a = head;
        return new Node[]{a,b};
    }
    public static  Node SortedMerge(Node a, Node b){
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        Node res = null;
        if(a.data < b.data){
            res = a;
            res.next = SortedMerge(a.next,b);

        }else{
            res = b;
            res.next = SortedMerge(a,b.next);
        }
        return res;
    }
    public static Node mergesort(Node head){
        if(head==null || head.next == null){
            return  head;
        }
        Node[] arr = frontBackSplit(head);
        Node h1 = mergesort(arr[0]);
        Node h2 = mergesort(arr[1]);
        return SortedMerge(h1,h2);
    }
    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }
    public static void main(String[] args) {
        // input keys
        int[] keys = { 8, 6, 4, 9, 3, 1 };

        Node head = null;
        for (int key: keys) {
            head = new Node(key, head);
        }

        // sort the list
        head = mergesort(head);

        // print the sorted list
        printList(head);
    }
}

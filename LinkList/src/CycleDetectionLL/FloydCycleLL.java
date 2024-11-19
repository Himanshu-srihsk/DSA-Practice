package CycleDetectionLL;

/*
Detect cycle in a linked list (Floyd’s Cycle Detection Algorithm)
Remove loop from a linked list
Given a linked list of integers, which may contain a cycle, remove the cycle if present.
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

public class FloydCycleLL {
    public static Boolean detectCycle(Node head){
        if(head==null || head.next==null){
            return false;
        }
        Node slow= head;
        Node fast = head;
        while(fast!=null){
            fast=fast.next;
            if(fast!=null){
                slow=slow.next;
                fast=fast.next;
                if(slow==fast){
                  //  System.out.println("Cycle found at "+ slow.data);
                    return true;
                }
            }
        }
        return false;

    }
    public static void printList(Node head){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static  void removeLoop(Node head){
        Node slow= head;
        Node fast = head.next;
        while(fast!=null && slow!=fast){
            slow=slow.next;
            fast=fast.next.next;
           // System.out.println("slow data ="+slow.data + " fast data="+fast.data);
        }
        Node curr = slow;
        int count =1;
        //System.out.println("Number of node in Cycle is "+ count + " slow is "+ slow.data);
        for(Node ptr=slow;ptr.next!=slow;ptr=ptr.next){
            count++;
        }
        System.out.println("Number of node in Cycle is "+ count);
        curr= head;
        while(count-->0){
            curr=curr.next;
        }


        int i=0;

        while(curr!=head){
            curr=curr.next;
            head=head.next;
        }
        while(curr.next!=head){
            curr=curr.next;
        }
        curr.next = null;


    }
    public static void main(String[] args) {

        int[] keys = { 1, 2, 3, 4, 5 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        head.next.next.next.next.next = head.next.next;

        if (detectCycle(head)) {
            System.out.println("Cycle Found");
            removeLoop(head);
        }
        else {
            System.out.println("No Cycle Found");
        }
        printList(head);

    }
}

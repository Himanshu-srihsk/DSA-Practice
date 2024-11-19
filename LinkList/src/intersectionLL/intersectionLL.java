package intersectionLL;

import java.util.HashSet;
import java.util.Set;

class Node
{
    int data;
    Node next;
}
public class intersectionLL {
    public static Node push(Node node,int data){
        Node newNode= new Node();
        newNode.data =data;
        newNode.next=node;
        return newNode;
    }
    public static Node findIntersection(Node a, Node b){
        Set<Node> set = new HashSet<>();
        while(a!=null){
            set.add(a);
            a=a.next;
        }
        while(b!=null){
            if(set.contains(b)){
                return b;
            }
            b=b.next;
        }
        return null;
    }
    public static Node findIntersection2(Node first, Node second){
        Node prev=null;
        Node curr= first;
        while(curr!=null){
            prev=curr;
            curr=curr.next;
        }
        prev.next = first;
        return removeLoop(second);

    }
    public static  Node removeLoop(Node head){
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
        for(Node ptr = slow; ptr.next!=slow; ptr=ptr.next){
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
        Node ans = curr.next;
        curr.next = null;

return ans;
    }
    public static void main(String[] args) {
        Node first = null;
        for (int i = 5; i > 0; i--) {
            first = push(first, i);
        }

        // construct the second linked list (1 —> 2 —> 3 —> null)
        Node second = null;
        for (int i = 3; i > 0; i--) {
            second = push(second, i);
        }

        // link tail of the second list to the fourth node of the first list
        second.next.next.next = first.next.next.next;

        Node addr = findIntersection(first, second);
        if (addr != null) {
            System.out.println("The intersection point is " + addr.data);
        }
        else {
            System.out.println("The lists do not intersect.");
        }
        addr = findIntersection2(first, second);
        if (addr != null) {
            System.out.println("The intersection point is " + addr.data);
        }
        else {
            System.out.println("The lists do not intersect.");
        }


    }
}

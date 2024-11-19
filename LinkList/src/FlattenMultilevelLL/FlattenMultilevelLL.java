package FlattenMultilevelLL;
class Node
{
    int data;
    Node next;
    Node down;

    Node(int data) {
        this.data = data;
    }
}
public class FlattenMultilevelLL {
    public static void printOriginalList(Node head)
    {
        if(head==null){
            return;
        }
        System.out.print(head.data+" ");
        if(head.down!=null){
            System.out.print("[");
            printOriginalList(head.down);
            System.out.print("]");
        }
        printOriginalList(head.next);

    }
    public static void printFlattenedList(Node head)
    {
        while (head != null)
        {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    public static Node flattenList(Node head){
       if(head==null){
           return head;
       }
       Node next = head.next;
       head.next = flattenList(head.down);
       Node tail = head;
       while(tail.next!=null){
           tail=tail.next;
       }
       tail.next = flattenList(next);
       return head;
    }
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);
        Node eleven = new Node(11);
        Node twelve = new Node(12);
        Node thirteen = new Node(13);
        Node fourteen = new Node(14);
        Node fifteen = new Node(15);

        // set head node
        Node head = one;

        // set next pointers
        one.next = four;
        four.next = fourteen;
        fourteen.next = fifteen;
        five.next = nine;
        nine.next = ten;
        seven.next = eight;
        eleven.next = thirteen;

        // set down pointers
        one.down = two;
        two.down = three;
        four.down = five;
        five.down = six;
        six.down = seven;
        ten.down = eleven;
        eleven.down = twelve;

        System.out.println("The original list is :");
        printOriginalList(head);

        head = flattenList(head);
        System.out.println("\n\nThe flattened list is :");
        printFlattenedList(head);
    }
}

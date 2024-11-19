package RearrangeLL;

class Node1
{
    int data;
    Node1 next, prev;

    public Node1(int data)
    {
        this.data = data;
        this.next = this.prev = null;
    }
}

public class ReverseDDL {
    public static Node1 push(Node1 head, int key)
    {
      Node1 newNode = new Node1(key);
      if(head==null){
          head=newNode;
          head.next=null;
          head.prev=null;
          return head;
      }
      newNode.next=head;
      head.prev=newNode;
      head=newNode;
      return head;
    }
    public static void printDDL(String msg, Node1 head)
    {
        System.out.print(msg);
        while (head != null)
        {
            System.out.printf("%d —> ", head.data);
            head = head.next;
        }

        System.out.println("null");
    }
    public static Node1 reverseDDL(Node1 head){
        Node1 prev=null;
        Node1 curr = head;
        while(curr!=null){
          Node1 next = curr.next;
           prev=curr.prev;
           curr.next=prev;
            curr.next=prev;
            if(prev!=null){
                prev.prev = curr;
            }
            prev=curr;
            curr = next;
        }
        return prev;
    }
    public static Node1 reverseDDLRecursive(Node1 head){
        if(head==null || head.next==null){
            return head;
        }
//        Node1 curr = head;
//        Node1 prev=null;
//        Node1 next = curr.next;
//        prev=curr.prev;
//        curr.next=prev;
//
//        if(prev!=null){
//            prev.prev = curr;
//        }
//        Node1 temp = next;
//        if(temp==null){
//            return prev;
//        }
//        Node1 ans = reverseDDLRecursive(next);
//        temp.next=prev;
//        if(prev!=null){
//            prev.prev = temp;
//        }
//        return ans;

        Node1 curr = head;
        Node1 rest = head.next;
        Node1 ans = reverseDDLRecursive(rest);
        curr.next.next = curr;
        curr.prev = curr.next.next;
        curr.next=null;
        return ans;

    }
    public static void main(String[] args) {
        int[] keys = { 1, 2, 3, 4, 5,6,7 };


        Node1 head = null;
        for (int key: keys) {
            head = push(head, key);
        }

        printDDL("Original list: ", head);
//        head = reverseDDL(head);

        head = reverseDDLRecursive(head);
        printDDL("Reversed list: ", head);
    }
}

package QueueImplUsingStack;

import java.util.Queue;
import java.util.Stack;

class Queue1<T>{
    Stack<T> s1,s2;
    Queue1(){
        s1 = new Stack<>();
        s2= new Stack<>();
    }
    public void enqueue(T d){
      s1.push(d);
    }
    public T dequeue() throws Exception {
      if(s1.isEmpty()){
          throw new Exception("Nothing left to pop");
      }
      while(!s1.isEmpty()){
          s2.add(s1.pop());
      }
      T item = s2.pop();
      while(!s2.isEmpty()){
          s1.push(s2.pop());
      }
      return item;
    }
}
//Using one stack with call stack
class Queue2<T>{
    Stack<T> s1;
    Queue2(){
        s1 = new Stack<>();
    }
    public void enqueue(T d){
        s1.push(d);
    }
    public T dequeue() throws Exception {
       if(s1.isEmpty()){
           return null;
       }
       if(s1.size()==1){
           return s1.pop();
       }
       T item = s1.pop();
       T i = dequeue();
       s1.add(item);
       return i;
    }
}
public class QueueImplUsingStack {
    public static void main(String[] args) {
//        Queue1<Integer> q = new Queue1<Integer>(); //Using two stacks
        Queue2<Integer> q = new Queue2<Integer>(); // Using one stack with call stack
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(6);
        try {
            System.out.println(q.dequeue());
            q.enqueue(4);
            System.out.println(q.dequeue());
            System.out.println(q.dequeue());
            q.enqueue(5);
            System.out.println(q.dequeue());
        }catch (Exception e){
           System.out.println(e.getMessage());
        }

    }
}

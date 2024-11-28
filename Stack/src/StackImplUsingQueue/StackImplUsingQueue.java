package StackImplUsingQueue;

import java.util.ArrayDeque;
import java.util.Queue;

class Stack1<T>{
    Queue<T> q1;
    Queue<T> q2;
    Stack1(){
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    public void add(T key){
      q1.add(key);
    }
    public T poll(){
       if(q1.isEmpty()){
           System.out.println("Stack Underflow!!");
           System.exit(0);
       }
       T front = null;
       while(!q1.isEmpty()){
           if(q1.size()==1){
               front = q1.peek();
               q1.poll();
               break;
           }
           q2.add(q1.poll());
       }
       while (!q2.isEmpty()){
           q1.add(q2.poll());
       }
       return front;
    }
}
//Using one queue with call stack
class Stack2<T>{
    Queue<T> q1;
    Stack2(){
        q1 = new ArrayDeque<>();
    }
    public void add(T key){
        q1.add(key);
    }
    public void reverseQueue(){
        if(q1.isEmpty()){
            return;
        }
        T item = q1.poll();
        reverseQueue();
        q1.add(item);

    }
    public T poll(){
       if(q1.isEmpty()){
           System.out.println("Stack Underflow!!");
           System.exit(0);
       }
       reverseQueue();
       T front = q1.peek();
       q1.poll();
       reverseQueue();
       return front;
    }
}
public class StackImplUsingQueue {
    public static void main(String[] args) {
//        Stack1<Integer> s = new Stack1<Integer>();
        Stack2<Integer> s = new Stack2<Integer>(); //Using one queue with call stack
        int[] keys = { 1, 2, 3, 4, 5 };
        for (int key: keys) {
            s.add(key);
        }

        for (int i = 0; i <= keys.length; i++) {
            System.out.println(s.poll());
        }

    }
}

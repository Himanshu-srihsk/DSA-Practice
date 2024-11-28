package MinElemFindInStack;

import java.util.Stack;

//Design a stack that returns the minimum element in constant time
class MinStack{
   Stack<Integer> s;
   Stack<Integer> min;
   MinStack(){
       s = new Stack<>();
       min = new Stack<>();
   }
   public void push(int key){
      s.add(key);
      if(min.isEmpty()){
          min.add(key);
      }else{
          if(min.peek() > key){
              min.add(key);
          }
      }
   }
   public int getMin(){
       if(min.isEmpty()){
           return -1;
       }
       return min.peek();
   }
   public int pop(){
       if(s.isEmpty()){
           return  -1;
       }
       int elem = -1;
      if(!min.isEmpty() && s.peek() == min.peek()){
          elem =s.pop();
          min.pop();
      }else{
          elem = s.pop();
      }
      return elem;
   }
}
class MinStack1{
    Stack<Integer> s;
    int minElem;
    MinStack1(){
        s = new Stack<>();

    }
    public void push(int key){
        if(s.isEmpty()){
            minElem = key;
            s.add(key);
        }else{
            if(key <= minElem){
                s.add(2* key - minElem);
                minElem = key;
            }else{
                s.add(key);
            }
        }

    }
    public int getMin(){
        if(s.isEmpty()){
            return -1;
        }
        return minElem;
    }
    public int pop(){
        if(s.isEmpty()){
            return -1;
        }
       int item = s.pop();
       if(item < minElem){
           int temp = minElem;
           minElem = 2* minElem - item;
           return temp;
       }else{
           return item;
       }

    }
}
//Design a stack that returns a minimum element without using an auxiliary stack
public class MinElemFindInStack {
    public static void main(String[] args) {
//        MinStack s = new MinStack();
        MinStack1 s = new MinStack1(); // Design a stack that returns a minimum element without using an auxiliary stack

        s.push(6);
        System.out.println(s.getMin());    // prints 6

        s.push(7);
        System.out.println(s.getMin());    // prints 6

        s.push(8);
        System.out.println(s.getMin());    // prints 6

        s.push(5);
        System.out.println(s.getMin());    // prints 5

        s.push(3);
        System.out.println(s.getMin());    // prints 3

        System.out.println(s.pop());    // prints 3
        System.out.println(s.getMin());    // prints 5

        s.push(10);
        System.out.println(s.getMin());    // prints 5

        System.out.println(s.pop());    // prints 10
        System.out.println(s.getMin());    // prints 5

        System.out.println(s.pop());    // prints 5
        System.out.println(s.getMin());    // prints 6
    }
}

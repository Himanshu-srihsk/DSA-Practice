package k_non_repeating_characters_string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Node{
    int lastIndex;
    int count;

    public Node(int lastIndex, int count) {
        this.count = count;
        this.lastIndex = lastIndex;
    }

    @Override
    public String toString() {
        return "Node{" +
                "count=" + count +
                ", lastIndex=" + lastIndex +
                '}';
    }
}
public class k_non_repeating_characters_string {
    public static void findFirstKNonRepeating(String str, int k){
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((Node a, Node b) -> a.lastIndex - b.lastIndex);
        Map<Character, Node> mp = new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(mp.containsKey(str.charAt(i))){
                mp.put(str.charAt(i),new Node(i,mp.get(str.charAt(i)).count+1));
            }else{
               mp.put(str.charAt(i), new Node(i,1));
            }
        }

        for(Map.Entry<Character,Node> entry: mp.entrySet()){
            Node x = entry.getValue();
            System.out.println("key is "+ entry.getKey() + " node is "+ x);
            if(x.count==1){
                if(priorityQueue.size()>k){
                    if(priorityQueue.peek().lastIndex> x.lastIndex){
                        priorityQueue.poll();
                        priorityQueue.add(x);
                    }
                }else{
                    priorityQueue.add(x);
                }
            }
        }
        System.out.println("Printing ...");
        while(!priorityQueue.isEmpty()){

            System.out.print(str.charAt(priorityQueue.poll().lastIndex) + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String str = "ABCDBAGHCHFAC";
        int k = 3;

        findFirstKNonRepeating(str, k);
    }
}

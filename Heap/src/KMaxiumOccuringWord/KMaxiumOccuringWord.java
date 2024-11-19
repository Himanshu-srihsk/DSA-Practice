package KMaxiumOccuringWord;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Trie{
    Map<Character,Trie> mp;
    String str;
    int num;
    Trie(){
        mp = new HashMap<Character, Trie>();
        str = null;
        num =0;
    }
}
class Node{
    String str;
    int count;

    public Node(int count, String str) {
        this.count = count;
        this.str = str;
    }
}
public class KMaxiumOccuringWord {
    public static void insert(Trie root,String m){
        Trie curr = root;
        for(char c: m.toCharArray()){
            curr.mp.putIfAbsent(c,new Trie());
            curr = curr.mp.get(c);
        }
        curr.str = m;
        curr.num+=1;
    }
    public static void traverseTrie(Trie root,PriorityQueue<Node> pq){
        if(root==null){
            return;
        }
        for(Trie t : root.mp.values()){
            if(t.num>0){
                pq.add(new Node(t.num,t.str));

            }
            traverseTrie(t,pq);
        }
    }
    public static void findKfrequentWords(String[] dict, int k){
        Trie root = new Trie();

          for(String str: dict){
              insert(root,str);
          }

        PriorityQueue<Node> pq = new PriorityQueue<Node>((Node a, Node b) -> b.count - a.count);
          traverseTrie(root,pq);
          int i =0;
        while (!pq.isEmpty() && i<k){
            Node node= pq.poll();
            i++;
            System.out.println("String "+node.str + " occured ="+ node.count+" times");
        }
    }
    public static void main(String[] args) {
        String[] dict =
                {
                        "code", "coder", "coding", "codable", "codec", "codecs", "coded",
                        "codeless", "codec", "codecs", "codependence", "codex", "codify",
                        "codependents", "codes", "code", "coder", "codesign", "codec",
                        "codeveloper", "codrive", "codec", "codecs", "codiscovered"
                };

        int k = 4;

        findKfrequentWords(dict, k);
    }
}

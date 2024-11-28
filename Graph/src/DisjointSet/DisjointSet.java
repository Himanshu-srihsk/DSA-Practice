package DisjointSet;

import java.util.HashMap;
import java.util.Map;

class DisjointSet1{
    private Map<Integer,Integer> parent;
    int n;
    private Map<Integer,Integer> rank;
    public void makeSet(int[] arr){
        this.n = arr.length;
        parent = new HashMap<>(n);
        rank = new HashMap<>(n);
        for(int i:arr){
            parent.put(i,i);
            rank.put(i,0);
        }
    }
    public int find(int x){
        if (x != parent.get(x)) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }
    public boolean Union(int x,int y){
        int a = find(x);
        int b= find(y);
        //System.out.println("a="+ a+" b="+b);
        if(a==b){
           return false;
        }else{
            if(rank.get(a) > rank.get(b)){
                parent.put(b,a);
            } else if (rank.get(a) < rank.get(b)) {
                parent.put(a,b);
            }else{
                parent.put(b,a);
                rank.put(a, rank.get(a)+1);
            }
        }
        return true;
    }
}
public class DisjointSet {
    public static void printSets(int[] universe, DisjointSet1 ds){
        for (int i: universe) {
            System.out.print(ds.find(i) + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // universe of items
        int[] universe = { 1, 2, 3, 4, 5 };

        // initialize `DisjointSet` class
        DisjointSet1 ds = new DisjointSet1();

        // create a singleton set for each element of the universe
        ds.makeSet(universe);
        printSets(universe, ds);

        ds.Union(4, 3);        // 4 and 3 are in the same set
        printSets(universe, ds);

        ds.Union(2, 1);        // 1 and 2 are in the same set
        printSets(universe, ds);

        ds.Union(1, 3);        // 1, 2, 3, 4 are in the same set
        printSets(universe, ds);
    }
}

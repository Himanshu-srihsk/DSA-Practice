package TwoEdgeConnectivity;

import java.util.*;

class Edge{
    int src;
    int dest;
    Edge(int src,int dest){
        this.src = src;
        this.dest = dest;
    }
    @Override
    public String toString() {
        return "(" + src + ", " + dest + ')';
    }
}
class Graph{
    List<List<Integer>> adjList = null;
    int n;
    Graph(List<Edge> edges, int n){
        this.n = n;
        adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>(n));
        }
        for(Edge e: edges){
            adjList.get(e.src).add(e.dest);
            adjList.get(e.dest).add(e.src);
        }
    }

}
public class TwoEdgeConnectivity {
    public static int findBridges(Graph graph, int n, int time, Set<Edge> ans,boolean[] discovered,int[] arrival, int i, int parent){
           arrival[i]= ++time;
           discovered[i] = true;
           int minTime = arrival[i];
           for(int x: graph.adjList.get(i)){
               if(!discovered[x]){
                   minTime = Math.min(minTime, findBridges(graph,n,time,ans,discovered,arrival,x, i));
               }else{
                   if(parent!=x){
                       minTime = Math.min(minTime, arrival[x]);
                   }
               }
           }
           if(arrival[i] == minTime && parent!=-1){
               ans.add(new Edge(i,parent));
           }
           return minTime;
    }
    public static Set<Edge> findBridges(Graph graph, int n){
        Set<Edge> ans = new HashSet<>();
        boolean[] discovered = new boolean[n];
        int[] arrival = new int[n];
        int time =0;
        for(int i=0;i<n;i++){
            time  = findBridges(graph,n,time,ans,discovered,arrival,i,-1);
        }
        return ans;
    }
    public static void main(String[] args) {
        // (u, v) triplet represent undirected edge from vertex `u` to vertex `v`
        List<Edge> edges = Arrays.asList(
                new Edge(0, 2), new Edge(1, 2), new Edge(2, 3),
                new Edge(2, 4), new Edge(3, 4), new Edge(3, 5)
        );

        // total number of nodes in the graph (0 to 6)
        int n = 6;

        // construct graph
        Graph graph = new Graph(edges, n);

        // find and print bridges
        Set<Edge> bridges = findBridges(graph, n);

        if (bridges.size() != 0) {
            System.out.println("Bridges are " + bridges);
        } else {
            System.out.println("Graph is 2–Edge Connected");
        }
    }
}

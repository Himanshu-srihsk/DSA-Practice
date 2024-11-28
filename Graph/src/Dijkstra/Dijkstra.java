package Dijkstra;

import java.util.*;

class Edge{
    int src;
    int dest;
    int weight;
    Edge(int src,int dest,int weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "(" + src + ", " + dest + ')';
    }
}
class Graph{
    List<List<Edge>> adjList = null;
    int n;
    Graph(List<Edge> edges, int n){
        this.n = n;
        adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>(n));
        }
        for(Edge e: edges){
            adjList.get(e.src).add(e);
         //   adjList.get(e.dest).add(e.src);
        }
    }

}
class Node{
    int vertex;
    int dist;
    Node(int vertex,int dist){
        this.vertex = vertex;
        this.dist = dist;
    }

    @Override
    public String toString() {
        return "Node{" +
                "dist=" + dist +
                ", vertex=" + vertex +
                '}';
    }
}
public class Dijkstra {
    public static void findShortestPaths(Graph graph,int src,int n){
       int[] dist = new int[n];
       Arrays.fill(dist,Integer.MAX_VALUE);
       dist[src] =0;
       int[] parent = new int[n];
       for(int i = 0;i<n;i++){
           parent[i] =i;
       }
       parent[src] = -1;
        boolean[] discovered = new boolean[n];
        discovered[src] = true;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(Comparator.comparingInt((Node a) -> a.dist));
        pq.add(new Node(src,dist[src]));
        while(!pq.isEmpty()){
            Node node = pq.poll();
          //  System.out.println("Node is"+ node);
            int u = node.vertex;
            for(Edge i: graph.adjList.get(u)){
                int des = i.dest;
                int w = i.weight;
                if(!discovered[des]){
                   // System.out.println("efef d");
                    if(dist[src]!=Integer.MAX_VALUE && dist[u] + w < dist[des]){
                     //   System.out.println("dbeb d");
                        dist[des] = dist[u] + w;
                        parent[des] = u;
                        pq.add(new Node(des,dist[des]));
                    }
                }
            }
            discovered[u] = true;
        }

        List<Integer> route = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(i!=src && dist[i]!=Integer.MAX_VALUE){
                route = new ArrayList<>();
                System.out.println("Distance b/w "+ src + " and "+ i + " is"+ dist[i]);
                route.add(src);
                addRoute(route,i, parent);
              //  route.add(i);
                System.out.println("Route is"+ route);
            }
        }
    }
    public static void addRoute(List<Integer> route,int x, int[] parent){
        if(parent[x] <0){
            return;
        }
         addRoute(route, parent[x],parent);
        route.add(x);
    }
    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 10), new Edge(0, 4, 3), new Edge(1, 2, 2),
                new Edge(1, 4, 4), new Edge(2, 3, 9), new Edge(3, 2, 7),
                new Edge(4, 1, 1), new Edge(4, 2, 8), new Edge(4, 3, 2)
        );

        // total number of nodes in the graph (labelled from 0 to 4)
        int n = 5;

        // construct graph
        Graph graph = new Graph(edges, n);

        // run the Dijkstra’s algorithm from every node
        for (int source = 0; source < n; source++) {
            findShortestPaths(graph, source, n);
        }
    }
}

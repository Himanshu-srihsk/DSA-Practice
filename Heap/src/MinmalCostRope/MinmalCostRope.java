package MinmalCostRope;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
Connect `n` ropes with minimal cost
Given n ropes of different lengths, connect them into a single rope with minimum cost. Assume that the cost to connect two ropes is the same as the sum of their lengths.
 */
public class MinmalCostRope {
    public static int findMinCost(List<Integer> prices){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(prices);
        int cost = 0;
        while (pq.size()>=2){
            int sum = pq.poll() + pq.poll();
            cost+=sum;
            pq.add(sum);
        }
        return cost;
    }
    public static void main(String[] args) {
        List<Integer> prices = Arrays.asList(5, 4, 2, 8);
        System.out.println("The minimum cost is " + findMinCost(prices));
    }
}

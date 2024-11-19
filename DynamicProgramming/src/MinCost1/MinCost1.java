package MinCost1;

import java.util.Arrays;

/*
Find minimum cost to reach the last cell of a matrix from its first cell

Given an M × N matrix of integers where each cell has a cost associated with it, find the minimum cost to reach the last cell (M-1, N-1) of the matrix from its first cell (0, 0).
 We can only move one unit right or one unit down from any cell, i.e., from cell (i, j), we can move to (i, j+1) or (i+1, j).
 */
public class MinCost1 {
    static int[] row = {1,0};
    static int[] col = {0,1};
    public static boolean canGo(int x,int y,int m,int n){
        return x>=0 &&x<m && y>=0 && y<n;
    }
    public static int findMinCost(int[][] cost, int i,int j,int m,int n,int[][] dp){
        if(i==m-1 && j==n-1){
            return cost[i][j];
        }
        int minCost = Integer.MAX_VALUE;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        for(int k = 0;k<row.length;k++){
            int newI = i+ row[k];
            int newJ = j+col[k];
            if(canGo(newI,newJ,m,n)){
               minCost = Math.min(minCost,findMinCost(cost,newI,newJ,m,n,dp)+cost[i][j]);
            }
        }
        dp[i][j] = minCost;
        return dp[i][j];

    }
    public static int findMinCost(int[][] cost){
        int[][] dp = new int[cost.length][cost[0].length];
        for(int i=0;i<cost.length;i++){
           Arrays.fill(dp[i],-1);
        }
       return findMinCost(cost, 0,0, cost.length, cost[0].length,dp);
    }
    public static int findMinCostTabluation(int[][] cost){
        int[][] dp = new int[cost.length][cost[0].length];
        dp[0][0] = cost[0][0];
        int m = cost.length;
        int n= cost[0].length;
        for(int i=1;i<m;i++){
            dp[i][0]= dp[i-1][0]+cost[i][0];
        }
        for(int i=1;i<n;i++){
            dp[0][i]= dp[0][i-1]+cost[0][i];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j])+cost[i][j];
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        int[][] cost =
                {
                        { 4, 7, 8, 6, 4 },
                        { 6, 7, 3, 9, 2 },
                        { 3, 8, 1, 2, 4 },
                        { 7, 1, 7, 3, 7 },
                        { 2, 9, 8, 9, 3 }
                };

        System.out.println("The minimum cost is " + findMinCost(cost));
        System.out.println("The minimum cost is " + findMinCostTabluation(cost));
    }
}

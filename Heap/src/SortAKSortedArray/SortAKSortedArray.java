package SortAKSortedArray;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
Sort a k-sorted array
Given a k–sorted array that is almost sorted such that each of the n elements may be misplaced by no more than k positions from the correct sorted order. Find a space-and-time efficient algorithm to sort the array.
Input: arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9]k = 2 Output:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 */
public class SortAKSortedArray {
    public static void sortKSortedArray(List<Integer> nums,int k){
       PriorityQueue<Integer> pq = new PriorityQueue<>(k+1);

        int i=0;
        int size= k+1;
        int idx =0;
        while(i<nums.size()){
            if(pq.size()<size){
                pq.add(nums.get(i));
            }else{
              nums.set(idx++,pq.poll());
                pq.add(nums.get(i));
            }
            i++;
        }
        while(!pq.isEmpty()){
            nums.set(idx++,pq.poll());
        }
    }
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 4, 5, 2, 3, 7, 8, 6, 10, 9);
        int k = 2;

        sortKSortedArray(nums, k);
        System.out.println(nums);
    }
}

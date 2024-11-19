package MaxTominHeap;

import java.util.Arrays;
class MinHeap{
    static int size;
    public static void convert(int[] A){
        size = A.length;
        int i=(size-1)/2;
        while(i>=0){
            heapify(i--,A);
        }
    }
    public static void heapify(int i, int[] arr){
        int leftIdx = parentleft(i);
        int rightIdx = parentright(i);
        int minIdx =i;
        if(leftIdx< size && arr[minIdx]>arr[leftIdx]){
            minIdx = leftIdx;
        }
        if(rightIdx<size && arr[minIdx] > arr[rightIdx]){
            minIdx = rightIdx;
        }
        if(minIdx!=i){
            swap(arr,minIdx,i);
            heapify(minIdx,arr);
        }
    }
    public static int parentleft(int i){
        return 2*i+1;
    }
    public static int parentright(int i){
        return 2*i+2;
    }
    public static void swap(int[] arr,int minIdx,int i){
        int temp = arr[minIdx];
        arr[minIdx] = arr[i];
        arr[i] = temp;
    }
}
public class MaxTominHeap {
    public static void main(String[] args) {

        /*
                   9
                 /   \
                /     \
               4       7
              / \     / \
             /   \   /   \
            1    -2 6     5
        */

        // an array representing the max-heap
        int[] A = { 9, 4, 7, 1, -2, 6, 5 };

        // build a min-heap by initializing it by the given array
        MinHeap.convert(A);

        // print the min-heap
        /*
                   -2
                 /    \
                /      \
               1        5
              / \      / \
             /   \    /   \
            9     4  6     7
        */

        System.out.println(Arrays.toString(A));
    }
}

package HeapSortAlgo;

import java.util.Arrays;

/*
Out-of-place Heapsort Implementation
 */
class PriorityQueue{
    int[] arr;
    int size;
    public int parentleft(int i){
        return 2*i+1;
    }
    public int parentright(int i){
        return 2*i+2;
    }
    public void swap(int[] arr,int minIdx,int i){
        int temp = arr[minIdx];
        arr[minIdx] = arr[i];
        arr[i] = temp;
    }
    PriorityQueue(int []a){
        this.arr = Arrays.copyOf(a,a.length);
        this.size = this.arr.length;
        int i=(size-1)/2;
        while(i>=0){
            heapify(i--);
        }
    }
    public void heapify(int i){
        int leftIdx = parentleft(i);
        int rightIdx = parentright(i);
        int minIdx =i;
        if(leftIdx< size && this.arr[minIdx]>this.arr[leftIdx]){
            minIdx = leftIdx;
        }
        if(rightIdx<size && this.arr[minIdx] > this.arr[rightIdx]){
            minIdx = rightIdx;
        }
        if(minIdx!=i){
            swap(this.arr,minIdx,i);
            heapify(minIdx);
        }
    }
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("Arrays is already Empty cannnot pop");
        }
       int temp = this.arr[0];
       this.arr[0] = this.arr[size-1];
       size--;
       heapify(0);
       return temp;
    }
    public boolean isEmpty(){
         return this.size == 0;
    }
}
public class HeapSortAlgo {
    public static void heapsort(int[] A){
        PriorityQueue pq = new PriorityQueue(A);
        int i=0;
        while(!pq.isEmpty()){
            A[i++] = pq.pop();
        }
    }
    public static void main(String[] args) {
        int[] A = { 6, 4, 7, 1, 9, -2 };

        // perform heapsort on the array
        heapsort(A);

        // print the sorted array
        System.out.println(Arrays.toString(A));
    }
}

package SortingArray;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface SortingStrategy{
    public int[] sortArray(int []arr);
}
class BubbleSort implements SortingStrategy{
   public void swap(int[] arr,int i,int j){
     int temp = arr[i];
     arr[i] = arr[j];
     arr[j] = temp;
   }
    @Override
    public int[] sortArray(int[] arr) {
        System.out.println("BubbleSort: Arr to Sort: "+ Arrays.toString(arr));
        if(arr.length <2 || arr==null){
            return arr;
        }
        int n= arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    swap(arr,i,j);
                }
            }
        }
        return arr;
    }
}

class MergeSort implements SortingStrategy{

    @Override
    public int[] sortArray(int[] arr) {
        System.out.println("MergeSort: Arr to Sort: "+ Arrays.toString(arr));
        if(arr.length <2 || arr==null){
            return arr;
        }
        int n= arr.length;
         mergesort(0,n-1,arr);
        return arr;

    }
    public void mergesort(int start,int end,int[] arr){
        if(start>=end){
            return;
        }
        int mid=(start+ ((end-start)/2));
        mergesort(start,mid,arr);
        mergesort(mid+1,end,arr);
        merge(start,mid,end,arr);
    }
    public void merge(int start,int mid,int end,int[] arr){
        //int[] aux =Arrays.copyOf(arr,arr.length);
int[] aux = new int[end-start+1];
        int i = start;
        int j = mid+1;
        int k = 0;

        while(i<=mid && j <= end){
            if(arr[i] <= arr[j]){
                aux[k++] = arr[i++];
            }else{
                aux[k++] = arr[j++];
            }
        }
        while(i<=mid){
            aux[k++] = arr[i++];
        }
        while(j<=end){
            aux[k++] = arr[j++];
        }
      k=0;
        for( i = start;i<=end;i++){
            arr[i] = aux[k++];
        }
    }
}
class QuickSort implements SortingStrategy{
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public int[] sortArray(int[] arr) {
        System.out.println("QuickSort: Arr to Sort: "+ Arrays.toString(arr));
        if(arr.length <2 || arr==null){
            return arr;
        }
        int n= arr.length;
        QuickSort(0,n-1,arr);
        return arr;
    }
    public int findPivotPos(int start,int end,int [] arr){
        int pivot = arr[end];
        int pInd =start;
        for(int i=start;i<end;i++){
            if(arr[i] <= pivot){
                swap(arr,pInd,i);
                pInd++;
            }
        }
        swap(arr,pInd,end);
        return pInd;
    }
    public void QuickSort(int start,int end,int [] arr){
        if(start>=end){
            return;
        }
        int mid=(start+ ((end-start)>>1));
        int pos = findPivotPos(start,end,arr);
        QuickSort(start,pos-1,arr);
        QuickSort(pos+1,end,arr);

    }
}
class HeapSort implements SortingStrategy{

    @Override
    public int[] sortArray(int[] arr) {
        return new int[0];
    }
}
class InsertionSort implements SortingStrategy{

    @Override
    public int[] sortArray(int[] arr) {
        System.out.println("InsertionSort: Arr to Sort: "+ Arrays.toString(arr));
        if(arr.length <2 || arr==null){
            return arr;
        }
        int n= arr.length;
        InsertionSort(0,n-1,arr);
        return arr;
    }
    public void InsertionSort(int start, int end, int[] arr){

        for(int i= start+1;i<=end;i++){
            int j = i;
            int value = arr[i];

            while(j>0 && arr[j-1] > value){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = value;

        }
    }
}
class SortingContext{
    SortingStrategy sortingStrategy;
    SortingContext(SortingStrategy sortingStrategy){
        this.sortingStrategy = sortingStrategy;
    }
    public int[] sort(int[] nums){
      return  this.sortingStrategy.sortArray(nums);
    }

}
public class SortingArrayUsingStrategy {
    public static void main(String[] args) {
        int[] nums = {1,3,2,0,1,0,4,0,5,0,4,0,5,-1,-3,4,5,0,4,5};
          SortingContext sortingContext = new SortingContext(new BubbleSort());
          System.out.println("Bubble Sorted array is"+ Arrays.toString(sortingContext.sort(nums.clone())));

        sortingContext = new SortingContext(new MergeSort());
        System.out.println("Merge Sorted array is"+ Arrays.toString(sortingContext.sort(nums.clone())));

        sortingContext = new SortingContext(new QuickSort());
        System.out.println("Quick Sorted array is"+ Arrays.toString(sortingContext.sort(nums.clone())));
//
//        sortingContext = new SortingContext(new HeapSort());
//        System.out.println("Bubble Sorted array is"+ Arrays.toString(sortingContext.sort(nums.clone())));
//
        sortingContext = new SortingContext(new InsertionSort());
        System.out.println("InsertionSort Sorted array is"+ Arrays.toString(sortingContext.sort(nums.clone())));

        //sort by stream
        System.out.println("Stream Sorted array is"+ Arrays.toString(Arrays.stream(nums.clone()).sorted().toArray()));
    }

}

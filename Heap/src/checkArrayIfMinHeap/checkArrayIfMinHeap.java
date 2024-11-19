package checkArrayIfMinHeap;

public class checkArrayIfMinHeap {
    public static boolean checkMinHeap(int []A,int ind){
        int size = A.length;
        int left = 2*ind+1;
        int right = 2*ind+2;
        if(ind>=A.length){
            return true;
        }
        boolean isLeftHeap = checkMinHeap(A, left);
        boolean isRightHeap = checkMinHeap(A, right);
        if(!isLeftHeap || !isRightHeap || (left<A.length && A[ind] >= A[left]) || right < A.length && A[ind] >= A[right]){
            return false;
        }
        return  isLeftHeap && isRightHeap;
    }
    public static boolean checkMinHeapIterative(int []A){
        int size = A.length;
        int i = (size-1)/2;
        while(i>0){
            int left = 2*i+1;
            int right = 2*i+2;
            if(left<A.length && A[i] >= A[left] || right < A.length && A[i] >= A[right]){
                return false;
            }
            i--;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6};

        // start with index 0 (the root of the heap)
        int index = 0;

        if (checkMinHeap(A, index)) {
            System.out.println("The given array is a min-heap");
        }
        else {
            System.out.println("The given array is not a min-heap");
        }

        if (checkMinHeapIterative(A)) {
            System.out.println("The given array is a min-heap");
        }
        else {
            System.out.println("The given array is not a min-heap");
        }
    }
}

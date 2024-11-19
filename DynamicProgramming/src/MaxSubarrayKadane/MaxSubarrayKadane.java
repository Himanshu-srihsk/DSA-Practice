package MaxSubarrayKadane;

import java.util.Arrays;

public class MaxSubarrayKadane {
    public static int kadane(int[] arr){
//        int max = Arrays.stream(arr).max().getAsInt();
//        if(max <=0){
//            return max;
//        }
//        int maxSoFar = 0;
//        int curr =0;
//        for(int c: arr){
//            curr = Math.max(curr+c,0);
//            if(curr>maxSoFar){
//                maxSoFar = curr;
//            }
//        }
//        return maxSoFar;
        int maxSoFar = Integer.MIN_VALUE;
        int curr = 0;
        for(int c: arr){
            curr = Math.max(curr+c,c);
            if(curr>maxSoFar){
                maxSoFar = curr;
            }
        }
        return maxSoFar;
    }
    public static void main(String[] args) {
       // int[] arr = { -8, -3, -6, -2, -5, -4 };
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        System.out.println("The sum of contiguous subarray with the " +
                "largest sum is " +    kadane(arr));
    }
}

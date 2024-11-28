package MaximumProductSubarray;

public class MaximumProductSubarray {
    public static int findMaxProduct(int[] A){
      int maxNeg = Integer.MAX_VALUE;
      int maxPos = Integer.MIN_VALUE;
      int n = A.length;
      int maxProduct = A[0];
      int productSoFar = 0;
      int numZero = 0;
      for(int i=0;i<n;i++){
          if(A[i] == 0){
              numZero++;
          }
          if(i==0){
              maxNeg = A[i];
              maxPos = A[i];
              maxProduct = A[i];
              productSoFar = A[i];
          }else{
              int temp = maxNeg;
              maxNeg = Math.min(maxPos*A[i],Math.min( maxNeg*A[i], A[i]));
              maxPos = Math.max(maxPos* A[i], Math.max(temp*A[i], A[i]));
              maxProduct = Math.max(maxProduct, Math.max(maxPos,maxNeg));
          }
      }
      if(maxProduct < 0){
          if(numZero>0){
              return 0;
          }
      }
      return maxProduct;
    }
    public static void main(String[] args) {
//        int[] A = { -6, 4, -5, 8, -10, 0, 8 };
        int[] A = { -4,-9,-6, 0,  0, 0 , -2, -4};

        System.out.println("The maximum product of a subarray is " + findMaxProduct(A));
    }
}

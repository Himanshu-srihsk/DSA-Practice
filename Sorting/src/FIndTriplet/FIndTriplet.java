package FIndTriplet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FIndTriplet {
    public static void printAllTriplets(int[] nums,int target){
       int[] newArr = Arrays.stream(nums).sorted().toArray();
        System.out.println("Array is "+ Arrays.toString(newArr));
        int n = newArr.length;
        for(int i=0;i<n-2;i++){
            int sum = target - newArr[i];
            int start = i+1;
            int end = n-1;
            while(start < end){
                int x = newArr[start]+ newArr[end];
                if(x==sum){
                    System.out.println("Target ="+ target + " Found at "+ i + " "+ start+ " "+ end);
                    start++;
                    end--;
                }else if(x> sum){
                    end--;
                }else{
                    start++;
                }
            }
        }
    }
    public static boolean printAllTripletsUsingMap(int[] nums,int target){
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0; i<n;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int remaining = target - nums[i]- nums[j];
              if(map.containsKey(remaining) && map.get(remaining)!= i && map.get(remaining)!=j){
                 // System.out.println("Target ="+ target + " Found at "+ i + " "+ j+ " "+ map.get(remaining));
                  return true;
              }

            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = { 2, 7, 4, 0, 9, 5, 1, 3 };
        int target = 6;

         printAllTriplets(nums, target);
        if(printAllTripletsUsingMap(nums,target)){
            System.out.println("Triplet Exists");
        }else{
            System.out.println("Triplet doesnot Exists");
        }
    }
}

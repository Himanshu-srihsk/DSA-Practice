package LongestPalindromeSubstring;

public class LongestPalindromeSubstring {
    public static String findLongestPalindromicSubstring(String str){
        if(str==null || str.length()==0){
            return str;
        }
        int n = str.length();
        int maxLen = 1;
        int lastIdx = 0;
        for(int i=0;i<n;i++){
            int j=i-1;
            int size = 1;
            int k = i+1;
            while(j>=0 && k < n && str.charAt(j) ==  str.charAt(k)){
                j--;
                k++;
                size+=2;
            }
            if(maxLen< size){
                maxLen = size;
                lastIdx = k;
            }

            j=i-1;
            k=i;
            size = 0;
            while(j>=0 && k < n && str.charAt(j) ==  str.charAt(k)){
                j--;
                k++;
                size+=2;
            }
            if(maxLen< size){
                maxLen = size;
                lastIdx = k;
            }
        }
        return str.substring(lastIdx-maxLen, lastIdx);
    }
    public static void main(String[] args) {
        String str = "ABDCBCDBDCBBC";

        System.out.println("The longest palindromic substring of " + str + " is "
                + findLongestPalindromicSubstring(str));
        //The longest palindromic substring of ABDCBCDBDCBBC is BDCBCDB
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        return divideAndConquer(strs,0,strs.length-1);
    }
    public String divideAndConquer(String[] strs,int start,int end){
        if(start==end){
            return strs[start];
        }
        if(start<end){
            int mid=start+(end-start)/2;
            String str1=divideAndConquer(strs,start,mid);
            String str2=divideAndConquer(strs,mid+1,end);
            int i=0;
            while(i<str1.length() && i<str2.length()){
                if(str1.charAt(i)!=str2.charAt(i)){
                    break;
                }
                i++;
            }
            return str1.substring(0,i);
        }
        return "";
    }
}
// T.C -> O(m*logn) each level of recursion divides the problem into two subproblems of roughly half the size
// while loop within the divideAndConquer function iterates through the characters of two strings to find the longest common prefix. In worst case, it iterates through all characters of the shortest string, which takes O(m) time
// S.C -> O(logn) At each level of recursion, a constant amount of space is used for variables and parameters to store recursion stack, which keeps track of function calls and their parameters
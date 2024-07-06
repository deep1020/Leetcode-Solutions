class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Find maximum element in the given array
        // int count[]=new int[1001];
        // for(int num:arr1){
        //     count[num]++;
        // }
        int maxLen=Integer.MIN_VALUE;
        for(int i=0;i<arr1.length;i++){
            maxLen=Math.max(maxLen,arr1[i]);
        }
        // Create a count array to store the frequency of each element of arr1
        int count[]=new int[maxLen+1];
        for(int num:arr1){
            count[num]++;
        }
        // Sort arr1 based on arr2's order
        int index=0;
        for(int num:arr2){
            while(count[num]>0){
                arr1[index++]=num;
                count[num]--;
            }
        }
        // Append the remaining elements in arr1 
        // Example 1: 7 and 19 are not present in arr2 so include those in arr1 at the end
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                arr1[index++]=i;
                count[i]--;
            }
        }
        return arr1;
    }
}
// T.C -> O(n+m+k) 
// Counting the frequency of elements in arr1 takes O(n)
// Sorting arr1 based on the order of elements in arr2 takes O(m)
// Appending the remaining elements takes O(n+k) times
// S.C -> O(1) constant 1001 extra space considers O(1)
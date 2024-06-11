class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Count the frequency of each element in arr1
        int count[]=new int[1001];
        for(int num:arr1){
            count[num]++;
        }
        // Sort arr1 based on arr2's order
        int index=0;
        for(int num:arr2){
            while(count[num]-- > 0){
                arr1[index++]=num;
            }
        }
        // Append the remaining elements in arr1
        for(int i=0;i<count.length;i++){
            while(count[i]-- > 0){
                arr1[index++]=i;
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
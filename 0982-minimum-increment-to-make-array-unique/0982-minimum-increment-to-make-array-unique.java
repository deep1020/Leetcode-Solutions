class Solution {
    public int minIncrementForUnique(int[] nums) {
        // Find the maximum element in the array
        int maxVal=Integer.MIN_VALUE;
        for(int num:nums){
            maxVal=Math.max(maxVal,num);
        }
        // Create a counting array to store the count of each element
        int count[]=new int[maxVal+1];
        // Count the occurrences of each element
        for(int num:nums){
            count[num]++;
        }
        int index=0;
        // store the sorted array in nums
        for(int i=0;i<=maxVal;i++){
            while(count[i]>0){
                nums[index++]=i;
                count[i]--;
            }
        }
        int minMoves=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                minMoves+=nums[i-1]-nums[i]+1;
                nums[i]=nums[i-1]+1;
            }
        }
        return minMoves;
    }
}
// T.C -> O(n+m) step of creating and populating the counting array, which is O(n) 
// S.C -> O(n) maxVal size is equal to nums.length
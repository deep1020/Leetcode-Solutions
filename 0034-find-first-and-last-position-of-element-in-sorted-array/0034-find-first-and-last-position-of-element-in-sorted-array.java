class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start=-1;
        int end=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                if(start==-1){
                    start=i;
                }
                end=i;
            }
        }
        return new int[]{start,end};
    }
}

// T.C -> O(n) worst case, traverse entire array
// S.C -> O(1) constant extra space is used

// Linear Search Approach
// Initialize two variables, start and end to -1
// Iterate through sorted array from left to right
// When you find target element for the first time, set start to the current index
// Continue iteraing to find last occurrence of target element and update end whenever you find it
// Return array of start and end

// corner case: 
// Input: nums=[1] target=1
// Output: [0,-1] Expected: [0,0]
// if(start==-1){
//     start=i;
// }
// else{
//     end=i;
// }
class Solution {
    public int jump(int[] nums) {
        int start=0,end=0;
        int farthest=0;
        int jump=0;
        for(int i=0;i<nums.length-1;i++){
            farthest=Math.max(farthest,i+nums[i]);
            if(i==end){
                end=farthest;
                jump++;
            }
        }
        return jump;
    }
}
// T.C -> O(n)
// S.C -> O(1)

// Greedy Approach:

// 1) Initialize all variables to 0
// start: Tracks the beginning of the current range of indices that can be reached with the current number of jumps
// end: Tracks the farthest point that can be reached with the current number of jumps
// farthest: Tracks the farthest point that can be reached with the next jump
// jump: Counts the number of jumps made
// 2) Loop through each element in the array (except the last one)
// For each index i, calculate the farthest point that can be reached with a jump from index i using farthest = Math.max(farthest, i + nums[i])
// If i reaches the end of the current jump range (i == end):
// Update end to farthest, the farthest point reachable with the next jump
// Increment the jump counter by 1
// Continue this process until the loop ends, which means all indices up to the second last index have been processed.
// 3) Return total number of jumps needed to reach the last index

// nums = [2,3,1,1,4]
// We can use any of values in between this start and end to be used as the next jump
// Either we can jump from 3 or 1
// At each step, we find out how much farthest we can reach using value that is present in this block

// Note: Math.min directly in the context of finding the minimum number of jumps to reach the last index is not straightforward because the problem is more about finding an optimal path rather than directly minimizing values

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result=Integer.MAX_VALUE;
        int currentSum=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            currentSum+=nums[right];
            while(currentSum>=target){
                result=Math.min(result,right-left+1);
                currentSum-=nums[left];
                left++;
            }
        }
        if(result==Integer.MAX_VALUE){
            return 0;
        }
        return result;
    }
}
// T.C -> O(n) moving left and right accross length of array
// S.C -> O(1)

//1) result=Integer.MAX_VALUE will keep track of the minimal length of the subarray satisfying the condition.
//2) currentSum will store the current sum of elements within the sliding window.
//3) left will represent the left boundary of the sliding window.
//4) Loop through the array using the right pointer: Increment currentSum by the value of nums[right], effectively expanding the window to the right.
//5) while loop checks if currentSum>=target
// - If currentSum>=target, update result with the minimum value of result and right - left + 1, which represents the length of the current subarray that satisfies the condition.
// - Decrement currentSum by the value of nums[left] and increment left, effectively shifting the left boundary of the sliding window to the right.
//6) After the while loop, if result is still Integer.MAX_VALUE, it means no subarray was found that satisfies the condition. In this case, return 0.
//7) Otherwise, return the value of result, which represents the minimal length of a subarray whose sum is greater than or equal to the target.
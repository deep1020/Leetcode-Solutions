class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
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
// T.C -> O(nlogn)
// S.C -> O(1)
// sort nums elements as we need minimum element first and we can compare current element with previous element to make current element unique by incrementing 1
// Iterate from nums[1] to num.length-1. we don't take nums[0] as it's already minimum
// Compare current element with previous element i.e nums[i]<=nums[i-1]
// If current element is less than equal to previous element, find min moves required using nums[i-1]-nums[i]+1
// Make current element incrementing by 1 of previous element i.e nums[i]=nums[i-1]+1
// Return min moves
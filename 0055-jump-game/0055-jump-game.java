class Solution {
    public boolean canJump(int[] nums) {
        int lastIndex=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=lastIndex){
                lastIndex=i;
            }
        }
        return lastIndex==0;
    }
}
// T.C -> O(n)
// S.C -> O(1)
// Greedy Approach
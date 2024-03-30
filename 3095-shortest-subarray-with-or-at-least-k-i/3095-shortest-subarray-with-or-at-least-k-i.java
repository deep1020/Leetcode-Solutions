class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int minLength=Integer.MAX_VALUE;
        for(int left=0;left<nums.length;left++){
            int currentOR=0;
            for(int right=left;right<nums.length;right++){
                currentOR=currentOR|nums[right];
                if(currentOR>=k){
                    minLength=Math.min(minLength,right-left+1);
                    break;
                }
            }
        }
        return minLength==Integer.MAX_VALUE ? -1 : minLength;
    }
}
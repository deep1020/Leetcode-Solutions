class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int ans=0;
        int count=0;
        int flipped[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i>=k){ // Help to maintain window of k size 
                count-=flipped[i-k];
            }
            if((nums[i]==1 && count%2==1) || (nums[i]==0 && count%2==0)){
                if(i+k>nums.length){
                    return -1;
                }
                ans++;
                count++;
                flipped[i]=1;
            }
        }
        return ans;
    }
}
// T.C -> O(n)
// S.C -> O(n)
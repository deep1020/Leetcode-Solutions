class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int zeroSum=0;
        int windowSum=0;
        int maxWindowSum=0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0){
                zeroSum+=customers[i];
            }
            else{
                windowSum+=customers[i];
            }
            if(i>=minutes){
                if(grumpy[i-minutes]==1){
                    windowSum-=customers[i-minutes];
                }
            }
            maxWindowSum=Math.max(maxWindowSum,windowSum);
        }
        return maxWindowSum+zeroSum;
    }
}
// T.C -> O(n) where n= length of customers array which is traversed only once
// S.C -> O(1) no additional data structure is used beyond a few integer variables

// zeroSum: sum of customers when the owner is not grumpy
// windowSum: when owner is grumpy, keep track of sum of customers in the curremt window of length minutes
// maxWindowSum: Tracks the maximum sum of customers that can be satisfied by converting grumpy periods to non-grumpy 
// If the current customer is not grumpy, add to zeroSum.
// If the current customer is grumpy, add to windowSum.
// Sliding Window: Once the index exceeds the window size (minutes), subtract the customer count at the start of the window if they were grumpy
// Continuously update maxWindowSum to hold the maximum windowSum found so far
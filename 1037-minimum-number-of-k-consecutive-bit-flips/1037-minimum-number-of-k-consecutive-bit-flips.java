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
// T.C -> O(n) loop iterates through each element of the nums array exactly once
// S.C -> O(n) extra array flipped takes O(n) space. Variables like ans and count use O(1) space

// ans: keeps track of the number of flips performed
// count: track the number of flips within the current window
// flipped: mark the positions where a flip has been performed
// for loop iterates through each element of the nums array
// For each element, the code checks if the current position is beyond the k-size window. If so, it adjusts the count by subtracting the flip status (flipped[i-k]) that is no longer in the window.
// condition 1: nums[i] == 1 && count % 2 == 1
// If the current element is 1 and the number of flips is odd, the actual value of the element (after applying the flips) is 0. This is because flipping an element an odd number of times inverts its value (1 becomes 0 and 0 becomes 1). Therefore, we need to flip it again to make it 1.
// condition 2: nums[i] == 0 && count % 2 == 0 -> similar to condition 1
// After both condition passed, code checks if flipping the next k bits is possible (i + k > nums.length)
// If not, it returns -1 indicating it is impossible to achieve the goal
// Otherwise, it increments ans and count, and marks the current position in the flipped array to indicate a flip has been performed
// final value of ans, which represents the total number of flips required, is returned
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int rem[]=new int[k];
        rem[0]=1;
        int sum=0,count=0;
        for(int num:nums){
            sum=(sum+num)%k;
            if(sum<0){
                sum+=k;
            }
            count+=rem[sum];
            rem[sum]++;
        }
        return count;
    }
}
// T.C -> O(n) Iterate over all elements of nums array
// S.C -> O(k) rem array takes k space
// prefix sum approach
// Take rem array to keep track of the frequency of each remainder
// Initialize the frequency of remainder 1 for index 0
// Initialize cumulative sum and count of valid subarrays
// Loop through each number in the array
// Update the cumulative sum and take mod k to get the remainder
// Adjust the remainder to be non-negative
// Add the frequency of the current remainder to count
// Increment the frequency of the current remainder in the rem array
// Return the total count of subarrays whose sum is divisible by k
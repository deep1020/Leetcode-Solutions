class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int currSum=0;
        int subarrays=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(currSum,1);
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i]%2;
            if(map.containsKey(currSum-k)){
                subarrays+=map.get(currSum-k);
            }
            map.put(currSum,map.getOrDefault(currSum,0)+1);
        }
        return subarrays;
    }
}
// T.C -> O(n) Iterate through nums array exactly once
// S.C -> O(n) Insert key-value pair in HashMap

// currSum: keep track of the cumulative sum of the number of odd numbers found so far
// subarrays: count the number of valid subarrays
// HashMap: stores the frequency of cumulative sums found. It helps to quickly check how many times a particular cumulative sum has occurred.
// Base case: map.put(currSum, 1) initializes the map with the cumulative sum 0 occurring once. This is to handle the case where a subarray starting from the beginning of the array has exactly k odd numbers.
// For each element in nums array, the code checks if the element is odd using nums[i]%2. If it is odd, it adds 1 to currSum. If it is even, it adds 0.
// Checks if currSum - k is present in the map. If it is, it means there are subarrays ending at the current index which have exactly k odd numbers. The count of such subarrays is added to subarrays.
// It updates the map with the current value of currSum.

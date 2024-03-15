class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-goal)){
                count+=map.get(sum-goal);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
// T.C -> O(n) where n= length of num array. Inside the loop, each iteration involves constant-time operations 
// such as updating the sum, checking if a key exists and updating values in the map
// S.C -> O(n) In the worst case, the size of the map can be equal to the length of the nums array

// Initializes a HashMap map to store the cumulative sum calculated and their frequencies
// It starts with a single entry map.put(0, 1) to handle the case where the sum = goal at the beginning of the array.
// Initializes variables sum and count to keep track of the cumulative sum and the count of subarrays found
// Iterates through the nums array, adding each element to the sum and 
// checking if there exists a previous cumulative sum - goal in the map. 
// If such a sum exists, it means there is a subarray whose sum equals the goal -> if(map.containsKey(sum-goal)) then
// it increments the count by the frequency of that sum found in the map. -> count+=map.get(sum-goal);
// It updates the map with the current cumulative sum by putting or updating its frequency. -> map.put(sum,map.getOrDefault(sum,0)+1);
// Finally, it returns the count, which represents the total number of subarrays whose sum equals the goal.

// Input: nums = [1,0,1,0,1], goal = 2
// Initialize map with {0, 1}, sum = 0, count = 0
// For the first element 1, update sum to 1. Since sum - goal = -1 is not in map, do nothing
// For the second element 0, update sum to 1. Since sum - goal = -1 is not in map, do nothing
// For the third element 1, update sum to 2. sum - goal = 0 is found in map with frequency 1. Increment count by 1
// For the fourth element 0, update sum to 2. sum - goal = 0 is found in map with frequency 1. Increment count by 1
// For the fifth element 1, update sum to 3. sum - goal = 1 is found in map with frequency 2. Increment count by 2
// Return count = 4

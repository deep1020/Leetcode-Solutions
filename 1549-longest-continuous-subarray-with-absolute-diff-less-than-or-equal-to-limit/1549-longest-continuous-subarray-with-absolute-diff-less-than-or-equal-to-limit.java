class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int left=0;
        int maxLength=0;
        for(int right=0;right<nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.lastKey() - map.firstKey() > limit){
                map.put(nums[left],map.getOrDefault(nums[left],0)-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;        
    }
}
// T.C -> O(nlogn) where n= number of elements in a map. Both insertion and deletion operations in a TreeMap take O(logn) time. Right pointer moves from 0 to nums.length - 1, which takes O(n) time.
// S.C -> O(n) TreeMap stores at most n elements.

// TreeMap: store the frequency of each sorted element in the current window.
// left: left boundary of sliding window
// maxLength: keeps track of the maximum length of a valid subarray found so far.
// for loop iterates over nums array using the right pointer, which expands window.
// Each time a new element nums[right] is added to the TreeMap, its frequency is updated.
// After adding a new element, the code checks if the current window is valid by comparing the difference between the maximum and minimum elements in the TreeMap (map.lastKey() - map.firstKey()).
// If the difference exceeds the limit, the window is invalid. The while loop then contracts the window by moving the left pointer to the right and updating TreeMap accordingly (removing elements that are no longer in the window).
// Once a valid window is found, maxLength is updated to the maximum length of the valid window seen so far.
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
// T.C -> O(n) where n= size of nums array
// S.C -> O(k) where k= HashSet of size k

// 1) Initializes a HashSet set to store elements and encountered duplicate while iterating through the nums array.
// 2) Iterates through the nums array using a for loop, with the index variable i.
// 3) For each element nums[i] encountered in the iteration:
// - It checks if the set already contains the current element nums[i]. If it does, it means that a 
//   duplicate element exists within the range of k, so the function returns true.
// - It adds the current element nums[i] to the set.
// - It checks if the size of the set has exceeded k. If it has, it means that
//   sliding window size (the range of k) has been reached, so it removes the element at index i - k from the set. 
//   This ensures that the set only contains elements within the sliding window.
// 4) If no duplicate elements are found within the range of k during the iteration, the method returns false.
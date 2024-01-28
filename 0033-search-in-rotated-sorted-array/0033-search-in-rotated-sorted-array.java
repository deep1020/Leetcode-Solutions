class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[left]<=nums[mid]){
                if(nums[left]<=target && target<nums[mid]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            else{
                if(nums[mid]<target && target<=nums[right]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}
// T.C -> O(logn)
// S.C -> O(1) constant amount of space to store our variables (left,right,mid) regardless of the size of the input array.

// Perform Binary Search within a while loop until left exceeds right. In each iteration, we calculate midpoint left and right.
// At any point during the search in the rotated array, one half(either left or right) will always be sorted
// To figure out which half is sorted, take 2 scenarios.
// 1) If left half [low...mid] is sorted: we get this if element at left <= element at mid i.e all elements till midpoint are in the correct increasing order. If target lies within sorted left half, we get this if element at left <= target and element at target < element at mid, move our search to this half (i.e update right to mid-1). Otherwise target must be in right half so update left to mid+1.
// 2) If right half [mid...right] is sorted: If left half is not sorted, right half must be sorted. If target lies within sorted right half, we get this if mid element < target and target <= element at right, move our search to this half (i.e update left to mid+1). Otherwise target must be in left half so update right to mid-1.



class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length=nums.length;
        int result[]=new int[length];
        int left[]=new int[length];
        int right[]=new int[length];
        left[0]=1;
        for(int i=1;i<length;i++){
            left[i]=left[i-1]*nums[i-1];
        }
        right[length-1]=1;
        for(int i=length-2;i>=0;i--){
            right[i]=right[i+1]*nums[i+1];
        }
        for(int i=0;i<length;i++){
            result[i]=left[i]*right[i];
        }
        return result;
    }
}
// T.C -> O(n) where n is the length of the input array nums
// S.C -> O(n) for the additional arrays left, right, and result

// nums=[1,2,3,4]
// 1) Initialize left = [1, 1, 1, 1] and right = [1, 1, 1, 1].
// 2) Calculate left array:
//    left[1] = left[0] * nums[0] = 1 * 1 = 1
//    left[2] = left[1] * nums[1] = 1 * 2 = 2
//    left[3] = left[2] * nums[2] = 2 * 3 = 6
// 3) Calculate right array:
//    right[2] = right[3] * nums[3] = 1 * 4 = 4
//    right[1] = right[2] * nums[2] = 4 * 3 = 12
//    right[0] = right[1] * nums[1] = 12 * 2 = 24
// 4) Calculate result array:
//    result[0] = left[0] * right[0] = 1 * 24 = 24
//    result[1] = left[1] * right[1] = 1 * 12 = 12
//    result[2] = left[2] * right[2] = 2 * 4 = 8
//    result[3] = left[3] * right[3] = 6 * 1 = 6
// Final result is [24,12,8,6]

// Easy approach
// int n = nums.length;
// int ans[] = new int[n];
// int pro = 1;
// for(int i : nums) {
//     pro *= i;
// }
// for(int i = 0; i < n; i++) {
//     ans[i] = pro / nums[i];
// }
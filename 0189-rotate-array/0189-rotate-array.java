class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        if(k>0){
            reverse(nums,0,nums.length-1);
            reverse(nums,0,k-1);
            reverse(nums,k,nums.length-1);
        }     
    }
    public void reverse(int nums[],int left, int right){
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}
// T.C -> O(n) n elements reversed 3 times
// S.C -> O(1)

// Ex: [1,2,3,4,5,6,7] k=3
// rotate function
// 1) reverse whole array [7,6,5,4,3,2,1]
// 2) reverse 0  to k-1 [5,6,7,4,3,2,1]
// 3) reverse k to last element [5,6,7,1,2,3,4]

// reverse function - Use two pointers
// 1) swap left and right most element
// 2) Increment left by 1 and decrement right by 1
// 3) repeat steps 1 and 2 until left and right at same position

// corner case - when k>array length i.e ArrayIndexOutOfBoundsException
// k=k%nums.length if k>0 rotate operations perform else default array return
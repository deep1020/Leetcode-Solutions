class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        // Loop for positive numbers from 1 to array size + 1
        int i=1;
        while(i<nums.length+1){
            if(set.contains(i)){
                i++;
            }
            else{
                return i;
            }
        }
        return nums.length+1;
    }
}
// T.C -> O(n)
// S.C -> O(n)

// If given array is [1,2,3] then it return -1 so we need to use while loop to iterate for undefined times. 
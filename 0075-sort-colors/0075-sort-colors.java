class Solution {
    public void sortColors(int[] nums) {
        int freq[]=new int[3];
        for(int num:nums){
            freq[num]++;
        }
        int index=0;
        for(int i=0;i<3;i++){
            while(freq[i]-- > 0){
                nums[index++]=i;
            }
        }
    }
}
// T.C -> O(n) first loop iterates through the nums array once to count the occurrences of each color.
// second loop iterates through the frequency array (which has a fixed length of 3) and uses a nested loop to overwrite the nums array with sorted values.
// S.C -> O(1) freq array has fixed size of 3
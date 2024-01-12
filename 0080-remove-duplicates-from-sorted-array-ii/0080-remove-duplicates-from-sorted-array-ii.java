class Solution {
    public int removeDuplicates(int[] nums) {
        int count=0;
        int idx=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
                nums[idx++]=nums[i];
            }
            else if(map.get(nums[i])==1){
                map.put(nums[i],2);
                nums[idx++]=nums[i];
            }
            else{
                count++;
            }   
        }
        return nums.length-count;
    }
}
// T.C -> O(n)
// S.C -> O(n)

// Iterate through all elements in nums[]
// If number is not present in map, add it with value 1
// Update the array 'nums' at the current index 'idx' and increment 'idx'
// If the number is present with value 1 in the map, update its value to 2
// Again update the array 'nums' at the current index 'idx' and increment 'idx'
// If the number is present with value 2 in the map, increment the 'count' as we are not considering elements that appear more than twice and here counter will help to adjust the size of array
// Finally return the length of the modified array (original length minus the count of duplicates)
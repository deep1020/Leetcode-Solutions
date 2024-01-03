class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[1]=i;
                result[0]=map.get(target-nums[i]);
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
// T.C -> O(n) loop goes through n elements
// S.C -> O(n) number of elements stored in HashMap

// loop through each number in our array and first we are going to check whether that number already exist as a key in our map and if it does then we know that we have found our match and in that case we just need to return the indices of those two numbers so one of them is the index of the current number that we are looping through and then the index of the other number that we need to return is just going to be stored at that location in our map

// {5,2,4} target=6
// key -> value
// 1 -> 0(index) (key=target-current number)
// Next number 2. check 2 already exist as a key in our map
// what number would we have to add to 2 to get to 6 which is 4
// 4 -> 1(index) (key=6-2=4)
// Here 4 already exist as a key in our map then return value associated with that key
// index of the number we are looking at (index 2) and the index that we find when we look up that number
// index that we find when we loop up that number in our map. we loop up 4 as a key in our map and we get index 1
// return {2,1}
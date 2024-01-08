class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> resultList=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                resultList.add(nums[i]);
            }
            else{
                set.add(nums[i]);
            }
        }
        return resultList;
    }
} 
// T.C -> O(n)
// S.C -> O(1)
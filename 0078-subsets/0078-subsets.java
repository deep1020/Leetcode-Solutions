class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList=new ArrayList<>();
        backtrack(resultList,new ArrayList<>(),nums,0);
        return resultList;
    }
    public void backtrack(List<List<Integer>> resultList,List<Integer> tempList,int nums[],int start){
        resultList.add(new ArrayList<>(tempList));
        for(int i=start;i<nums.length;i++){
            tempList.add(nums[i]);
            backtrack(resultList,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
// T.C -> O(2^n) perform 2^n operations
// S.C -> O(2^n) In the worst case, if we have 'n' distinct numbers, there would be 2^n subsets

// For each element in the array, there are two choices: either include it in the subset or exclude it
// Recursive backtrack function explores all possible combinations of elements
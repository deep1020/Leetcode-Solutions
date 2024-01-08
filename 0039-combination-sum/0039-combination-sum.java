class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList=new ArrayList<>();
        backtrack(resultList,new ArrayList<>(),candidates,target,0);
        return resultList;
    }
    public void backtrack(List<List<Integer>> resultList,List<Integer> tempList,int candidates[],int target,int start){
        if(target<0){
            return;
        }
        if(target==0){
            resultList.add(new ArrayList<>(tempList));
        }
        for(int i=start;i<candidates.length;i++){
            tempList.add(candidates[i]);
            System.out.println(target);
            backtrack(resultList,tempList,candidates,target-candidates[i],i); 
            tempList.remove(tempList.size()-1);
        }
    }
}

// In recursive backtrack methos, do not increment i because we need to reuse same element
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultList=new ArrayList<>();
        backtrack(resultList,new ArrayList<>(),n,k,1);
        return resultList;
    }
    public void backtrack(List<List<Integer>> resultList,List<Integer> tempList,int n,int k,int num){
        if(tempList.size()==k){
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=num;i<=n;i++){
            tempList.add(i);
            backtrack(resultList,tempList,n,k,i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
// T.C -> O(n!) generates all combinations of k elements out of n elements.
// S.C -> O(k) recursion stack is k because the algorithm is selecting k elements in each combination.
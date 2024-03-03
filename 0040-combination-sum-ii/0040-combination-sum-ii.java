class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> resultList=new ArrayList<>();
        backtrack(resultList,new ArrayList<>(),candidates,target,0);
        return resultList;
    }
    public void backtrack(List<List<Integer>> resultList,List<Integer> tempList,int candidates[],int target,int start){
        if(target==0){
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            tempList.add(candidates[i]);
            backtrack(resultList,tempList,candidates,target-candidates[i],i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}

// Time Complexity:
//  1. The length of the potential combinations can vary from 1 to k where k = min(T/M , N).
//  2. Total number of combinations of size k is C(N,k) and time to add each such combination in the result list is O(K).
//  Therefore the total time complexity will be O(1*C(N,1) + 2*C(N,2) + ... + k*C(N,k))
//                                               = (i = 1 -> k) ∑ (i * C(N, i)).
//  If k = N, then above time complexity becomes O(N * 2^(N-1))

//  Space Complexity: O(min(T/M , N))
//  N = Length of input array. T = Target. M = Minimum value in the input array.
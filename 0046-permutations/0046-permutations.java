class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList=new ArrayList<>();
        backtrack(resultList,new ArrayList<>(),nums);
        return resultList;
    }
    public void backtrack(List<List<Integer>> resultList,List<Integer> tempList,int nums[]){
        if(tempList.size()==nums.length) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!tempList.contains(nums[i])){
                tempList.add(nums[i]);
                backtrack(resultList,tempList,nums);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
// T.C -> O(n*n!) perform n! operations (since there are n! permutations for n numbers) and for each operation, we spend O(n) time for slicing the list in our recursive call.
// S.C -> O(n*n!) In the worst case, if we have 'n' distinct numbers, there would be n! permutations. Each permutation is a list of 'n' numbers.
// Permutation formula -> nPr ->  n!÷(n-r)! where n= total no. of objects and r= no. of objects selected

// you cannot have an arrangement where you are taking an element more than one time. Ex: [3,3,1],[3,3,1,2]
// once the element is taken up, we will remove it as you cannot take duplicate element and you cannot exceed the total length of the original array

// Backtracking
// Create an empty List 'resultList'
// Try to generate all permutations using backtrack helper method. 
// Call backtrack helper method with resultList which keep on adding all permutations to it. Then pass an empty list to begin a new empty list. Then pass an array that will help to backtrack. Once backtrack method is complete, simply return a resultList.
// In Backtrack method, we will iterate over each element. For each element, start to pick 1st element and place at 1st place. Now one of elements is taken up, pick 2nd element and remove 1st element for the next recursive call stack. Here we cannot add single element twice. If we get the same number, skip it and move to the next element.
// when length will reach size of array, we will stop adding elements and return it.

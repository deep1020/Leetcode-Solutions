class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                int low=i+1;
                int high=nums.length-1;
                while(low<high){
                    int sum=nums[low]+nums[high]+nums[i]; // Initialize sum inside while as it will work for the end to start elements in array Ex: nums=[1,-1,-1,0] output:[] expected output:[-1,0,1]
                    if(sum<0){
                        low++;
                    }
                    else if(sum>0){
                        high--;
                    }
                    else{
                        resultList.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        low++;
                        high--;
                        // corner case: nums=[1,-1,-1,0] output:[] expected output:[-1,0,1]
                        while(low<high && nums[low]==nums[low-1]){
                            low++;
                        }
                        while(low<high && nums[high]==nums[high+1]){
                            high--;
                        }
                    }
                }
            }
        }
        return resultList;
    }   
}
// T.C -> O(nlogn+n^2) = O(n^2)
// S.C -> O(1) No. of unique triplets for storing the resultList

// Sort the input array nums in ascending order. This allows us to easily eliminate duplicate values and manipulate the pointers
// Iterate over sorted array using for loop and it goes till nums.length-2 otherwise it will give ArrayIndexOutOfBoundsException
// condition: i==0 ||  (i>0 && nums[i]!=nums[i-1])
// Initialize two pointers: low pointing to the element after i and high pointing to the last element in array
// While loop with condition low<high. This loop will continue until the pointers meet
// Calculate the sum of the elements at indices i,low,high: sum = nums[i]+nums[low]+nums[high]
// If sum is less than zero, increment low to move towards higher values.
// If sum is greater than zero, decrement high to move towards lower values.
// If sum is equal to zero, we have found a valid triplet. Create a tempList and store the values nums[i], nums[low], and nums[high] in it. Add temp to the final resultList.
// Increment low and decrement high to continue searching for more triplets.
// Handle duplicate values by skipping over them. If low is still less than high and the current element is the same as the previous element, increment low and decrement high again.
// After all iterations, return the resultList.
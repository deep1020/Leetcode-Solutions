class Solution {
    public int lengthOfLIS(int[] nums){
        int result[]=new int[nums.length];
        int len=0;
        for(int num:nums){
            int i=binarySearch(result,0,len,num);
            result[i]=num;
            if(i==len){
                len++;
            }
        }
        return len;
    }
    private int binarySearch(int[] nums,int left,int right,int target){
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            } 
            else{
                right=mid;
            }
        }
        return left;
    }
}
// T.C -> O(nlogn) use binary search within a loop to find appropriate position to update result array of length n
// S.C -> O(n)
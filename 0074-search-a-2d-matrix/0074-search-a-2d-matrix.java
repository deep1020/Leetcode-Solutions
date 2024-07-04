class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int arr[]:matrix){
            if(binarySearch(arr,target)){
                return true;
            }
        }
        return false;
    }
    public boolean binarySearch(int arr[],int target){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target){
                return true;
            }
            else if(target<arr[mid]){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return false;
    }
}
// T.C -> O(m*logn)
// S.C -> O(1) It uses a constant amount of extra space, regardless of the size of the input matrix. The space used is for variables left, right, and mid which don't depend on the size of the input.
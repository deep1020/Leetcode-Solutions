class Solution {
    public int[] sortArray(int[] nums) {
        divide(nums);
        return nums;
    }
    private void divide(int arr[]){
        if(arr.length>1){
            int mid= arr.length/2;
            int left[]= Arrays.copyOfRange(arr,0,mid);
            int right[]=Arrays.copyOfRange(arr,mid,arr.length);
            divide(left);
            divide(right);
            merge(arr,left,right);
        }
    }
    private void merge(int arr[],int left[],int right[]){
        int i=0,j=0,k=0;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                arr[k++]=left[i++];
            }
            else{
                arr[k++]=right[j++];
            }
        }
        while(i<left.length){
            arr[k++]=left[i++];
        }
        while(j<right.length){
            arr[k++]=right[j++];
        }
    }
}
// T.C -> O(nlogn)
// S.C -> O(n)
// Easy Merge Sort Approach -> Use Arrays.copyOfRange()
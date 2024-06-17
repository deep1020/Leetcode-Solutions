class Solution {
    public boolean judgeSquareSum(int c) {
        int left=0;
        long right=(long)Math.sqrt(c);
        while(left<=right){
            long sum=left*left+right*right;
            if(sum==c){
                return true;
            }
            else if(sum<c){
                left++;
            }
            else{
                right--;
            }
        }
        return false;
    }
}
// T.C -> O(sqrt(c)) where c= non-negative integer
// S.C -> O(1) no extra space is required
class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            else if(digits[i]==9){
                digits[i]=0;
            }
        }
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
}
// T.C -> O(n) iterate through the array of digits once
// S.C -> O(n) create new array with a length more than original array 
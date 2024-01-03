class Solution {
    public boolean isPalindrome(int x) {
       int rem,sum=0,temp=x;
        while(x>0) {
            rem=x%10;
            sum=sum*10+rem;
            x=x/10;
        }
        if(temp==sum){
            return true;    
        }
        return false;
    }
}
// T.C -> O(n)
// S.C -> O(1)

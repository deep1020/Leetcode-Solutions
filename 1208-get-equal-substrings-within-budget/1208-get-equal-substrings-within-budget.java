class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left=0;
        int currCost=0;
        int result=0;
        for(int right=0;right<s.length();right++){
            currCost+=Math.abs(s.charAt(right)-t.charAt(right));
            while(currCost>maxCost){
                currCost-=Math.abs(s.charAt(left)-t.charAt(left));
                left++;
            }
            result=Math.max(result,right-left+1);
        }
        return result;
    }
}
// Sliding window approach (two pass)
// T.C -> O(n) Each character in the string is processed at most twice, once by the right pointer and once by the left pointer.
// S.C -> O(1) No additional space is used.

// Dry run for: Input: s = "abcd", t = "bcdf", maxCost = 3
// Iteration
// 1. left=0, right=0, s[right]='a', t[right]='b', abs(s[right]-t[right])=1, currCost=1, result=max(0,0-0+1)=1
// 2. left=0, right=1, s[right]='b', t[right]='c', abs(s[right]-t[right])=1, currCost=2, result=max(1,1-0+1)=2
// 3. left=0, right=2, s[right]='c', t[right]='d', abs(s[right]-t[right])=1, currCost=3, result=max(2,2-0+1)=3
// 4. left=0, right=3, s[right]='d', t[right]='f', abs(s[right]-t[right])=2, currCost=5, 
// currCost>maxCost -> s[left]='a', t[left]='b', abs(s[left]-t[left])=1
// 4. left=1, right=3, s[left]='b', t[left]='c', abs(s[left]-t[left])=1, currCost=4
// 5. left=2, right=3, s[left]='c', t[left]='d', abs(s[left]-t[left])=1, currCost=3, result=max(3,3-2+1)=3
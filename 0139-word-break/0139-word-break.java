class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true; // Empty string is always valid
        for(int i=1;i<=s.length();i++) {
            for (int j=0;j<i;j++) {
                if (dp[j] && wordSet.contains(s.substring(j,i))) {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
// T.C -> O(n^2) where n= length of input string s
// Iterate over each index i from 1 to s.length(), and for each index, we iterate over each index j from 0 to i-1. 
// This results in nested loops

// S.C -> O(n+m) where n= length of input string s and m= size of the wordDict.
// It uses a boolean array dp of size s.length() + 1 to store whether a substring ending at index i is valid.

// 1) create a Set wordSet to store all words in wordDict for fast lookup.
// 2) Initialize a boolean array dp of size s.length() + 1 to store whether a substring ending at index i is valid.
// 3) set dp[0] = true because an empty string is always valid.
// 4) Iterate over each index i from 1 to s.length() and for each index, we iterate over each index j from 0 to i-1.
// 5) If dp[j] is true (meaning substring from 0 to j is valid) and the substring from j to i exists in wordSet, 
// mark dp[i] as true.
// 6) Return dp[s.length()], which indicates whether the entire string s can be segmented into words from wordDict.
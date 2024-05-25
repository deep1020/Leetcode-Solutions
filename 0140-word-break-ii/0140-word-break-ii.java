class Solution {
    List<String> list=new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        backtrack(s,wordDict,0,"");
        return list;
    }
    public void backtrack(String s,List<String> wordDict,int idx,String currStr){
        if(idx==s.length()){ // Base case
            list.add(currStr);
            return;
        }
        for(String str:wordDict){
            int str_len=str.length();
            if(s.length()>=str_len+idx){
                String sub_str=s.substring(idx,idx+str_len);
                if(sub_str.equals(str)){
                    if(currStr.length()==0){
                        backtrack(s,wordDict,str_len+idx,str);
                    }
                    else{
                        backtrack(s,wordDict,str_len+idx,currStr+" "+str);
                    }
                }
            }
        }
    }
}

// T.C -> O(2^n) explores all possible ways to break the string into words. recursion tree has 2^n n leaf nodes, resulting in an exponential time complexity.
// S.C -> O(2^n) recursion stack can grow up to a depth of n and there are 2^n possible combinations of splits.

// Aim: Find all possible ways to segment the string s into space-separated sequences of one or more dictionary words from wordDict
// ArrayList is used to store all the valid segmentations.
// The wordBreak method initializes the backtracking process by calling the backtrack method with the initial parameters.
// Backtracking Method:
// Base Case: If idx (current position in the string) is equal to the length of s, it means we have successfully segmented the entire string. The current segmentation (currStr) is added to the list and return from backtrack method.
// Iterating through wordDict: For each word in wordDict, it checks if the word matches the substring starting at idx.
// Check Length and Substring: If the remaining part of s is at least as long as the word, it checks if the substring of s starting from idx and of length equal to the word matches the word.
// Recursive Call: If it matches, it makes a recursive call to backtrack with the new index (idx + str_len) and the updated current string (currStr with the added word).
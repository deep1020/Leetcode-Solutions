class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        List<String> substr=new ArrayList<>();
        backtrack(s,0,substr,result);
        return result;
    }
    public void backtrack(String s,int idx,List<String> substr,List<List<String>> result){
        if(idx==s.length()){ // Base case
            result.add(new ArrayList<>(substr));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s,idx,i)){
                substr.add(s.substring(idx,i+1));
                backtrack(s,i+1,substr,result);
                substr.remove(substr.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false; 
            }
            start++;
            end--;
        }
        return true;
    }
}
// T.C -> O(2^n) Backtracking Search Space - In the worst case, we have to explore every possible partition of the string s. For a string of length n, there are 2^n-1 potential way to partition string. It checks each space between characters can either be a partition point or not. Function isPalindrome checks if a substring is a palindrome. This takes O(n) time in the worst case.
// S.C -> O(2^n) The depth of the recursion can go up to n (the length of the string).

// substr: This list holds the current list of substrings in a specific partitioning. In the worst case, it can hold up to n strings.
// result: This list holds all the palindrome partitions found. In the worst case, it can hold up to 2^n partitions, and each partition can have up to n substrings.

// Backtracking: It explores all possible partitions of the string which generate substrings starting from each index and checking if the substring is a palindrome.
// Base case: When index is equal to the length of the string, we have considered all characters, so we add the partition substr to the result.
// Recursive case: Iterate through possible substrings, check if they are palindromes, and recursively partition the rest of the string.
// Without the substr.remove(substr.size() - 1), substr list would not be correctly backtracked, it would include substrings that is already belong to previous recursive calls. This would lead to incorrect partitions being generated.
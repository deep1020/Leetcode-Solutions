class Solution {
    static String keypad[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> comb=new ArrayList<>();
        if(digits.length()!=0){
            printComb(digits,0,"",comb);
        }
        return comb;
    }
    public static void printComb(String str,int idx,String combination,List<String> comb){
        if(idx==str.length()){
            System.out.println(combination);
            comb.add(combination);
            return;
        }   
        char currChar=str.charAt(idx);
        String mapping=keypad[currChar-'0'];
        for(int i=0;i<mapping.length();i++){
            printComb(str,idx+1,combination+mapping.charAt(i),comb);
        }
    }
}
// T.C -> O(4^n*n) n= length of input string 'digits'. Each digit in the input string can represent up to 4 letters (the maximum number of letters associated with a digit on a keypad), and the code explores all possible combinations.
// S.C -> O(n) space used by the call stack during the recursive calls

// keypad array -> map each digit from 0 to 9 to a string of letters associated with that digit. Ex: keypad[2] is "abc" keypad[3] is "def" 
// Initializes an empty list (comb) to store the generated combinations.
// Checks if the input digits string is not empty. If not, it calls the printComb method to start generating combinations.
// printComb is recursive method for generating letter combinations
// Base case -> if the index idx has reached the end of the input string (str). If true, it means a valid combination has been formed, so it adds the combination to the list comb and returns.
// If the base case is not met, the method retrieves the current character (currChar) from the input string at index idx. It then looks up the corresponding mapping of letters for that digit from the keypad array. The method recursively calls itself for each letter in the mapping, updating the combination and increasing the index idx.
// keypad[currChar - '0'] -> characters are represented as Unicode values. It converts the character digit to its corresponding integer value. Ex: if currChar is '2', keypad[currChar - '0'] would give the string "abc" because '2' corresponds to the index 2 in the array.
// The recursion continues until it reaches the base case for each branch of the recursion.
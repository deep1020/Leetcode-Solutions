class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb=new StringBuilder(s);
        while(sb.indexOf(part)!=-1){
            int start=sb.indexOf(part);
            sb.delete(start,start+part.length());
        }
        return sb.toString();
    }
}
// T.C -> O((n-m)*m) where n=length of original string s and m=length of substring 'part'
// S.C -> O(n) where n=length of original string used in StringBuilder

// 1. Initialize a StringBuilder sb with the value of the input string s.
// 2. Use a while loop to repeatedly search for the part string in sb.
// 3. Inside the loop, find the index of the first occurrence of the part string using the indexOf() method.
// 4. If the part string is found (index is not -1), use the delete() method of StringBuilder to remove the substring starting from the found index and with a length equal to the length of the part string.
// 5. Repeat steps 3-4 until the part string is no longer found in sb.
// 6. Return the resulting string obtained from the StringBuilder by calling toString().
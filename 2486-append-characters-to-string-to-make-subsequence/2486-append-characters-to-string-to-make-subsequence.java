class Solution {
    public int appendCharacters(String s, String t) {
        int sIndex=0,tIndex=0;
        while(sIndex<s.length() && tIndex<t.length()){
            if(s.charAt(sIndex)==t.charAt(tIndex)){
                tIndex++;
            }
            sIndex++;
        }
        return t.length()-tIndex;
    }
}
// T.C -> O(m+n) where m= length of s and n= length of t
// S.C -> O(1)
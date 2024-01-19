class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        Map<Character,Integer> map=new HashMap<>();
        int maxLength=0;
        int start=0;
        for(int end=0;end<s.length();end++){
            char curr_char=s.charAt(end);
            if(map.containsKey(curr_char)){
                start=Math.max(start,map.get(curr_char)+1);
            }
            map.put(curr_char,end);
            maxLength=Math.max(maxLength,end-start+1);
        }
        return maxLength;
    }
}
// T.C -> O(n) index end will iterate n times
// S.C -> O(n)

// we will store character along with its index into the map. when we encounter repeating character, simply look up into hashmap and figure out when the repeating character last occured so that we can start our new substring from a index just after that. As soon as we encounter repeating character, calculate length (end-start+1) throughout all characters and whichever we get maximum length, return maxLength
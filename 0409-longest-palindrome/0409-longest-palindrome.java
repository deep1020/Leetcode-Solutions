class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int odd_count=0;
        int even_count=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            int freq=entry.getValue();
            if(freq>1){
                even_count+=(freq/2)*2;
            }
            if(freq%2==1){
                odd_count=1;
            }
        }
        return even_count+odd_count;
    }
}
// T.C -> O(n) store frequency of characters
// S.C -> O(1) store atmost 52 unique characters
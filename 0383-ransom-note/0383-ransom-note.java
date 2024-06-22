class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:magazine.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:ransomNote.toCharArray()){
            if(!map.containsKey(ch) || map.get(ch)==0){
                return false;
            }
            map.put(ch,map.get(ch)-1);
        }
        return true;
    }
}
// T.C -> O(n+m) where n= length of ransomnote string and m= length of magazine string, Iterate through each character in both strings once
// S.C -> O(m) where m= number of unique characters in magazine string. We store character counts in HashMap.

// HashMap: store the count of each character in the magazine string.
// First for loop iterates through each character ch in the magazine string. For each character, it updates the count in the map. If the character is not already in the map, it initializes the count to 1, otherwise, it increments the existing count.
// second for loop iterates through each character ch in the ransomNote string. For each character, it checks if the character exists in the map and if the count is equal to 0.
// If the character is not present in the map or its count is 0, it returns false because it means the ransomNote cannot be constructed using the characters from the magazine.
// If the character is present and the count is greater than 0, it decrements the count of the character in the map by 1.
// If all characters in the ransomNote can be matched and decremented in the map, the function returns true, indicating the ransomNote can be constructed from the magazine.
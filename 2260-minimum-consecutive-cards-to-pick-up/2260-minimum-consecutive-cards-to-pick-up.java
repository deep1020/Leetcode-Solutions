class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer,Integer> map=new HashMap<>();
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<cards.length;i++){
            if(map.containsKey(cards[i])){
                ans=Math.min(ans,i-map.get(cards[i])+1);
            }
            map.put(cards[i],i);
        }
        return ans==Integer.MAX_VALUE?-1 : ans;
    }
}
// T.C -> O(n) where n=length of cards array
// S.C -> O(n) In the worst-case, where all card values are unique, the HashMap could store n entries.

// Initializes an integer variable min to Integer.MAX_VALUE. 
// It will store the minimum number of card picks needed to remove duplicates

// Ex: cards[i]=[3,4,2,4,3,7]
// Key->cards[i], value->index i
// Add in map (3,0)
// Add in map (4,1)
// Add in map (2,2)
// 4 contains in map, find idx=i-map.get(cards[i])+1 =3-map.get(cards[3])+1 =3-map.get(4)+1 =3-1+1 =3
// ans=3
// Add in map (4,3)
// 3 contains in map, find idx=i=map.get(cards[i])+1 =4-map.get(cards[4])+1 =4-map.get(3)+1 =4-0+1 =5
// ans=5
// Add in map (3,5)
// Add in map (7,6)
// return ans=Math.min(3,5)=3

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int arr:hand){
            map.put(arr,map.getOrDefault(arr,0)+1);
        }
        if(hand.length % groupSize!=0){ // Base case
            return false;
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int key=entry.getKey();
            int freq=entry.getValue();
            if(freq==0){
                continue;
            }
            while(freq>0){
                for(int i=key;i<key+groupSize;i++){
                    if(map.getOrDefault(i,0)==0){
                        return false;
                    }
                    map.put(i,map.get(i)-1); // decrement freq by 1
                }
                freq--;
            }
        }
        return true;
    }
}
// T.C -> O(nlogn+k) where n= number of unique elements in hand and k= length of hand
// S.C -> O(n)
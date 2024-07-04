class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> list=new ArrayList<>();
        for(int num:nums2){
            if(map.containsKey(num) && map.get(num)>0){
                list.add(num);
                map.put(num,map.get(num)-1);
            }
        }
        int result[]=new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }
}
// T.C -> O(n)
// S.C -> O(n)

// map.put(num, map.get(num) - 1): updates the map by decrementing the count of the current element num by 1. This ensures that if an element appears multiple times in both arrays, it will be added to the result list the correct number of times.
// map.get(num)>0: It helps to maintain frequency of element atleast 1
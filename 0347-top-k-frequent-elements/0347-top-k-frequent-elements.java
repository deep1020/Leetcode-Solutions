class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        Queue<Integer> pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        pq.addAll(map.keySet());
        int result[]=new int[k];
        for(int i=0;i<k;i++){
            result[i]=pq.poll();
        }
        return result;
    }
}
// T.C -> O(nlogn)
// S.C -> O(n)
// Create a frequency table: (1,3),(2,2),(3,1)
// Put values in priority queue(MaxHeap): [1,2,3] Largest frequent element will be at top of queue
// Use Lambda Expression: Queue<Integer> pq= new PriorityQueue<Integer>((a, b) -> b - a);
// Put top k values in array and remove from queue

class Solution {
    public int findCenter(int[][] edges) {
        Set<Integer> set=new HashSet<>();
        for(int edge[]:edges){
            for(int i=0;i<edge.length;i++){
                if(set.contains(edge[i])){
                    return edge[i];
                }
                set.add(edge[i]);
            }
        }
        return -1;
    }
}
// T.C -> O(n) n= number of nodes in the star graph
// outer loop iterates over all the edges. If there are n-1 edges, loop runs n-1 times
// inner loop iterates twice for each edge because each edge is represented as an array of two integers
// total number of operations: number of edges multiplied by 2 gives 2*(n-1) operations
// S.C -> O(n) HashSet stores the nodes seen so far
// In the worst case, HashSet will store up to n-1 nodes.
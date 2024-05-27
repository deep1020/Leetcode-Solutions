class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int prereq[]:prerequisites){
            list.get(prereq[1]).add(prereq[0]);
        }
        // Array to track visited nodes
        boolean visited[]=new boolean[numCourses];
        // Array to track nodes currently in the recursion stack to detect cycles
        boolean path[]=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(isCyclic(i,list,visited,path)){
                return false;
            }
        }
        return true;
    }
    private boolean isCyclic(int node,List<List<Integer>> list,boolean visited[],boolean path[]){
        if(path[node]){
            return true;
        }
        if(visited[node]){
            return false;
        }
        visited[node]=true;
        path[node]=true;
        for(int neighbour:list.get(node)){
            if(isCyclic(neighbour,list,visited,path)){
                return true;
            }
        }
        // Remove the node from the recursion stack
        path[node]=false;
        return false;
    }
}
// T.C -> O(V+E)
// S.C -> O(V+E)
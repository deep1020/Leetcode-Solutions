class Solution {
    public int numIslands(char[][] grid) {
        int islandCount=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    islandCount++;
                    backtrack(grid,i,j);
                }
            }
        }
        return islandCount;
    }
    public void backtrack(char[][] grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        backtrack(grid,i+1,j);
        backtrack(grid,i-1,j);
        backtrack(grid,i,j+1);
        backtrack(grid,i,j-1);
    }
}
// T.C -> O(M * N), where M is the number of rows and N is the number of columns in the grid. Each cell is visited once.
// S.C -> O(M * N) in the worst case, considering the recursion stack. Recursion stack depth is proportional to the number of cells in the grid.

// numIslands method:
// Iterates through each cell in the 2D grid. Vertically i=0 to 3 (grid.length) and Horizontally j=0 to 5 (grid[i].length)
// For each cell, if the cell contains '1', it is considered the start of a new island. The method increments the islandCount and calls the backtrack method to mark all connected land cells as visited.
// The backtrack method is a recursive function that performs a Depth-First Search (DFS) to mark all connected land cells as visited by changing their value to '0'.

// backtrack method:
// Takes the current cell coordinates (i, j) and performs DFS to explore all connected land cells.
// Base case checks whether the current cell is out of bounds or if it is water (denoted by '0'). If true, the method returns, indicating the end of the exploration for this branch.
// If the current cell contains land ('1'), it is marked as visited by changing its value to '0'. Then, the method recursively explores all four directions (up, down, left, and right) from the current cell.
// Recursive calls continue until all connected land cells are visited.
// DFS approach explores all connected land cells and marks them as visited, ensuring that each island is counted only once.
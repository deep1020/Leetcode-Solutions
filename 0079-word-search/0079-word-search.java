class Solution {
    public boolean exist(char[][] board, String word) {
        int rowLen=board.length;
        int colLen=board[0].length;
        boolean visited[][]=new boolean[rowLen][colLen];
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                if(backtrack(board,word,i,j,0,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board,String word,int currRow,int currCol,int currIndex,boolean visited[][]){
        // Base cases
        if(currIndex==word.length()){
            return true;
        }
        if(currRow<0 || currRow>=board.length || currCol<0 || currCol>=board[0].length){
            return false;
        }
        if(board[currRow][currCol]!=word.charAt(currIndex)){
            return false;
        }
        if(visited[currRow][currCol]==true){
            return false;
        }
        visited[currRow][currCol]=true;
        // DFS for all 4 directions
        boolean word_found= backtrack(board,word,currRow+1,currCol,currIndex+1,visited) ||
                            backtrack(board,word,currRow-1,currCol,currIndex+1,visited) ||
                            backtrack(board,word,currRow,currCol+1,currIndex+1,visited) ||
                            backtrack(board,word,currRow,currCol-1,currIndex+1,visited);
        visited[currRow][currCol]=false;
        return word_found;
    }
}
// T.C -> O(4^n) worst case, each cell on the board is visited, and for each cell, the algorithm explores four directions.
// S.C -> O(n+rowLen*colLen) where n=recursive depth(length of word) and rowLen*colLen=size of visited array(number of cells on the board)

// exist method:
// Initialize rowLen and colLen then iterates through each cell on the board
// It calls the backtrack method for each cell to check if the word can be found starting from that cell

// backtrack method:
// performs a depth-first search (DFS) on the board to find the given word. It explores all possible paths by moving in all four directions (up, down, left, right) from the current cell.
// Base cases:
// If currIndex is equal to the length of the word, it means that the entire word has been found, so the method returns true.
// If currRow or currCol is out of bounds of the board, the method returns false.
// If the character in the current cell does not match the character at the current index of the word, the method returns false.
// If the current cell has already been visited, the method returns false.
// Recursive Exploration:
// Marks the current cell as visited.
// It then recursively explores each of the four directions, incrementing currIndex for each move.
// If any recursive call returns true, it means that a valid path was found, and the method returns true.
// If none of the recursive calls return true, the current cell is marked as not visited (visited[currRow][currCol] = false) to backtrack and explore other possibilities.
// Overall process continues until all cells on the board have been considered.

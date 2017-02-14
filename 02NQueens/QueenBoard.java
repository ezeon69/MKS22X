public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
	board = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public void solve(){
	solveH(0);
    }

    private void addQueen(int r, int c){
	if (board[r][c] == 0){
	    board[r][c] = 1;
	    for(int col = c; col < board.length; col++){
		board[r][col] = -1;
	    }
	    for(int row = r, col = c; col < board.length && row < board.length; col++, row++){
		board[row][col] = -1;
	    }
	    for(int row = r, col = c; col < board.length && row > 0; col++, row--){
		board[row][col] = -1;
	    }	    
	}
    }

    private void removeQueen(int r, int c){
        if (board[r][c] == 1){
	    board[r][c] = 0;
	    for(int col = c; col < board.length; col++){
		board[r][col] = 0;
	    }
	    for(int row = r, col = c; col < board.length && row < board.length; col++, row++){
		board[row][col] = 0 ;
	    }
	    for(int row = r, col = c; col < board.length && row > 0; col++, row--){
		board[row][col] = 0 ;
	    }	    
	}
    }

    // nothing = 0, queen = 1, conflict == -1
    private boolean solveH(int col){
        if (col >= board.length){
	    solutionCount++;
	    return true;
	}
        for (int row =  0; row < board.length; row++){
	    if (board[row][col] == 0){
		addQueen(row,col);
		if solveH(col + 1){
			return true;
		    }
		else{
		    removeQueen{row,col};
		}
	    }
	}
	return false;	
    }
    public void countSolutions(){

    }
    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
    	return -1;
    }
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
    	return "";
    }
}

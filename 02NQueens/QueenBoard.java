public class QueenBoard{
    public int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
	board = new int[size][size];
	solutionCount = 0;
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

    private void addQueen(int row, int col){
        for (int counter = 0; counter < Math.pow(board.length,2); counter++){
	    if (counter % board.length == col || counter / board.length == row || Math.abs(counter / board.length - row ) == Math.abs(counter % board.length - col)){
		if (board[counter / board.length][counter % board.length] != -1){
		    board[counter / board.length][counter % board.length]++;
		}
	    }
	}
	board[row][col] = -1;
    }

    private void removeQueen(int row, int col){
        board[row][col] = 0;	
	for (int counter = 0; counter < Math.pow(board.length,2); counter++){
	    if ((counter % board.length == col || counter / board.length == row || Math.abs(counter / board.length - row) == Math.abs(counter % board.length - col)) && counter != board.length * row + col){
		if (board[counter / board.length][counter % board.length ] != -1) 
		    board[counter / board.length][counter % board.length ]--;
		else
		    board[row][col]++;
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
		if (solveH(col + 1)){
			return true;
		    }
		else{
		    removeQueen(row,col);
		}
	    }
	}
	return false;	
    }
    public void countSolutions(){
	solveAll(0);
    }

    public void solveAll(int col){
	if (col >= board.length){
	    solutionCount++;
	}
	else{
	    for (int row = 0; row < board.length; row++){
		if (board[row][col] == 0){
		    addQueen(row,col);
		    solveAll(col + 1);
		    removeQueen(row,col);
		}
	    }
	}
    }
    
    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
    	return solutionCount;
    }
    
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
        String total = "";
	for (int[]row : board){
	    for (int col : row){
		if (col == -1){
		    total += "Q";
		}
		else{
		    total += "_";
		}
	    }
	    total += "\n";
	}
	return total;
    }
}

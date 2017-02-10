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
    public boolean solve()
    {
	return solveH(0);
    }

    private void addQueen(int r, int c){
	board[r][c] = 1;
    }

    private void removeQueen(int r, int c){
	board[r][c] = 0;
    }

    public void updateBoard(int r, int c){
	int counter = 1;
	while(r < board.length || c < board.length){
	    board[
    }
    // nothing = 0, queen = 1, conflict == -1
    private boolean solveH(int col){
	int x = col;
	int counter = 0;
	while (counter < board.length){
	    if (board[x][counter] == 1){
		updateBoard[x][counter];
	    }
	    
	return false;
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

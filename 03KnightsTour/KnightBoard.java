public class KnightBoard{
    public int[][] board;
    
    public KnightBoard(int startingRows,int startingCols){
	board = new int[startingRows][startingCols];
    }

    public void solve(){
	solveH(0,0,1);
    }

    private boolean noConflict(int row,int col) {
	if ((row >= 0) && (col >= 0) && (row < board.length) && (col < board[0].length)&& (board[row][col] == 0)){
	    return true;
	}
	return false;
    }
    
    // level is the # of the knight
    private boolean solveH(int row,int col,int level){
	if (level > (board.length * board[0].length)){
	    return true;
	}
	if (noConflict(row,col)){
	    board[row][col] = level;
	    if (solveH(row + 1, col + 2, level + 1) ||
		solveH(row + 2 ,col + 1, level + 1) ||
		solveH(row + 1, col - 2, level + 1) ||
		solveH(row - 1, col + 2, level + 1) ||
		solveH(row - 2, col - 1, level + 1) ||
		solveH(row - 1, col - 2, level + 1) ||
		solveH(row + 2, col - 1, level + 1) ||
		solveH(row - 2, col + 1, level + 1)) {
		return true;
	    }
	    board[row][col] = 0;
	}
	return false;
    }
    
    public boolean doubleDigit() {
	for (int r = 0; r<board.length;r++){
	    for(int c= 0; c<board[0].length; c++) {
		if (board[r][c] >= 10) {
		    return true;
		}
	    }
	}
	return false;
    }
    
    //blank if you never called solve or when there is no solution
    public String toString(){
	String total = "";
        boolean isDouble = doubleDigit();
	for (int row = 0; row < board.length; row++){
	    if (row >= 1){
		total += "\n";
	    }
	    for (int col = 0; col < board[0].length; col++){
		if (isDouble){
		    if (board[row][col] < 10){
			total += " " + board[row][col] + " ";
		    }
		    else{
			total += board[row][col] + " ";
		    }
		}
		else{
		    total += board[row][col] + " ";
		}
	    }
	}
	return total;
    }

    public static void main(String[]args){
	KnightBoard kb = new KnightBoard(7,7);
	kb.solve();
        System.out.println(kb.toString());
    }
}
    

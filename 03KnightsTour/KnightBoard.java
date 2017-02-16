public class KnightBoard{
    public int[][] board;
    
    public KnightBoard(int startingRows,int startingCols){
	board = new int[startingRows][startingCols];
    }

    public void solve(){
	solveH(0,0,1);
    }

    // level is the # of the knight
    private boolean solveH(int row,int col,int level){
	if ((row < 0) || (col < 0) || (row > board.length) || (col > board.length)){
	    return false;
	}
	if (level > (row * col)){
	    return true;
	}
	if (board[row][col] == 0){
	    board[row][col] = level;
	    if (solveH(row+1,col+2,level+1) || solveH(row-1,col-2,level+1) || solveH(row-1,col+2,level+1) || solveH(row+1,col-2,level+1) || solveH(row+2,col+1,level+1) || solveH(row-2,col-1,level+1) || solveH(row+2,col-1,level+1) || solveH(row-2,col+1,level+1)){
		return true;
	    }		
	    else if (board[row+1][col] == 0){
		solveH(row + 1,col,level + 1);
	    }
	}
	return false;
    }

    //blank if you never called solve or when there is no solution
    public String toString(){
	String total = "";
	for (int[]row : board){
	    for (int col : row){
		if (col < 10){
		    total += " " + col;
		}
		else{
		    total += "" + col;
		}
	    }
	    total += "\n";
	}
	return total;
    }

    public static void main(String[]args){
	KnightBoard kb = new KnightBoard(7,7);
	kb.solve();
        String asd = kb.toString();
	System.out.println(asd);
    }
}
    

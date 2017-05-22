public class Location implements Comparable<Location>{
    
    private int row;
    private int col;
    public Location previous;
    private int distToStart;
    private int distToGoal;
    private boolean aStar;
    
    public Location(int r, int c, Location previous, int distToStart, int distToGoal, boolean aStar){
	row = r;
	col = c;
        this.previous = previous;
        this.distToStart = distToStart;
        this.distToGoal = distToGoal;
        this.aStar = aStar;
    }
    
    private int getDTS(){
	return distToStart;
    }

    private int getDTG(){
	return distToGoal;
    }

     public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public int getPrevRow(){
        return previous.getRow();
    }

    public int getPrevCol(){
        return previous.getCol();
    }

    public boolean hasPrevious(){
        return previous != null;
    }

    public String toString(){
        return "(" + row + ", " + col + ")";
    }
    
    public int compareTo(Location Other){
        int here = getDTG();
	int there = Other.getDTG();
	if (aStar){
	    here += getDTS();
	    there += Other.getDTS();
	}
	return here - there;
    }
    
}
    

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
    
    public int getDTS(){
	return distToStart;
    }

    public int getDTG(){
	return distToGoal;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }
    
    public Location getPrev(){
	return previous;
    }
    
    public boolean hasPrevious(){
        return previous != null;
    }

    public String toString(){
        return "[" + row + ", " + col + "]";
    }
    
    public int compareTo(Location Other){
        if (aStar){
	    return getDTS() + getDTG() - (Other.getDTS() + Other.getDTG());
	}
	else{
	    return getDTG() - Other.getDTG();
	}
    }
    
}
    

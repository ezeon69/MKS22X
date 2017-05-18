public class Location implements Comparable<Location>{
    
    private int row;
    private int col;
    private Location previous;
    private int distanceToStart;
    private int distanceToGoal;
    private boolean aStar;
    
    public Location(int r, int c, Location prev, int distToStart, int distToGoal, boolean a){
	row = r;
	col = c;
	previous = prev;
	distanceToStart = distToStart;
	distanceToGoal = distToGoal;
	aStar = a;
    }
    
    private boolean getAStar(){
	return aStar;
    }
    
    private int getDTS(){
	return distanceToStart;
    }

    private int getDTG(){
	return distanceToGoal;
    }
    
    public int compareTo(Location Other){
	if (getAStar()){
	    return (Integer.compareTo(getDTS() + getDTG(), Other.getDTS() + Other.getDTG()));
	}
	else{
	    return (Integer.compareTo(getDTS(), Other.getDTS()));
	}
    }
}
    

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
	previous = previous;
	distanceToStart = distToStart;
	distanceToGoal = distToGoal;
	aStar = a;
    }
    
    public int compareTo(Location Other){
	
    }
    
    
    
}

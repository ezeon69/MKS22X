import java.util.*;
import java.io.*;

public class MazeSolver{

    private Maze board;
    private boolean animate;
    public boolean aStar;
    
    public MazeSolver(String filename){
	this(filename,false);
    }
    
    public MazeSolver(String filename, boolean animate){
	this.animate = animate;
	board = new Maze(filename);
    }
    
    public void solve(){
	solve(1);
    }
    
    public void solve(int style){
	Frontier f;
        if (style == 0){
            f = new FrontierStack();
        }
        else if (style == 1){
            f = new FrontierQueue();
        }
        else if (style == 2){
            f = new FrontierPriorityQueue(); 
        }
        else if (style == 3){
            f = new FrontierPriorityQueue();
	    aStar = true;
        }
	else{
	    throw new IndexOutOfBoundsException();
	}
        f.add(board.getStart());
	
        while (f.hasNext()){
	    
            Location l = f.next();
	    
	    if (l.getDTG() == 0){ //if done
		while (l != null){
		    board.set(l.getRow(), l.getCol(), '@');
		    if(animate){
			System.out.println(board.toString(50));
		    }
		    l = l.getPrev();
		}
		break;
	    }
	    
	    else{
		board.set(l.getRow(), l.getCol(), '.');

		for (Location next : getNear(l)){
		    f.add(next);
		    board.set(next.getRow(), next.getCol(), '?');
		}
		
		if(animate){
		    System.out.println(board.toString(50));
		}
	    }
	}
    }

    private ArrayList<Location> getNear(Location l){
	ArrayList<Location> total = new ArrayList<Location>();
	if (board.get(l.getRow() - 1 , l.getCol()) == ' '){
	    total.add(new Location(l.getRow() - 1, l.getCol(), l, superDTS(l), superDTG(l), aStar));
	}
	if (board.get(l.getRow() + 1, l.getCol()) == ' '){
	    total.add(new Location(l.getRow() + 1, l.getCol(), l, superDTS(l), superDTG(l), aStar));
	}
	if (board.get(l.getRow(), l.getCol()) - 1 == ' '){
	    total.add(new Location(l.getRow(), l.getCol() - 1, l, superDTS(l), superDTG(l), aStar));
	}
	if (board.get(l.getRow(), l.getCol()) + 1 == ' '){
	    total.add(new Location(l.getRow(), l.getCol() + 1, l, superDTS(l), superDTG(l), aStar));
	}
	return total;
    }

    private int superDTS(Location l){
	return Math.abs(board.getStart().getRow() - l.getRow()) + Math.abs(board.getStart().getCol());
    }

    private int superDTG(Location l){
	return Math.abs(board.getEnd().getRow() - l.getRow()) + Math.abs(board.getEnd().getCol());
    }
    
    public String toString(){
        return board.toString();
    }

    public String toString(int style){
	return board.toString(style);
    }

    public static void main(String[] args){
        MazeSolver s = new MazeSolver("data2.txt",true);
	s.solve(1);
	String ans = s.toString();
    }
    
}
    


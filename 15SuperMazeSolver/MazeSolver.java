import java.util.*;
import java.io.*;

public class MazeSolver{

    private Maze board;
    private boolean animate;
    
    public MazeSolver(String filename){
	this(filename,false);
    }
    
    public static void main(String[] args){
        MazeSolver ms = new MazeSolver(args[0]);
        ms.solve(Integer.parseInt(args[1]));
        System.out.println(ms);
    }
    
    public MazeSolver(String filename, boolean animate){
	this.animate = animate;
	board = new Maze(filename);
    }
    
    public void solve(){
	solve(1);
    }
    
    public void solve(int style){
	Frontier f = null;
        if (style == 0){
            f = new FrontierStack();
        }
        if (style == 1){
            f = new FrontierQueue();
        }
        if (style == 2){
            f = new FrontierPriorityQueue(); 
        }
        if (style == 3){
            f = new FrontierPriorityQueue(); 
        }
        f.add(board.getStart());

	Location l = null;
        while (f.size() > 0){

            l = f.next();
            board.set(l.getRow(), l.getCol(), '.');
            int[] end = {l.getRow(), l.getCol()};
	    
            if (distToGoal(end) == 0){
                break;
            }

            for (int[] path : findPaths(l)){
                f.add(new Location(path[0], path[1], l, distToStart(path), distToGoal(path), style == 3));
                board.set(path[0], path[1], '?');
            }
        }
	board.set(l.getRow(), l.getCol(), 'E');
        l = l.previous;
	
	while (l.hasPrevious()){
            board.set(l.getRow(), l.getCol(), '@');
            l = l.previous;
        }
        board.set(l.getRow(), l.getCol(), 'S');
    }

    private ArrayList<int[]> findPaths(Location l){
        ArrayList<int[]> total = new ArrayList<int[]>();
        int[][] possiblePaths = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        for (int[] path : possiblePaths){
            if (board.get(l.getRow() + path[0], l.getCol() + path[1] ) == ' '){
                total.add(new int[] {l.getRow() + path[0], l.getCol() + path[1]});
            }
        }
        return total;
    }

    private int distToStart(int[] path){
        return Math.abs(path[0] - board.getStart().getRow()) + Math.abs(path[1] - board.getStart().getRow());
    }

    private int distToGoal(int[] path){
        return Math.abs(path[0] - board.getEnd().getRow()) + Math.abs(path[1] - board.getEnd().getCol());

    }

    public String toString(){
        return board.toString();
    }
    
}
    


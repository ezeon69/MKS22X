import java.util.*;
import java.io.*;
import java.lang.*;

public class Maze{

    private char[][]maze;
    private boolean animate;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */

    public Maze(String filename){
	try{
	    File text = new File(filename);// can be a path"/full/path/to/file.txt" 
	    Scanner inf = new Scanner(text);
	    int lineNumber = 1;
	    int cols = inf.nextLine().length();
	    while(inf.hasNextLine()){
	        inf.nextLine();
		lineNumber++;
	    }
	    int rows = lineNumber;
	    maze = new char[rows][cols];
	    Scanner in = new Scanner(text);
	    int pos = 0;
	    while (in.hasNextLine()){
		String line = in.nextLine();
		char[] chars = line.toCharArray();
		maze[pos] = chars;
		pos++;
	    }
	    String fileText = toString();
	    if (fileText.indexOf('S') == -1 || fileText.indexOf('E') == -1){
		throw new IllegalArgumentException("Maze has no start or end");
	    }
	}
	catch (Exception e){
	    System.out.println("error");
	}	
    }

    private void wait(int millis){ //ADDED SORRY!
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
	int[] startLocation = findStart();
	//Initialize starting row and startint col with the location of the S. 
	maze[startLocation[0]][startLocation[1]] = ' ';//erase the S, and start solving!
	return solve(startLocation[0],startLocation[1]);
    }

    private int[] findStart(){
	for (int row = 0; row < maze.length; row++) {
	    for (int col = 0; col < maze[row].length; col++) {
		if (maze[row][col] == 'S'){
		    int[] startLocation = new int[2];
		    startLocation[0] = row;
		    startLocation[1] = col;
		    return startLocation;
		}
	    }
	}
	int[] placeholder = {-1,-1};
	return placeholder;
    }
    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:
      The S is replaced with '@' but the 'E' is not.
      All visited spots that were not part of the solution are changed to '.'
      All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H" + this);
            wait(20);
        }
	if (maze[row][col] == 'E'){
	    return true;
	}
	if (maze[row][col] == ' '){
	    maze[row][col] = '@';
	    if (solve(row+1,col) || solve(row,col+1) || solve(row-1,col) || solve(row,col-1)){
		return true;
	    }
	    maze[row][col] = '.';
	}
        //COMPLETE SOLVE
        return false; //so it compiles
    }

    public String toString(){
	String total = "";
	for (int row = 0; row < maze.length; row++){
	    total += "\n";
	    for (int col = 0; col < maze.length; col++){
		total += maze[row][col];
	    }
	}
	    return total;
    }
}

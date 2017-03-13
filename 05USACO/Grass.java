import java.util.*;
import java.io.*;

public class Grass{
    private int[][] grass;
    private int[][] grassTemp;
    private int steps1;
    private int steps2;

    private int steps;
    private int startRows;
    private int startCols;
    private int endRows;
    private int endCols;

    public Grass(String file) throws FileNotFoundException{
	File f = new File(file);
	
	Scanner in = new Scanner(f);
	Scanner format = new Scanner(in.nextLine());
	int rows = format.nextInt();
	int cols = format.nextInt();

	grass = new int[rows][cols];
	grassTemp = new int[rows][cols];
	steps = format.nextInt();

	for (int counter = 0; counter < rows; counter++){
	    String line = in.nextLine();
	    for (int counter2 = 0; counter2 < cols; counter2++){
		if (line.charAt(counter2) == '.'){
		    grass[counter][counter2] = 0;
		    grassTemp[counter][counter2] = 0;
		}
		else{
		    grass[counter][counter2] = -1;
		    grassTemp[counter][counter2] = -1;
		}
	    }
	}

	startRows = in.nextInt() - 1;
	startCols = in.nextInt() - 1;
	endRows = in.nextInt() - 1;
	endCols = in.nextInt() - 1;

	grass[startRows][startCols] = 1;
	steps1 = 0;
	steps2 = -1;
    }

    private boolean validTile(int rows, int cols){
	return (rows >= 0 && cols >= 0 && rows < grass.length && cols < grass[0].length);
    }

    private int newGrass(int rows, int cols, boolean other){
	if (grass[rows][cols] == -1){
	    return -1;
	}
	if (other){
	    int total = 0;
	    if (validTile(rows + 1, cols)){
		if (grass[rows + 1][cols] != -1)
		    total += grass[rows + 1][cols];
	    }
	    if (validTile(rows - 1, cols)){
		if (grass[rows - 1][cols] != -1)
		    total += grass[rows - 1][cols];
	    }
	    if (validTile(rows, cols + 1)){
		if (grass[rows][cols + 1] != -1)
		    total += grass[rows][cols + 1];
	    }
	    if (validTile(rows, cols - 1)){
		if (grass[rows][cols - 1] != -1)
		    total += grass[rows][cols - 1];
	    }
	    return total;	    
	}
	else{
	    int total = 0;
	    if (validTile(rows+ 1, cols)){
		if (grass[rows + 1][cols] != -1)
		    total += grassTemp[rows + 1][cols];
	    }
	    if (validTile(rows - 1, cols)){
		if (grass[rows - 1][cols] != -1)
		    total += grassTemp[rows - 1][cols];
	    }
	    if (validTile(rows, cols + 1)){
		if (grass[rows][cols + 1] != -1)
		    total += grassTemp[rows][cols + 1];
	    }
	    if (validTile(rows, cols - 1)){
		if (grass[rows][cols - 1] != -1)
		    total += grassTemp[rows][cols - 1];
	    }
	    return total;	    
	}
    }

    private void updateGrass(boolean b){
	if (b){
	    for (int row = 0; row < grass.length; row++){
		for (int col = 0; col < grass[row].length; col++){
		    grassTemp[row][col] = newGrass(row, col, b);
		}
	    }
	    steps2 = steps1 + 1;
	}
	else{
	    for (int row = 0; row < grass.length; row++){
		for (int col = 0; col < grass[row].length; col++){
		    grass[row][col] = newGrass(row, col, b);
		}
	    }
	    steps1 = steps2 + 1;
	}	    
    }

     public int solve(){
	boolean b = true;

	for (int counter = 0; counter < steps; counter++){
	    updateGrass(b);
	    b = !b;
	}
	
	if (steps1 > steps2){
	    return grass[endRows][endCols];
	}
	return grassTemp[endRows][endCols];
    }

    public String toString(){
	String total = "";
	for (int row = 0; row < grass.length; row++){
	    for (int col = 0; col < grass[row].length; col++){
		total += grass[row][col] + " ";
	    }
	    total += "\n";
	}
	return total;
    }
    
}

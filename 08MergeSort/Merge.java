import java.util.*;
import java.lang.*;

public class Merge{
    
    public static void mergesort(int[] data){
        int[] left = Arrays.copyofRange(data,0,data.length/2);
	int[] right = Arrays.copyofRange(data,data.length/2,data.length);
	
	if (left.length == 1 || right.length == 1){
	    merge(left[0],right[0]);
	}
		
	
    }
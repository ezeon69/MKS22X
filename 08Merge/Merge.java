import java.util.*;
import java.lang.*;

public class Merge{
    
    public static void mergesort(int[] data){
        int[] left = Arrays.copyOfRange(data,0,data.length/2);
	int[] right = Arrays.copyOfRange(data,data.length/2,data.length);
	
	if (data.length == 1){

	}
	else{
	    mergesort(left);
	    mergesort(right);
	    merge(left,right,data);	
	}
    }

    public static void merge(int[] a, int[] b, int[] destination){
	int i = 0;
	int j = 0;
	while (i < a.length && j < b.length){
	    if (a[i] < b[j]){
		destination[i + j] = a[i];
		i++;
	    }
	    else{
		destination[j + i] = b[j];
		j++;
	    }
	}

	for (int counter = i; counter < a.length; counter++){
	    destination[counter + j] = a[counter];
	}
	for (int counter = j; counter < b.length; counter++) {
	    destination[counter + i] = b[counter];
	}
    }

    public static void main (String[] args){
	int[] a = {1,4,8,51,41,75,91};
	mergesort(a);
	System.out.println(Arrays.toString(a));
    }
}

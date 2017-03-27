import java.util.*;
import java.lang.*;

public class Quick{

    public static void quicksort(int[] data){
        quickSortH(data, 0, data.length - 1);
    }

    public static void quickSortH(int[]data, int start, int end){
	if (start < end){
	    int pivot = partition(data,start,end);
	    quickSortH(data, pivot + 1, end);
	    quickSortH(data, start, pivot - 1);
	}
    }
    
    public static int quickselect(int[] data, int k){
        return quickSelectH(data, k, 0, data.length-1);
    }
    
    public static int quickSelectH(int[] data, int k, int start, int end){
	int part = partition(data, start, end);
	
        if (part > k){
	    return quickSelectH(data, k, start, part - 1);
	}
	else if (part < k){
	    return quickSelectH(data, k, part + 1, end);
	}
	return data[part];
    }    
    
    public static int partition(int[] data, int start, int end){
        int random = start + (int) (Math.random() * (end - start));
	int pivot = data[random];
	
        swap(random,start,data);
	
	int lt = start;
	int i = start;
	int j = end;
	while (i <= j){
	    if (data[i] < pivot){
		swap(i,lt,data);
		i++;
		lt++;
	    }
	    else if (data[i] == pivot){
		i++;
	    }
	    else{
		swap(i,j,data);
		j--;
	    }
	}
	return lt;
    }
	    
    private static void swap(int x, int y, int[] data){
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }
    
    public static void main(String[]args){
        int[] data = {4,7,5,1,2,8,3,6,9};
        quicksort(data);
	System.out.println(Arrays.toString(data));
    }  
}
	

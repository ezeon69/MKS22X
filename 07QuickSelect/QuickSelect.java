import java.util.*;

public class QuickSelect{

    public static int quickselect(int[] data, int k, int start, int end){
	int part = partition(data, 0, data.length);
	
        if (part == k){
	    return data[part];
	}
	if (part > k){
	    return quickselect(data, k, part - 1, end);
	}
	return quickselect(data, k, start, part - 1);
    }    
    
    public static int partition(int[] data, int start, int end){
	double randomFloat = (Math.random() * data.length);
	int random = (int) randomFloat;
	
	int pivot = data[start];
	
        swap(random,pivot,data);
	
	int lt = start;
	int i = start;
	int j = end;
	while (i <= j){
	    if (data[i] < pivot){
		lt++;
	    }
	    else if data[i] == pivot{
		    i++;
		}
	    else{
		swap(i,j,data);
		j--;
	    }
	}
	swap(start,j,data);
    }
	    
    private static void swap(int x, int y, int[] data){
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }
    
    public static void main(String[]args){
	int[] ary = {8,1,2,7,4,3,6,5};
	partition(ary,0,ary.length);
	System.out.println(Arrays.toString(ary));
    }
    
}
	

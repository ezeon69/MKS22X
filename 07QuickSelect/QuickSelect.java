import java.util.*;

public class QuickSelect{

    /*public static void quickselect(int[] data, int k){
      System.out.println(quickselectH(data, k, 0, data.length));
	}*/
    
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
	int based = end - 1;
	double randomFloat = (Math.random() * data.length);
	int random = (int) randomFloat;
	int pivotPoint = data[random];
	int temp = 0;
	
        swap(random, based, data);

	int part = start;
	for (int counter = start; counter < end - 1; counter++){
	    if (data[counter] < data[end - 1]){
		swap(part,counter,data);
		part++;
	    }
	}

	swap(part,based,data);
	return part;
    }
	    
    private static void swap(int x, int y, int[] data){
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }
    
    public static void main(String[]args){
	int[] ary = {3,8,1,2,7,3,4,3,3,3,3};
	partition(ary,0,ary.length);
	System.out.println(Arrays.toString(ary));
    }
    
}
	

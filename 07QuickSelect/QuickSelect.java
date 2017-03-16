public class QuickSelect{
    
    public static int quickselect(int[] data, int k){
        if (data.length == 1){
	    return data[0];
	}
	
	
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
    
    public static void main
    
}
	

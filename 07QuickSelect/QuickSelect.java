public class QuickSelect{

    public static int partition(int[] ary, int start, int end){
	int based = end - 1;
	float randomFloat = (Math.random() * ary.length);
	int random = (int) randomFloat;
	int pivotPoint = ary[randomIndex];
	int temp = 0;
	
        swap(random, based, ary);

	int part = start;
	for (int counter = start; counter < end - 1; counter++){
	    if (ary[counter] < ary[end - 1]){
		swap(part,counter,ary);
		part++;
	    }
	}
	swap(part,based,ary);
	return part;
    }
	    
    private static void swap(int x, int y, int[] ary){
        int temp = ary[x];
        ary[x] = ary[y];
        ary[y] = temp;
    }
}
	

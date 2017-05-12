import java.util.*;

public class MyHeap{
    
    private Integer[] data;
    private int size;
    private static int max;
    
    public MyHeap(){
	data = new Integer[10];
	size = 1;
    }

    public MyHeap(boolean t){
	this();
	if (t){
	    max = 1;
	}
	else{
	    max = -1;
	}
    }
    
    public int size(){
	return size;
    }
    
    public void add(Integer s){
	if (size == data.length){
	        resize();
	    }
        data[size] = s;
	pushUp();
	size++;
    }
    
    public void resize(){
        int counter = 0;
        Integer newArr[] = new Integer[data.length * 2];
	while (counter < data.length){
	    newArr[counter] = data[counter];
	    counter += 1;
	}
	data = newArr;
    }
    
    public Integer remove(){
        Integer total = peek();
	data[1] = data[size - 1];
	data[size] = null;
	pushDown();
	size--;
	return total;
    }

    public Integer peek(){
	return data[0];
    }

    private void pushUp(){
	int index = size();
	while (index > 1){
	    int parent = index / 2;
	    if (data[index].compareTo(data[parent]) >= 0){
		break;
	    }
	    swap(index, parent);
	    index = parent;
	}
    }

    private void pushDown(){
	int index = 1;
	while (index < size()){
	    int child = index * 2;
	    if (child > size()){
		break;
	    }
	    //take smallest child or left one
	    if (child + 1 <= size()){
		child = findMin(child, child + 1);
	    }
	    if (data[index].compareTo(data[child]) <= 0){
                break;
	    }
            swap(index,child);
            index = child;
	}
    }

    //finds min of 2 numbers within array
    private int findMin(int left, int right){
        if (data[left].compareTo(data[right]) <= 0)
            return left;
        else{
            return right;
	}
    }
	    
    private void swap(int i, int j){
	Integer temp = data[i];
	data[i] = data[j];
	data[j] = temp;
    }
    
}

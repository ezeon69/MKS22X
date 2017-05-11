import java.util.*;

public class MyHeap{
    
    private String[] data;
    private int size;
    private static int max;
    
    public MyHeap(){
	data = new String[10];
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
    
    public void add(String s){
	if (size == data.length){
	        resize();
	    }
        data[size] = s;
	pushUp();
	size++;
    }
    
    public void resize(){
        int counter = 0;
	String newArr[] = new String[data.length * 2];
	while (counter < data.length){
	    newArr[counter] = data[counter];
	    counter += 1;
	}
	data = newArr;
    }
    
    public String remove(){
	String total = peek();
	data[1] = data[size - 1];
	data[size] = null;
	pushDown();
	size--;
	return total;
    }

    public String peek(){
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
	String temp = data[i];
	data[i] = data[j];
	data[j] = temp;
    }
    
}

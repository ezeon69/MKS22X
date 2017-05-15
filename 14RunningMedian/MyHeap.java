import java.util.*;

public class MyHeap{
    
    private Integer[] data;
    private int size;
    private int max;
    
    public MyHeap(){
	data = new Integer[10];
	size = 1;
	max = 1;
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
	return size - 1;
    }
    
    public void add(int value){
	if (size == data.length){
	        resize();
	    }
        data[size] = value;
	pushUp();
	size++;
    }
    
    public void resize(){
        int counter = 0;
        Integer newArr[] = new Integer[data.length * 2];
	while (counter < data.length){
	    newArr[counter] = data[counter];
	    counter++;
	}
	data = newArr;
    }
    
    public Integer remove(){
        Integer total = peek();
	data[1] = data[size - 1];
	pushDown();
	size--;
	return total;
    }

    public Integer peek(){
	return data[1];
    }

    private void pushUp(){
	int index = size;
        while (index > 1 && data[index].compareTo(data[index / 2]) * max > 0){
	    int parent = index / 2;
	    swap(index, parent);
	    index = parent;
	}
    }

    private void pushDown(){
        int index = 1;
        while (2 * index + 1 < size){
            boolean goLeft = data[2 * index].compareTo(data[2 * index + 1]) * max > 0;
            if (goLeft){
                if (data[index].compareTo(data[2 * index] ) * max < 0){
                    swap(index, 2 * index);
                    index = 2 * index;
                }
		else if (data[index].compareTo(data[2 * index + 1] ) * max < 0) {
                    swap(index, 2 * index + 1);
                    index = 2 * index + 1;
                }
		else{
                    break;
                }
            }
	    else{
                if (data[index].compareTo(data[2 * index + 1] ) * max < 0){
                    swap(index, 2 * index + 1);
                    index = 2 * index + 1;
                }
		else if (data[index].compareTo(data[2 * index] ) * max < 0){
                    swap(index, 2 * index);
                    index = 2 * index;
                }
		else{
                    break;
                }
            }
        }
    }
	    
    private void swap(int i, int j){
	Integer temp = data[i];
	data[i] = data[j];
	data[j] = temp;
    }
    
}

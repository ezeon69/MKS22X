import java.util.*;

public class MyHeap{
    
    private ArrayList<String> data;
    private int size;
    private int max;
    
    public MyHeap(){
	data = new ArrayList<String>;
	size = 0;
	max = 1;
    }

    public MyHeap(boolean t){
	if (t){
	    new MyHeap();
	}
	else{
	    data = new ArrayList<String>;
	    size = 0;
	    max = 0;
	}
    }
    
    public int size(){
	return size;
    }
    
    public void add(String s){
	size++;
	data.add(s);
	pushUp();
    }

    public String remove(){
	String total = peek();
	data[0] = data[size];
	data[size] = null;
	size--;
	pushDown();
	return total;
    }

    public String peek(){
	return data[0];
    }

    private void pushUp(){
	int index = size();
	while (index > 1){
	    int parent = index / 2;
	    if (data[parent] >= data[index]){
		break;
	    }
	    swap(index, parent);
	    index = parent;
	}
    }

    private void pushDown(){
	int index = 1;
	while (true){
	    int child = index * 2;
	    if (child > size()){
		break;
	    }
	    if (child + 1 <= size()){
		
	    
    }

    private void swap(int i, int j){
	String temp = data[i];
	data[i] = data[j];
	data[j] = temp;
    }
    
}
